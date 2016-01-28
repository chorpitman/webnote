package com.epam.note.service.impl;

import com.epam.note.dao.IUserDao;
import com.epam.note.dao.impl.UserDao;
import com.epam.note.model.User;
import com.epam.note.service.IUserService;

import java.util.List;

public class UserService implements IUserService {

    private IUserDao userDao = new UserDao();

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }


    @Override
    public void delUser(int userId) {
        userDao.delUser(userId);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User getById(int userId) {
        return userDao.getById(userId);
    }

    @Override
    public User getUser(String login, String pwd) {
        return userDao.getUser(login, pwd);
    }
}
