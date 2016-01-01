package com.notreami.student3;

import com.notreami.student3.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 * Created by notreami on 16/1/1.
 * 测试缓存
 * 对于缓存数据更新机制，当某一个作用域(一级缓存Session/二级缓存Namespaces)的进行了 C/U/D 操作后，默认该作用域下所有 select 中的缓存将被clear。
 */
public class TestCache {
    /**
     * 一级缓存: 基于PerpetualCache 的 HashMap本地缓存，其存储作用域为 Session，当 Session flush 或 close 之后，该Session中的所有 Cache 就将清空。
     */
    @Test
    public void testOneLevelCache() {
        String statement = "student3.mapping.userMapper.getUser";

        SqlSession session = MyBatisUtil.getSqlSession();
        User user = session.selectOne(statement, 1);
        System.out.println(user);

        /**
         * 一级缓存默认就会被使用
         */
        user = session.selectOne(statement, 1);
        System.out.println(user);
        session.close();

        /*
         1. 必须是同一个Session,如果session对象已经close()过了就不可能用了
         */
        session = MyBatisUtil.getSqlSession();
        user = session.selectOne(statement, 1);
        System.out.println(user);

        /*
         2. 查询条件是一样的
         */
        user = session.selectOne(statement, 2);
        System.out.println(user);

        /*
         3. 没有执行过session.clearCache()清理缓存
         */
        session.clearCache();
        user = session.selectOne(statement, 2);
        System.out.println(user);

        /*
         4. 没有执行过增删改的操作(这些操作都会清理缓存)
         */
        session.update("student3.mapping.userMapper.updateUser", new User(2, "user", 23));
        user = session.selectOne(statement, 2);
        System.out.println(user);
    }

    /**
     * 二级缓存与一级缓存其机制相同，默认也是采用 PerpetualCache，HashMap存储，不同在于其存储作用域为 Mapper(Namespace)，并且可自定义存储源，如 Ehcache。
     */
    @Test
    public void testTwoLevelCache() {
        String statement = "student3.mapping.userMapper.getUser";
        SqlSessionFactory sessionFactory=MyBatisUtil.getSqlSessionFactory();
        //开启两个不同的SqlSession
        SqlSession session1 = sessionFactory.openSession();
        SqlSession session2 = sessionFactory.openSession();
        //使用二级缓存时，User类必须实现一个Serializable接口===> User implements Serializable
        User user = session1.selectOne(statement, 1);
        //这个地方一定要提交事务之后二级缓存才会起作用,
        //因为二级缓存是从cache（mapper.xml中定义的cache）中取得，如果session不commit，那么，数据就不会放入cache中。所以，只有commit后，才能取得。
        session1.commit();
        System.out.println("user1="+user);

        //由于使用的是两个不同的SqlSession对象，所以即使查询条件相同，一级缓存也不会开启使用
        user = session2.selectOne(statement, 1);
        System.out.println("user2="+user);
    }
}
