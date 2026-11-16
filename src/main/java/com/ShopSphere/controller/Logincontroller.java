package com.ShopSphere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ShopSphere.dto.LoginDto;

@Controller
public class Logincontroller {
	
	@GetMapping("/login")
	public String openLoginPage()
	{
		return "login";
	}
	
	@PostMapping("/login-validation")
	public String validateUser(@ModelAttribute LoginDto login)
	{
		System.err.println(login.getEmail());
		System.err.println(login.getPassword());
		
		return "home";
	}

}
