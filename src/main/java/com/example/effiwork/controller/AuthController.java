/**
 * 
 */
package com.example.effiwork.controller;

import com.example.effiwork.entity.User;
import com.example.effiwork.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * サインアップコントローラ
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

	private final UserService userService;

	AuthController(UserService userService) {
		this.userService = userService;
	}

	/*
	 * ログイン画面表示
	 * 
	 */
	@GetMapping(value = "/login")
	public String showLogin(Model model) {
		return "auth/login";
	}
	
	/*
	 * サインアップ画面表示
	 * 
	 */
	@GetMapping(value = "/signup")
	public String showSignup(Model model) {
		model.addAttribute("user", new User());
		return "auth/signup";
	}


	/*
	 * ユーザー登録
	 * 
	 */
	@PostMapping("/signup")
	public String registerUser(@ModelAttribute User user, Model model) {
		try {
			userService.registerUser(user.getEmail(), user.getUsername(), user.getPassword());
			return "redirect:/home/index";
		} catch (Exception e) {
			return "auth/signup";
		}
	}

}
