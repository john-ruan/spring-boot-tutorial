package com.example.tutorial.enums;

public enum Status {

	SITTING("sitting"), MEETING("meeting"), BUSY("busy"), ABSENCE("absence"), HOME("home");

	private final String label;

	private Status(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

}
