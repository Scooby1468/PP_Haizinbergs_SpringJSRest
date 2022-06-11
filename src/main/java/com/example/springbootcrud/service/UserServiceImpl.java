package com.example.springbootcrud.service;


import com.example.springbootcrud.dao.UserDao;
import com.example.springbootcrud.model.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    @Transactional
    public User add(User user) {
        return userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    @Transactional
    public Boolean delete(Long id) {
        return userDao.delete(id);
    }

    @Transactional
    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Transactional
    @Override
    public User getUserByName(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.findById(id);
    }
}