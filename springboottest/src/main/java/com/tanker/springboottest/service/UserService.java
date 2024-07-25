package com.tanker.springboottest.service;

import com.tanker.springboottest.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findOne(int id);
    void save(User user);
    void update(int id, User tmp);
    void deleteUserById(int id);
}
