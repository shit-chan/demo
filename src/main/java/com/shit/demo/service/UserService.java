package com.shit.demo.service;

import com.shit.demo.bean.User;
public interface UserService {
    void insert(User user);
    void update(User user);
    User select(int id);
    void delete(int id);
}
