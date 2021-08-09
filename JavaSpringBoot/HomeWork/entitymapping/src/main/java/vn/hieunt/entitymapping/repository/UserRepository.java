package vn.hieunt.entitymapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.hieunt.entitymapping.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}