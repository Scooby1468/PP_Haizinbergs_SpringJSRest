package com.example.springbootcrud.dao;

import com.example.springbootcrud.model.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public User add(User user) {
        getSession().save(user);
        return user;
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = getSession().createQuery("select distinct u FROM User u join fetch u.roleSet");
        return query.getResultList();
    }

    @Override
    public Boolean delete(Long id) {
        getSession().createQuery("DELETE FROM User where id=:id").setParameter("id", id).executeUpdate();
        return true;
    }

    @Override
    public User update(User user) {
        getSession().update(user);
        return user;
    }

    @Override
    public User findById(Long id) {
        User user = (User) getSession().createQuery("FROM User u join fetch u.roleSet where u.id=:id").setParameter("id", id).getSingleResult();
        return user;
    }

    @Override
    public User findByUsername(String username) {
        User user = (User) getSession().createQuery("FROM User u join fetch u.roleSet where u.username=:name").setParameter("name", username).getSingleResult();
        return user;
    }
}