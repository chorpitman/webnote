package com.epam.note.service;

import com.epam.note.model.User;

import java.util.List;

public interface IUserService {

    public List<User> getAllUser();

    public void addUser(User user);

    public void delUser(int userId);

    public void update(User user);

    public User getById(int userId);

    public User getUser(String login, String pwd);
}
