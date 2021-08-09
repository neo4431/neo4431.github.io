package vn.hieunt.entitymapping.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        mappedBy = "post"
    )
    private List<Comment> comments = new ArrayList<>();

    public Post(String title){
        this.title = title;
    }
    public void addComment(Comment comment){
        comments.add(comment);
        comment.setPost(this);
    }

    public void removeComment(Comment comment){
        comments.remove(comment);
        comment.setPost(null);
    }
}