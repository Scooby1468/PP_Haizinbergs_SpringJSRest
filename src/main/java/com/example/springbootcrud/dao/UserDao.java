package com.example.springbootcrud.dao;


import com.example.springbootcrud.model.User;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserDao {
    User add(User user);

    List<User> listUsers();

    Boolean delete(Long id);

    User update(User user);

    User findById(Long id);

    User findByUsername(String username);
}