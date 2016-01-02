package com.notreami.student3.service.impl;

import com.notreami.student3.generatordao.UserMapper;
import com.notreami.student3.generatordomain.User;
import com.notreami.student3.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by notreami on 16/1/2.
 * 使用@Service注解将UserServiceImpl类标注为一个service
 * service的id是userService
 */
@Service("userService")
public class UserServiceImpl implements UserServiceI {

    /**
     * 使用@Autowired注解标注userMapper变量，
     * 当需要使用UserMapper时，Spring就会自动注入UserMapper
     */
    @Autowired
    private UserMapper userMapper;//注入dao

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public User getUserById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }
}
