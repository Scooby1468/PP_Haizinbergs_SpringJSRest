package com.example.springbootcrud.controller;

import com.example.springbootcrud.model.Role;
import com.example.springbootcrud.model.User;
import com.example.springbootcrud.service.RoleService;
import com.example.springbootcrud.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class MainRestController {

    private final UserService userService;
    private final RoleService roleService;

    public MainRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/admin/users/{id}")
    public ResponseEntity<User> getUsers(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @GetMapping(value = "/users/get/{email}")
    public ResponseEntity<User> getUserByLogin(@PathVariable String email) {
        return ResponseEntity.ok().body(userService.getUserByName(email));
    }

    @GetMapping(value = "/admin/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.listUsers());
    }

    @PostMapping(value = "/admin/add")
    public ResponseEntity<User> addUser(@ModelAttribute User user) {
        Set<Role> roles = new HashSet<>();
        for (Role role:user.getRoleSet()) {
                roles.add(roleService.getRole(role.getName()));
        }
        user.setRoleSet(roles);
        return ResponseEntity.ok().body(userService.add(user));
    }

    @PostMapping(value = "/admin/update")
    public ResponseEntity<User> updateUser(@ModelAttribute User user, @RequestParam Long[] roleSet) {
        user.setRoleSet(roleService.getRoles(roleSet));
        userService.update(user);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping(value = "/admin/delete/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.ok().body(true);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<User> userPage(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }
}
