package com.beyondli.service;

import com.beyondli.dao.ISysScheduleJobDao;
import com.beyondli.dto.SysScheduleJob;
import com.beyondli.enums.JobOperateEnum;
import com.beyondli.tool.QuartzFactory;
import org.quartz.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuartzServiceImpl implements IQuartzService {

    /**
     * 调度器
     */
    @Resource
    private Scheduler scheduler;

    @Resource
    private ISysScheduleJobDao jobDao;

    @Override
    public void timingTask() {

        //查询数据库是否存在需要定时的任务
        List<SysScheduleJob> scheduleJobs = jobDao.list();
        System.out.println(scheduleJobs);
        if (scheduleJobs != null) {
            scheduleJobs.forEach(this::addJob);
        }
    }

    @Override
    public void addJob(SysScheduleJob job) {
        try {
            //创建触发器
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(job.getJob_name())
                    .withSchedule(CronScheduleBuilder.cronSchedule(job.getCron_expression()))
                    .startNow()
                    .build();

            //创建任务
            JobDetail jobDetail = JobBuilder.newJob(QuartzFactory.class)
                    .withIdentity(job.getJob_name())
                    .build();

            //传入调度的数据，在QuartzFactory中需要使用
            jobDetail.getJobDataMap().put("scheduleJob", job);

            //调度作业
            scheduler.scheduleJob(jobDetail, trigger);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void operateJob(JobOperateEnum jobOperateEnum, SysScheduleJob job) throws SchedulerException {
        JobKey jobKey = new JobKey(job.getJob_name());
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null) {
            //抛异常
        }
        switch (jobOperateEnum) {
            case START:
                scheduler.resumeJob(jobKey);
                break;
            case PAUSE:
                scheduler.pauseJob(jobKey);
                break;
            case DELETE:
                scheduler.deleteJob(jobKey);
                break;
        }
    }

    @Override
    public void startAllJob() throws SchedulerException {
        scheduler.start();
    }

    @Override
    public void pauseAllJob() throws SchedulerException {
        scheduler.standby();
    }
}