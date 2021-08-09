package vn.hieunt.entitymapping.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String email;

    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = false,
        mappedBy = "user"
    )
    private List<Post> posts = new ArrayList<>();

    public User(String name, int age, String email){
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public void addPost(Post post){
        posts.add(post);
        post.setUser(this);
    }

    public void removePost(Post post){
        posts.remove(post);
        post.setUser(null);
    }
}