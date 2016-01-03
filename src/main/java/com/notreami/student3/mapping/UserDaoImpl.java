package com.notreami.student3.mapping;

import com.notreami.student3.dao.UserDao;
import com.notreami.student3.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by notreami on 16/1/3.
 * 定义sql映射的接口
 */
public class UserDaoImpl implements UserDao {

    SqlSessionFactory factory = null;

    public UserDaoImpl(SqlSessionFactory sessionFactory) {
        this.factory = sessionFactory;
    }

    public SqlSessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SqlSessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<User> selectAllUser() {
        SqlSession session = factory.openSession();
        List<User> userList = session.selectList("selectAllUser");
        return userList;
    }
}
