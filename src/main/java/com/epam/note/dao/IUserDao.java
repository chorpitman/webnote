package com.epam.note.dao;

import com.epam.note.model.User;

import java.util.List;

public interface IUserDao {

    public List<User> getAllUser();
    public void addUser(User user);
    public void delUser(int userId);
    public void update(User user);
    public User getById(int userId);

}
