package com.shit.demo.service;

import com.shit.demo.bean.User;
public interface UserService {
    public void insert(User user);
    public void update(User user);
    public User find(int id);
    public void delete(int id);
}
