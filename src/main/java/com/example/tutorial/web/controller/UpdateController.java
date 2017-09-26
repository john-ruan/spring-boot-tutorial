package com.example.tutorial.web.controller;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tutorial.entity.UserStatus;
import com.example.tutorial.enums.Status;
import com.example.tutorial.service.UserStatusService;
import com.example.tutorial.web.form.StatusForm;

@Controller
public class UpdateController {

	@Autowired
	private UserStatusService userStatusService;

	@GetMapping(value = "/update")
	public String update(Model model) {
		model.addAttribute("statusList", Status.values());

		return "Update";
	}

	@PostMapping(value = "/update")
	public String submitUpdate(@Valid StatusForm statusForm, BindingResult bindingResult, Model model,
			HttpSession session) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("statusList", Status.values());

			return "Update";
		}

		UserStatus userStatus = new UserStatus();
		userStatus.setUserId(Long.valueOf((String) session.getAttribute("userId")));
		userStatus.setStatus(Status.getStatus(statusForm.getStatus()));
		if (!StringUtils.isEmpty(statusForm.getStartTime())) {
			Calendar calendar = Calendar.getInstance();
			String time[] = statusForm.getStartTime().split(":");
			calendar.set(Calendar.HOUR_OF_DAY, Integer.valueOf(time[0]));
			calendar.set(Calendar.MINUTE, Integer.valueOf(time[1]));
			userStatus.setStartTime(new Timestamp(calendar.getTimeInMillis()));
		}
		if (!StringUtils.isEmpty(statusForm.getEndTime())) {
			Calendar calendar = Calendar.getInstance();
			String time[] = statusForm.getStartTime().split(":");
			calendar.set(Calendar.HOUR_OF_DAY, Integer.valueOf(time[0]));
			calendar.set(Calendar.MINUTE, Integer.valueOf(time[1]));
			userStatus.setEndTime(new Timestamp(calendar.getTimeInMillis()));
		}
		userStatus.setCreated(new Timestamp(System.currentTimeMillis()));

		userStatusService.insertUserStatus(userStatus);

		return "redirect:/top";
	}

	@ModelAttribute
	public StatusForm statusForm() {
		return new StatusForm();
	}

}
