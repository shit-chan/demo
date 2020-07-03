package com.shit.demo.mapper;

import com.shit.demo.bean.User;
import org.apache.ibatis.annotations.Flush;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    void insert(User user);

    void update(User user);

    void delete(int id);

    List<User> select();
}
