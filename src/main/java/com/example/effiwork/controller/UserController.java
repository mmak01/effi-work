/**
 * 
 */
package com.example.effiwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.effiwork.repository.UserRepository;

/**
 * タスクコントローラ
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;

	@GetMapping
	public String index(Model model) {
		
		return "user/index";
	}
}
