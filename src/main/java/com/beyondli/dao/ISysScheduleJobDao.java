package com.beyondli.dao;

import com.beyondli.dto.SysScheduleJob;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ISysScheduleJobDao {
    @Select("SELECT * FROM sys_schedule_job ")
    List<SysScheduleJob> list();
}
