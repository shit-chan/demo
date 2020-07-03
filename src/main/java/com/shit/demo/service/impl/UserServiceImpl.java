package com.shit.demo.service.impl;

import com.shit.demo.bean.User;
import com.shit.demo.mapper.UserMapper;
import com.shit.demo.service.UserService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public User select(int id) {
        List<User> list = userMapper.select();
        return list.get(0);
    }

    @Override
    public void delete(int id) {
        userMapper.delete(id);
    }
}
