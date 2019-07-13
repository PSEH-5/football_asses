package com.sapient.footballasses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.footballasses.service.FootBallAssesmentService;

@RestController
@RequestMapping("/api/v1")
public class FootBallAssesmentController {
	@Autowired
	FootBallAssesmentService service;
	@GetMapping("/welcome")
	public String getIndex() {
		return "Welcome to Sapient Assesment Test";
	}
	@GetMapping("/getCounties")
	public String getCountries(@RequestParam(name="action") String action, @RequestParam(name="APIkey") String apiKey) throws Exception {
		try {
			return service.getCountries(action, apiKey);
		} catch (Exception e) {
			throw e;
		}
		
	}
}
