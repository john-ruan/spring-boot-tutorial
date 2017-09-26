package com.example.tutorial.enums;

public enum Status {

	sitting("sitting"), meeting("meeting"), busy("busy"), absence("absence"), home("home");

	private final String label;

	private Status(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

	public static Status getStatus(String label) {
		switch (label) {
		case "sitting":
			return sitting;
		case "meeting":
			return meeting;
		case "busy":
			return busy;
		case "absence":
			return absence;
		case "home":
			return home;
		default:
			return null;
		}
	}

}
