package com.notreami.student3;

import com.notreami.student3.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * Created by notreami on 15/12/30.
 */
public class MybatisTest1 {
    public static void main(String[] args) throws IOException {
        //mybatis的配置文件
        String resource = "mybatis_conf_test.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
//        InputStream is = MybatisTest1.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
//        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件(它也加载关联的映射文件)
        Reader reader= Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);

        //创建能执行映射文件中sql的sqlsession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "student3.mapping.userMapper.getUser";
        //执行查询返回一个唯一的user对象的sql
        User user = session.selectOne(statement, 2);
        System.out.println(user);
    }
}
