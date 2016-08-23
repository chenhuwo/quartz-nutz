package com.chw.test.quartz;

import java.util.Date;

import org.junit.Test;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;

import sun.util.logging.resources.logging;

public class SimpleQuartz {
	private static Logger log = org.slf4j.LoggerFactory.getLogger(SimpleQuartz.class);
	
	public static void eat(){
		log.debug("sdfdsfadsfda-------------------------------------");
	}
	
	public static void main(String[] args) throws Exception {
//		SchedulerFactory sf = new StdSchedulerFactory();//获取一个调度器实例
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        // define the job and tie it to our MyJob class
        JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("job1", "group1").build();
        
        Trigger trigger = TriggerBuilder.newTrigger()
        	      .withIdentity("trigger1", "group1")
        	      .startNow()
        	      .withSchedule(SimpleScheduleBuilder.simpleSchedule()
        	              .withIntervalInSeconds(4)
        	              .repeatForever())
        	      .build();

        	  // Tell quartz to schedule the job using our trigger
        	  scheduler.scheduleJob(job, trigger);
        	  scheduler.start();
            
	}
}
