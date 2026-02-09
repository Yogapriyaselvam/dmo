package com.edupath.edupath_ai.repository;

import com.edupath.edupath_ai.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
