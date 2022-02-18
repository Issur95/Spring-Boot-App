package com.app.pack.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@PostMapping("/userForm")
	public String postUserForm(@Valid @ModelAttribute("userForm")User user, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("userForm", user);
			model.addAttribute("productForm", new Product());
			model.addAttribute("formTab","active");
		}else { 
			try {
				userService.createUser(user);
				model.addAttribute("userForm", new User());
				model.addAttribute("productForm", new Product());
				model.addAttribute("listTab","active");
			} catch (Exception e) {
				model.addAttribute("formError",e.getMessage());
				model.addAttribute("userForm", user);
				model.addAttribute("productForm", new Product());
				model.addAttribute("formTab","active");
			}
		}

		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("productList", productService.getAllProducts());
		return "user-form/user-view";
	}
		
	

}
