package com.notreami.student3;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.notreami.student3.domain.User;
import com.notreami.student3.mapping.UserMapperI;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by notreami on 16/1/5.
 */
public class TestPagingMapper {

    /**
     * 第一种，RowBounds方式的调用
     */
    @Test
    public void testGetPage1() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        /**
         * 映射sql的表示字符串,
         * student3.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getAllUsers是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "student3.mapping.userMapper.getAllUsers";//映射sql的标识字符串
        //执行查询操作,将查询结果自动封装成List<User>返回
        //第一种，RowBounds方式的调用
        List<User> list = sqlSession.selectList(statement, null, new RowBounds(1, 0));
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(list);
    }

    /**
     * 第二种，Mapper接口方式的调用，推荐这种使用方式。
     */
    @Test
    public void testGetPage2() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
        //执行查询操作,将查询结果自动封装成List<User>返回
        //第二种，Mapper接口方式的调用，推荐这种使用方式。
        PageHelper.startPage(2, 1);
        //紧跟着的第一个select方法会被分页
        List<User> list = mapper.getAll();
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(list);
    }

    /**
     * 用PageInfo对结果进行包装
     */
    @Test
    public void testGetPageToPageInfo() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
        //执行查询操作,将查询结果自动封装成List<User>返回
        //第二种，Mapper接口方式的调用，推荐这种使用方式。
        PageHelper.startPage(2, 1);
        //紧跟着的第一个select方法会被分页
        List<User> list = mapper.getAll();
        //用PageInfo对结果进行包装
        PageInfo page = new PageInfo(list);
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
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
