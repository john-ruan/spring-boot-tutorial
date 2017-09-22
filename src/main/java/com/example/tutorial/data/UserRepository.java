package com.example.tutorial.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tutorial.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByIdAndUserName(Long id, String userName);

}
