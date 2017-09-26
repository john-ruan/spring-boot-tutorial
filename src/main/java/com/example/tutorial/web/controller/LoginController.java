package com.example.tutorial.web.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tutorial.service.LoginService;
import com.example.tutorial.web.form.LoginForm;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@GetMapping(value = "/login")
	public String login() {
		return "Login";
	}

	@PostMapping(value = "/login")
	public String loginSubmit(@Valid LoginForm loginForm, BindingResult bindingResult, Model model,
			HttpSession session) {
		if (bindingResult.hasErrors()) {
			return "Login";
		}

		if (!loginService.canLogin(Long.valueOf(loginForm.getId()), loginForm.getUserName(), loginForm.getPassword())) {
			model.addAttribute("loginError", "Login failed.Please check your input.");

			return "Login";
		}

		session.setAttribute("userId", loginForm.getId());
		session.setAttribute("userName", loginForm.getUserName());

		return "redirect:/top";
	}

	@ModelAttribute
	public LoginForm setupLoginForm() {
		return new LoginForm();
	}

}
