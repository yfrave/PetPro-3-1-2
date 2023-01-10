package com.pasyuga.kata312.dao;

import org.springframework.stereotype.Repository;
import com.pasyuga.kata312.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> index() {
        return entityManager.createQuery("select user from User user", User.class).getResultList();
    }

    @Override
    public User show(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.joinTransaction();
        entityManager.persist(user);
    }

    @Override
    public void update(Long id, User user) {
        entityManager.joinTransaction();
        User u = show(id);
        u.setName(user.getName());
        u.setLast_name(user.getLast_name());
        u.setAge(user.getAge());
        entityManager.persist(u);
    }

    @Override
    public void delete(Long id) {
        entityManager.joinTransaction();
        try {
            entityManager.remove(show(id));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}