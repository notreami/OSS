package com.notreami.student3;

import com.notreami.student3.dao.UserDao;
import com.notreami.student3.domain.User;
import com.notreami.student3.mapping.UserDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

/**
 * Created by notreami on 15/12/30.
 */
public class MybatisTest {

    /**
     * 不使用 XML 构建 SqlSessionFactory
     * DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
     * TransactionFactory transactionFactory = new JdbcTransactionFactory();
     * Environment environment = new Environment("development", transactionFactory, dataSource);
     * Configuration configuration = new Configuration(environment);
     * configuration.addMapper(BlogMapper.class);
     * SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
     *
     * @param args
     * @throws IOException
     */


    public static void main(String[] args) throws IOException {
        //mybatis的配置文件
        String resource = "student3/mybatis_conf_test.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = MybatisTest.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
//        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件(它也加载关联的映射文件)
        Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

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

    /**
     * 接口实现
     */
    @Test
    public void testImpl() {
        String resource = "student3/mybatis_conf_test.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = MybatisTest.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        //使用接口类的调用方式
        //接口类中的方法与SQL映射文件中 同名ID的SQL语句构成一个映射关系，当调用接口方法时，自动去执行相应的SQL语句，SQL语句执行结果以接口返回类型返回
        SqlSession session = sessionFactory.openSession();
        UserDao userDao = session.getMapper(UserDao.class);
        //使用接口实现类的调用方式
        //在实现类中，我们已经在方法实现里映射的SQL语句，所以不再需要调用SqlSession.getMapper()进行映射
//        UserDao userDao = new UserDaoImpl(sessionFactory);
        List<User> userList = userDao.selectAllUser();
        for (User u : userList) {
            System.out.println("** "+u.getId() + "\t\t" + u.getName() + "\t\t" + u.getAge());
        }
    }
}
