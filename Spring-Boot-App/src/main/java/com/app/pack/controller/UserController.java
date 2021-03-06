package com.app.pack.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.pack.entity.Product;
import com.app.pack.entity.User;
import com.app.pack.repository.RoleRepository;
import com.app.pack.service.ProductService;
import com.app.pack.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	RoleRepository roleRepository;

	@GetMapping({"/", "/login"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/userForm")
	public String UserForm(Model model) {
			model.addAttribute("userForm", new User());
			model.addAttribute("roles",roleRepository.findAll());
			model.addAttribute("productForm", new Product());
			model.addAttribute("userList", userService.getAllUsers());
			model.addAttribute("productList", productService.getAllProducts());
			model.addAttribute("listTab","active");
			
		return "user-form/user-view";
	}
	
	@PostMapping("/userForm")
	public String postUserForm(@Valid @ModelAttribute("userForm")User user, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("userForm", user);
			model.addAttribute("formTab","active");
		}else { 
			try {
				userService.createUser(user);
				model.addAttribute("userForm", new User());
				model.addAttribute("roles",roleRepository.findAll());
				model.addAttribute("listTab","active");
			} catch (Exception e) {
				model.addAttribute("formError",e.getMessage());
				model.addAttribute("userForm", user);
				model.addAttribute("roles",roleRepository.findAll());
				model.addAttribute("formTab","active");
				model.addAttribute("userList", userService.getAllUsers());
				model.addAttribute("productList", productService.getAllProducts());
			}
		}
		model.addAttribute("productForm", new Product());
		model.addAttribute("roles",roleRepository.findAll());
		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("productList", productService.getAllProducts());
		return "user-form/user-view";
	}
		
	
	@PostMapping("/productForm")
	public String postProductForm(@Valid @ModelAttribute("productForm")Product product, BindingResult result2, ModelMap model) {
		if(result2.hasErrors()) {
			model.addAttribute("productForm", product);
			model.addAttribute("formTab2","active");
		}else { 
			try {
				productService.createProduct(product);
				model.addAttribute("productForm", new Product());
				model.addAttribute("listTab2","active");
			} catch (Exception e) {
				model.addAttribute("formError",e.getMessage());
				model.addAttribute("productForm", product);
				model.addAttribute("formTab2","active");
				model.addAttribute("userList", userService.getAllUsers());
				model.addAttribute("productList", productService.getAllProducts());
			}
		}
		model.addAttribute("userForm", new User());
		model.addAttribute("roles",roleRepository.findAll());
		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("productList", productService.getAllProducts());
		return "user-form/user-view";
	}
	
	
	@GetMapping("/editUser/{id}")
	public String getEditUserForm(Model model, @PathVariable(name="id") Long id) throws Exception {
		User user = userService.getUserById(id);
		model.addAttribute("roles",roleRepository.findAll());
		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("productList", productService.getAllProducts());
		model.addAttribute("userForm", user);
		model.addAttribute("productForm", new Product());
		model.addAttribute("formTab","active");
		model.addAttribute("editMode",true);
		
		return "user-form/user-view";
	}
	
	@PostMapping("/editUser")
	public String postEditUserForm(@Valid @ModelAttribute("userForm")User user, BindingResult result3, ModelMap model) {
		if(result3.hasErrors()) {
			model.addAttribute("userForm", user);
			model.addAttribute("formTab","active");
			model.addAttribute("editMode","true");
		}else {
			try {
				userService.updateUser(user);
				model.addAttribute("userForm", new User());
				model.addAttribute("listTab","active");
			} catch (Exception e) {
				model.addAttribute("formError",e.getMessage());
				model.addAttribute("userForm", user);
				model.addAttribute("formTab","active");
				model.addAttribute("userList", userService.getAllUsers());
				model.addAttribute("productList", productService.getAllProducts());
				model.addAttribute("editMode","true");
			}
		}
		model.addAttribute("productForm", new Product());
		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("productList", productService.getAllProducts());
		return "user-form/user-view";
	}
	
	@GetMapping("/userForm/cancel")
	public String cancelEditUser(ModelMap model) {
		return "redirect:/userForm";
	}
	
	@GetMapping("/editProduct/{id}")
	public String getEditProductForm(Model model, @PathVariable(name="id") Long id) throws Exception {
		Product product = productService.getProductById(id);
		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("productList", productService.getAllProducts());
		model.addAttribute("productForm", product);
		model.addAttribute("userForm", new User());
		model.addAttribute("formTab2","active");
		model.addAttribute("editMode",true);
		
		return "user-form/user-view";
	}
	
	@PostMapping("/editProduct")
	public String postEditProductForm(@Valid @ModelAttribute("productForm")Product product, BindingResult result4, ModelMap model) {
		if(result4.hasErrors()) {
			model.addAttribute("productForm", product);
			model.addAttribute("formTab2","active");
			model.addAttribute("editMode","true");
		}else { 
			try {
				productService.updateProduct(product);
				model.addAttribute("productForm", new Product());
				model.addAttribute("listTab2","active");
			} catch (Exception e) {
				model.addAttribute("formError",e.getMessage());
				model.addAttribute("productForm", product);
				model.addAttribute("formTab2","active");
				model.addAttribute("userList", userService.getAllUsers());
				model.addAttribute("productList", productService.getAllProducts());
				model.addAttribute("editMode","true");
			}
		}
		model.addAttribute("userForm", new User());
		model.addAttribute("roles",roleRepository.findAll());
		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("productList", productService.getAllProducts());
		return "user-form/user-view";
	}
	
	@GetMapping("/productForm/cancel")
	public String cancelEditProduct(ModelMap model) {
		return "redirect:/userForm";
	}
	
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(Model model, @PathVariable(name="id") Long id) {
		try {
			userService.deleteUser(id);
		} catch (Exception e) {
			model.addAttribute("deleteError","No se puede eliminar usuario");
		}
		return "redirect:/userForm";
	}
	
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(Model model, @PathVariable(name="id") Long id) {
		try {
			productService.deleteProduct(id);
		} catch (Exception e) {
			model.addAttribute("deleteError","No se puede eliminar producto");
		}
		return "redirect:/userForm";
	}

}
