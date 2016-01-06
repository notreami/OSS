package com.notreami.student3;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.notreami.student3.dao.FdDao;
import com.notreami.student3.domain.Fd;
import com.notreami.student3.mapping.UserMapperI;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by notreami on 16/1/5.
 */
public class TestFD {

    @Test
    public void test_getFdByStartDateToEndDate() {
        Calendar calendar1 = Calendar.getInstance(Locale.CHINA);
        calendar1.add(Calendar.YEAR, -1);//提前一年
        Date startDate =calendar1.getTime();

        Calendar calendar2 = Calendar.getInstance(Locale.CHINA);
        Date endDate =calendar2.getTime();


        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        FdDao mapper = sqlSession.getMapper(FdDao.class);

        PageHelper.startPage(2, 1);
        List<Fd> list = mapper.getFdByStartDateToEndDate(startDate, endDate);
        PageInfo page = new PageInfo(list);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(list);
    }

    @Test
    public void test_updateNFDFromSourceToSource() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.add(Calendar.DATE, -1);//提前一天,即24小时
        Date createtime =calendar.getTime();


        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        FdDao mapper = sqlSession.getMapper(FdDao.class);

        int result=mapper.updateNFDFromSourceToSource("NFD","NFD-OLD",createtime,1);
    }

    @Test
    public void test_deleteByEndDate(){
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.add(Calendar.DATE, -15);//提前15天
        Date end_date =calendar.getTime();


        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        FdDao mapper = sqlSession.getMapper(FdDao.class);

        int result=mapper.deleteByEndDate(end_date,3,"NFD/NFD-OLD","org","dst","carrier","cabin");
    }
}
