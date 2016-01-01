package com.notreami.student3;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by notreami on 16/1/1.
 * 测试调用存储过程
 */
public class TestStoredProcedureMapper {
    @Test
    public void testGetUserCount() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        /**
         * 映射sql的标识字符串，
         * student3.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUserCount是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "student3.mapping.userMapper.getUserCount";//映射sql的标识字符串
        Map<String, Integer> parameterMap = new HashMap<String, Integer>();
        parameterMap.put("sexid", 1);
        parameterMap.put("usercount", -1);//默认人数为-1
        sqlSession.selectOne(statement, parameterMap);
        Integer result = parameterMap.get("usercount");
        sqlSession.close();
        System.out.println(result);
    }
}
