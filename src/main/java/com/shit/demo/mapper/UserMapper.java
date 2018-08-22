package com.shit.demo.mapper;

import com.shit.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public void insert(User user);

    public void update(User user);

    public void delete(int id);

    public User select(int id);
}
