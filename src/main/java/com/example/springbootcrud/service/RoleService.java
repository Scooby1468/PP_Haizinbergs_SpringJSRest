package com.example.springbootcrud.service;

import com.example.springbootcrud.model.Role;
import com.example.springbootcrud.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> findAll() {
		return roleRepository.findAll();
	}
	
	public Role getById(Long id) {
		return roleRepository.getById(id);
	}
}
