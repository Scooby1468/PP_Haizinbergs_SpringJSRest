package com.example.springbootcrud.dao;



import com.example.springbootcrud.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    public Set<Role> getRoleById(Long ids[]) {
        int a = 1;
        return new HashSet<Role>(getSession().createQuery("FROM Role r where r.id in (:ids)").setParameterList("ids", ids).list());
    }

    public Role getRoleByName(String name) {
        Role role = (Role) getSession().createQuery("from Role where name = :name").setParameter("name", name).getSingleResult();
        return role;
    }

    public Role getRoleById(Long id) {
        Role role = (Role) getSession().createQuery("from Role where id = :id").setParameter("id", id).getSingleResult();
        return role;
    }

    public Set<Role> roleList() {
        return new HashSet<Role>(getSession().createQuery("from Role").list());
    }
}