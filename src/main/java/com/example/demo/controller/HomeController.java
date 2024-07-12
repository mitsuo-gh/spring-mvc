package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Inquiry;
import com.example.demo.model.User;

@Controller
public class HomeController {
	@GetMapping("/")
	private String index(@ModelAttribute Inquiry inquiry) {
		return "index";
	}
	
	@PostMapping("/")
	public String confirm(@Validated @ModelAttribute Inquiry inquiry, BindingResult result) {
		if (result.hasErrors()) {
			return "index";
		}
		return "confirm";
	}
	
	@GetMapping("/form")
	private String readForm(@ModelAttribute User user) {
		return "form";
	}
	
	@PostMapping("/form")
	private String confirm(@ModelAttribute User user) {
		return "confirm";
	}

}
