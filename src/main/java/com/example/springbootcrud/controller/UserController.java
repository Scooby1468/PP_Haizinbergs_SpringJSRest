package com.example.springbootcrud.controller;

import com.example.springbootcrud.model.User;
import com.example.springbootcrud.service.RoleService;
import com.example.springbootcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;


@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin")
    public String getAdmin(Model model, @AuthenticationPrincipal User authUser) {
        model.addAttribute("users", userService.listUsers());
        model.addAttribute("authUser", authUser);
        model.addAttribute("roles", roleService.roleList());
        return "admin";
    }

    @GetMapping("/user")
    public String getUser(Model userModel, @AuthenticationPrincipal User authUser) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Set<String> roles = AuthorityUtils.authorityListToSet(auth.getAuthorities());
        boolean hasAdmin;
        hasAdmin = roles.contains("ROLE_ADMIN");
        userModel.addAttribute("authUser", authUser);
        userModel.addAttribute("hasAdmin", hasAdmin);
        userModel.addAttribute("username", name);
        return "user";
    }
}
