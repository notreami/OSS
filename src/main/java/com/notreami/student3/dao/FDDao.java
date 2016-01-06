package com.notreami.student3.dao;

import com.notreami.student3.domain.Fd;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by notreami on 16/1/5.
 */
public interface FdDao {
    List<Fd> getFdByStartDateToEndDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    int updateNFDFromSourceToSource(@Param("fromSource") String fromSource,@Param("toSource") String toSource,@Param("createtime") Date createtime,@Param("status") int status);

    int deleteByEndDate(@Param("end_date") Date end_date,@Param("status") int status,@Param("source") String source,@Param("org") String org,@Param("dst") String dst,@Param("carrier") String carrier,@Param("cabin") String cabin);
}
