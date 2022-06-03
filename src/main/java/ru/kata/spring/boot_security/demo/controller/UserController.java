package ru.kata.spring.boot_security.demo.controller;

import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
	
	private final UserService userService;
	
	private final RoleService roleService;
	
	@Autowired
	public UserController(UserService userService, RoleService roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}
	
	@GetMapping("/admin")
	public String findAll(Model model, @AuthenticationPrincipal User authUser) {
		model.addAttribute("users", userService.findAll());
		model.addAttribute("roles", roleService.findAll());
		model.addAttribute("authUser", authUser);
		return "admin";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userPage(ModelMap model, @AuthenticationPrincipal User authUser) {
		model.addAttribute("authUser", authUser);
		return "user";
	}
	
	@RequestMapping(value = "/admin/add", method = {RequestMethod.GET, RequestMethod.POST})
	public String addUser(@ModelAttribute User user) {
		userService.saveUser(user);
		return "redirect:/admin";
	}
	
	@RequestMapping(value = "/admin/delete/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteUser(@PathVariable("id") Long id) {
		userService.deleteById(id);
		return "redirect:/admin";
	}
	
	@RequestMapping(value = "/admin/update", method = {RequestMethod.GET, RequestMethod.POST})
	public String updateUser(@ModelAttribute User user) {
		userService.update(user);
		return "redirect:/admin";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
}
