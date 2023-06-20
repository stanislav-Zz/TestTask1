package org.example.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(long id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
    //
}
