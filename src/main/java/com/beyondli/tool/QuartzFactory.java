package com.beyondli.tool;

import com.beyondli.dto.SysScheduleJob;
import com.beyondli.utils.SpringUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.lang.reflect.Method;

public class QuartzFactory implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        //获取调度数据
        SysScheduleJob scheduleJob = (SysScheduleJob) jobExecutionContext.getMergedJobDataMap().get("scheduleJob");

        //获取对应的Bean
        Object object = SpringUtils.getBean(scheduleJob.getBean_name());
        try {
            //利用反射执行对应方法
            Method method = object.getClass().getMethod(scheduleJob.getMethod_name());
            method.invoke(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
