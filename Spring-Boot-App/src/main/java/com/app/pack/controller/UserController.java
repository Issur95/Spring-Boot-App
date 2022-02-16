package com.app.pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.pack.entity.Product;
import com.app.pack.entity.User;
import com.app.pack.service.ProductService;
import com.app.pack.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/userForm")
	public String UserForm(Model model) {
			model.addAttribute("userForm", new User());
			model.addAttribute("productForm", new Product());
			model.addAttribute("userList", userService.getAllUsers());
			model.addAttribute("productList", productService.getAllProducts());
			model.addAttribute("form","active");
			
		return "user-form/user-view";
	}	
}
