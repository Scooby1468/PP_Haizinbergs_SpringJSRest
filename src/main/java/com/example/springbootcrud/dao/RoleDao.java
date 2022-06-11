package com.example.springbootcrud.dao;

import com.example.springbootcrud.model.Role;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleDao {
    Set<Role> getRoleById(Long[] name);

    Role getRoleByName(String name);

    Role getRoleById(Long id);

    Set<Role> roleList();

}