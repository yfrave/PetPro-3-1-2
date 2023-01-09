package com.pasyuga.kata312.service;

import com.pasyuga.kata312.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pasyuga.kata312.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{


    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> index() {
        return userDao.index();
    }

    @Transactional(readOnly = true)
    @Override
    public User show(Long id) {
        return userDao.show(id);
    }

    @Transactional
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    @Override
    public void update(Long id, User updatedUser) {
        userDao.update(id, updatedUser);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }
}