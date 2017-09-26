package com.example.tutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.example.tutorial.data.UserStatusRepostiory;
import com.example.tutorial.entity.UserStatus;

@Component
public class UserStatusService {

	@Autowired
	private UserStatusRepostiory userStatusRepostiory;

	public UserStatus findLatestUserStatus(Long userId) {
		List<UserStatus> userStatusList = userStatusRepostiory.findByUserIdOrderByCreatedDesc(userId);

		return !CollectionUtils.isEmpty(userStatusList) ? userStatusList.get(0) : null;
	}

	public void insertUserStatus(UserStatus userStatus) {
		userStatusRepostiory.save(userStatus);
	}

}
