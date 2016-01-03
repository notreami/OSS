package com.notreami.student3.dao;

import com.notreami.student3.domain.User;

import java.util.List;

/**
 * Created by notreami on 16/1/3.
 * 定义sql映射的接口
 */
public interface UserDao {
    public List<User> selectAllUser();
}
