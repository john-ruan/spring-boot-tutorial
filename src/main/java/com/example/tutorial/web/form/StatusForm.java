package com.example.tutorial.web.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class StatusForm {

	@NotBlank
	private String status;

	@Pattern(regexp = "([0-1][0-9]|2[0-3]):[0-5][0-9]")
	private String startTime;

	@Pattern(regexp = "([0-1][0-9]|2[0-3]):[0-5][0-9]")
	private String endTime;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
