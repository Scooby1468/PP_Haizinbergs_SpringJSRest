package com.example.springbootcrud.service;

import com.example.springbootcrud.model.Role;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RoleService {

	Set<Role> roleList();

	Set<Role> getRoles(Long[] name);

	Role getRole(String name);

	Role getRoleById(Long id);
}