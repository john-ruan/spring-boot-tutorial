package com.example.tutorial.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tutorial.entity.UserStatus;

@Repository
public interface UserStatusRepostiory extends JpaRepository<UserStatus, Long> {

	List<UserStatus> findByUserIdOrderByCreatedDesc(Long userId);

}
