package com.notreami.student3.generatordao;

import com.notreami.student3.generatordomain.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**获取所有用户信息
     * @return List<User>
     */
    List<User> getAllUser();
}