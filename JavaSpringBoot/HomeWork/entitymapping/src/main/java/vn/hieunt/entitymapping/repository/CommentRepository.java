package vn.hieunt.entitymapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.hieunt.entitymapping.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
}