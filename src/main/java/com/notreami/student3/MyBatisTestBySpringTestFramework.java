package com.notreami.student3;

import com.notreami.student3.generatordomain.User;
import com.notreami.student3.service.UserServiceI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.UUID;

/**
 * Created by notreami on 16/1/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//配置了@ContextConfiguration注解并使用该注解的locations属性指明spring和配置文件之后
@ContextConfiguration(locations = {"classpath:spring-core-config.xml","classpath:spring-mybatis.xml"})
public class MyBatisTestBySpringTestFramework {

    @Autowired
    private UserServiceI userService;//注入userService

    @Test
    public void testAddUser(){
        User user = new User();
        user.setUserId("fb1c5941094e400b975f10d9a9d602a3");
        user.setUserName("xdp_gacl_白虎神皇");
        user.setUserBirthday(new Date());
        user.setUserSalary(10000D);
        userService.addUser(user);
    }

    @Test
    public void testGetUserById(){
        String userId = "fb1c5941094e400b975f10d9a9d602a3";
        User user = userService.getUserById(userId);
        System.out.println(user.getUserName());
    }
}
