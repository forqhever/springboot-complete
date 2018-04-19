package com.forqhever.springbootcomplete.schedule;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class CronScheduleRunner {

    public static void main(String[] args) throws Exception {
        JobDetail jobDetail = new JobDetail("打印任务", "定时任务组", PrintJob.class);
        CronTrigger cronTrigger = new CronTrigger("打印服务触发器", "触发器组");
        CronExpression cronExpression = new CronExpression("0/10 * * * * ?");
        cronTrigger.setCronExpression(cronExpression);

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail, cronTrigger);
        scheduler.start();
    }
}
