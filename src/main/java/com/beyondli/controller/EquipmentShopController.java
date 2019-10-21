package com.beyondli.controller;

import com.beyondli.dto.SysScheduleJob;
import com.beyondli.enums.JobOperateEnum;
import com.beyondli.service.IQuartzService;
import org.quartz.SchedulerException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Random;
import java.util.UUID;

/**
 * Created by beyondLi
 * Date 2019/9/16 13:43
 * Desc .
 */
@RestController
@RequestMapping(value = "/test")
public class EquipmentShopController {

    @Resource
    IQuartzService iQuartzService;

    @RequestMapping(value = "/stop", method = RequestMethod.GET)
    public String stop() throws SchedulerException {
        SysScheduleJob sysScheduleJob = new SysScheduleJob();
        sysScheduleJob.setId("1");
        sysScheduleJob.setJob_name("test job");
        iQuartzService.operateJob(JobOperateEnum.PAUSE, sysScheduleJob);
        return "ok";
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String start() throws SchedulerException {
        SysScheduleJob sysScheduleJob = new SysScheduleJob();
        sysScheduleJob.setId("1");
        sysScheduleJob.setJob_name("test job");
        iQuartzService.operateJob(JobOperateEnum.START, sysScheduleJob);
        return "ok";
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String del() throws SchedulerException {
        SysScheduleJob sysScheduleJob = new SysScheduleJob();
        sysScheduleJob.setId("1");
        sysScheduleJob.setJob_name("test job");
        iQuartzService.operateJob(JobOperateEnum.DELETE, sysScheduleJob);
        return "ok";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() throws SchedulerException {
        SysScheduleJob sysScheduleJob = new SysScheduleJob();
        sysScheduleJob.setId(UUID.randomUUID() + "");
        sysScheduleJob.setJob_name("test2 job");
        sysScheduleJob.setCron_expression("0/2 * * * * ?");
        sysScheduleJob.setBean_name("Job4Log");
        sysScheduleJob.setMethod_name("test");
        sysScheduleJob.setStatus(0);
        sysScheduleJob.setDel_flag(0);
        iQuartzService.addJob(sysScheduleJob);
        return "ok";
    }

}
