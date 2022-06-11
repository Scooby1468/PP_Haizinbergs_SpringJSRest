package com.example.springbootcrud.service;

import com.example.springbootcrud.dao.RoleDao;
import com.example.springbootcrud.model.Role;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public Set<Role> roleList() {
        return roleDao.roleList();
    }

    public Set<Role> getRoles(Long[] name) {
        int a = 1;
        return roleDao.getRoleById(name);
    }

    public Role getRole(String name) {
        return roleDao.getRoleByName(name);
    }

    public Role getRoleById(Long id) {
        return roleDao.getRoleById(id);
    }
}