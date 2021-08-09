package vn.hieunt.entitymapping;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javassist.NotFoundException;
import vn.hieunt.entitymapping.model.Comment;
import vn.hieunt.entitymapping.model.Post;
import vn.hieunt.entitymapping.model.User;
import vn.hieunt.entitymapping.repository.CommentRepository;
import vn.hieunt.entitymapping.repository.PostRepository;
import vn.hieunt.entitymapping.repository.UserRepository;

@DataJpaTest
public class RelationTests {
    @Autowired
    TestEntityManager tem;
    @Autowired
    UserRepository userRepo;
    @Autowired
    PostRepository postRepo;
    @Autowired
    CommentRepository commentRepo;
    private User user;
    private Post post1, post2;

    @BeforeEach
    public void beforeEachTest() {
        user = new User("Hieu", 30, "hieunt@gmail.com");
        post1 = new Post("post_title_1");
        post2 = new Post("post_title_2");
        post1.addComment(new Comment("post1_comment_1"));
        post1.addComment(new Comment("post1_comment_2"));
        post2.addComment(new Comment("post2_comment_1"));
        post2.addComment(new Comment("post2_comment_2"));
        post2.addComment(new Comment("post2_comment_3"));
        user.addPost(post1);
        user.addPost(post2);
        tem.persist(user);
        tem.flush();
    }

    @AfterEach
    public void afterEachTest() {
        tem.clear();
    }

    @Test
    public void createTest() {
        assertThat(userRepo.count()).isEqualTo(1);
        assertThat(postRepo.count()).isEqualTo(2);
        assertThat(commentRepo.count()).isEqualTo(5);
        post2.addComment(new Comment("post2_comment_4"));
        postRepo.save(post2);
        assertThat(commentRepo.count()).isEqualTo(6);
    }

    @Test
    public void findCommentTest() {
        List<Comment> comments = postRepo.findByTitle("post_title_2").get(0).getComments();
        comments.forEach(comment -> {
            assertThat(comment.getContent().contains("post2")).isTrue();
        });
    }

    @Test
    public void updateTest() throws NotFoundException {
        Optional<Post> post = postRepo.findById(1L);
        if(post.isPresent()){
            post.get().getComments().get(0).setContent("post1_updateComment");
        } else {
            throw new NotFoundException("Khong tim thay");
        }
        assertThat(commentRepo.findById(1L).get().getContent()).isEqualTo("post1_updateComment");
        // assertThat(commentRepo.findById(2L).get().getContent()).isEqualTo("post1_updateComment");
    }

    @Test
    public void deleteAndCasadeTest(){
        userRepo.delete(user);
        assertThat(userRepo.findAll().size()).isEqualTo(0);
        assertThat(postRepo.findAll().size()).isEqualTo(0);
        assertThat(commentRepo.findAll().size()).isEqualTo(0);
    }

    @Test
    public void orphanFalseTest(){
        user.removePost(post1);
        assertThat(post1).isNotNull();;
    }

    @Test
    public void lazyTest(){
    //     User userTest = tem.find(User.class, 1L);
    //    Post postTest = tem.find(Post.class, 1L);
       Comment cm = tem.find(Comment.class, 1L);
    //    System.out.println(userTest);
    //    System.out.println(postTest);
        System.out.println(cm);
    }
}