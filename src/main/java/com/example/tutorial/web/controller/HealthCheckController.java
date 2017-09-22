package com.example.tutorial.web.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HealthCheckController {

	@GetMapping(value = "/health", produces = "application/json")
	@ResponseBody
	public Map<String, String> health() {
		return Collections.singletonMap("status", "OK");
	}

}
