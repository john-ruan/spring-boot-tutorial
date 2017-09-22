package com.example.tutorial.web.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class LoginForm {

	@NotBlank
	@Pattern(regexp = "[0-9]*")
	private String id;

	@NotBlank
	@Pattern(regexp = "[a-zA-Z]*")
	private String userName;

	@NotBlank
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
