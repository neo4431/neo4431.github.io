package vn.hieunt.entitymapping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.hieunt.entitymapping.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
    List<Post> findByTitle(String title);
}