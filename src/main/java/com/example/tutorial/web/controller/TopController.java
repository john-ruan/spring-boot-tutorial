package com.example.tutorial.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.tutorial.entity.UserStatus;
import com.example.tutorial.service.UserStatusService;

@Controller
public class TopController {

	@Autowired
	private UserStatusService userStatusService;

	@GetMapping(value = "/top")
	public String top(Model model, HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		UserStatus latestUserStatus = userStatusService.findLatestUserStatus(Long.valueOf(userId));
		model.addAttribute("latestUserStatus", latestUserStatus);

		return "Top";
	}

}
