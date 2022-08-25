package com.love2code.employeedirectory.repository;

import com.love2code.employeedirectory.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
