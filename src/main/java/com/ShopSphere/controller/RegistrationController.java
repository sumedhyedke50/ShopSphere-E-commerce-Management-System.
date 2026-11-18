package com.ShopSphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ShopSphere.dto.RegistrationDto;
import com.ShopSphere.entity.User;
import com.ShopSphere.service.RegistrationService;

@Controller
public class RegistrationController {

	@Autowired
	RegistrationService service;

	@GetMapping("/register")
	public String showRegistrationForm() {
		return "register";
	}

	@PostMapping("/register-user")
	public String registerUser(@ModelAttribute RegistrationDto dto, Model model) {

		try {
			User user = service.registerUser(dto);
			System.err.println(user.getEmail());
			System.err.println(user.getFirstName());
			if (user == null) {
				model.addAttribute("error", "Registration failed!");
				return "register";
			}

			return "login";

		} catch (IllegalArgumentException e) {
			model.addAttribute("error", e.getMessage());
			return "register";
		}
	}

}
