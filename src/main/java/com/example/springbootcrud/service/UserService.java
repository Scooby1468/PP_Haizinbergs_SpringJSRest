package com.example.springbootcrud.service;

import com.example.springbootcrud.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

	User add(User user);

	List<User> listUsers();

	Boolean delete(Long id);

	User update(User user);

	User getUserByName(String username);

	User getUserById(Long id);

}