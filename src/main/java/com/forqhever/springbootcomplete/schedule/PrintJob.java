package com.forqhever.springbootcomplete.schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;

public class PrintJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("触发： " + jobExecutionContext.getTrigger().getName() + "。");
        System.out.println("时间： " + LocalDateTime.now() + "。");
    }
}
