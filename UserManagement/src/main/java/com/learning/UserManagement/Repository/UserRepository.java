package com.learning.UserManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.UserManagement.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
