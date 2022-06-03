package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
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
