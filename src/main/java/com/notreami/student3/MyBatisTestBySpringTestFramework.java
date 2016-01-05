package com.notreami.student3;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.notreami.student3.generatordomain.User;
import com.notreami.student3.service.UserServiceI;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by notreami on 16/1/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//配置了@ContextConfiguration注解并使用该注解的locations属性指明spring和配置文件之后
@ContextConfiguration(locations = {"classpath:spring-core-config.xml", "classpath:spring-mybatis.xml"})
public class MyBatisTestBySpringTestFramework {

    @Autowired
    private UserServiceI userService;//注入userService

    @Autowired
    private SqlSession sqlSession;//注入SqlSession

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUserId("fb1c5941094e400b975f10d9a9d602a3");
        user.setUserName("xdp_gacl_白虎神皇");
        user.setUserBirthday(new Date());
        user.setUserSalary(10000D);
        userService.addUser(user);
    }

    @Test
    public void testGetUserById() {
        String userId = "fb1c5941094e400b975f10d9a9d602a3";
        User user = userService.getUserById(userId);
        System.out.println(user.getUserName());
    }

    @Test
    public void testGetAllUser() {
        List<User> users = userService.getAllUser();
        System.out.println(users);
    }


    @Test
    public void testGetAllUserPage1() {
        String statement = "com.notreami.student3.generatordao.UserMapper.getAllUser";//映射sql的标识字符串
        List<User> list = sqlSession.selectList(statement, null, new RowBounds(1, 0));
        System.out.println(list);
    }

    @Test
    public void testGetAllUserPage2() {
        //第二种，Mapper接口方式的调用，推荐这种使用方式。
        PageHelper.startPage(1, 1);
        List<User> users = userService.getAllUser();
        System.out.println(users);
    }

    @Test
    public void testGetAllUserPageToPageInfo() {
        //第二种，Mapper接口方式的调用，推荐这种使用方式。
        PageHelper.startPage(2, 2);
        List<User> users = userService.getAllUser();
        //用PageInfo对结果进行包装
        PageInfo page = new PageInfo(users);
        System.out.println(page.getPageNum());//当前第几页
        System.out.println(page.getPageSize());//每页多少行
        System.out.println(page.getStartRow());//开始行数
        System.out.println(page.getEndRow());//结束行数
        System.out.println(page.getTotal());//总共多少行
        System.out.println(page.getPages());//总共几页
        System.out.println(page.getFirstPage());//第一页的页数
        System.out.println(page.getLastPage());//最后一页的页数
        System.out.println(page.isIsFirstPage());//是否是第一页
        System.out.println(page.isIsLastPage());//是否是最后一页
        System.out.println(page.isHasPreviousPage());//是否有上一页
        System.out.println(page.isHasNextPage());//是否有下一页
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 使用ISelect接口可以参考如下用法(返回值为Page或PageInfo)
     * desc/aesc
     */
    @Test
    public void testISelect() {
        //jdk6,7用法，创建接口
        Page<User> page = PageHelper.startPage(1, 10).setOrderBy("id desc").doSelectPage(new ISelect() {
            @Override
            public void doSelect() {
                userService.getAllUser();
            }
        });
        //jdk8 lambda用法
        page = PageHelper.startPage(1, 10).setOrderBy("id desc").doSelectPage(() -> userService.getAllUser());
        //为了说明可以链式使用，上面是单独setOrderBy("id desc")，也可以直接如下
        page = PageHelper.startPage(1, 10, "id desc").doSelectPage(() -> userService.getAllUser());

        //也可以直接返回PageInfo，注意doSelectPageInfo方法和doSelectPage
        PageInfo pageInfo = PageHelper.startPage(1, 10).setOrderBy("id desc").doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                userService.getAllUser();
            }
        });
        //对应的lambda用法
        pageInfo = PageHelper.startPage(1, 10).setOrderBy("id desc").doSelectPageInfo(() -> userService.getAllUser());

        //count查询，返回一个查询语句的count数
//        long total = PageHelper.count(new ISelect() {
//            @Override
//            public void doSelect() {
//                userService.selectLike(country);
//            }
//        });
        //lambda
//        total = PageHelper.count(() -> userService.selectLike(country));
    }
}
