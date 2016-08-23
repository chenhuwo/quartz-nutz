package com.chw.test.quartz;

import org.junit.Test;
import org.nutz.integration.quartz.Quartzs;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest {
	
	@Test
	public void test1() throws SchedulerException{
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		JobDetail jd = Quartzs.makeJob("job1", null, HelloJob.class);
		Trigger trigger = Quartzs.makeCronTrigger("trigger1", null, "*/5 * * * * ?");
		scheduler.scheduleJob(jd, trigger);
		scheduler.start();
	}
	
	
	public static void test2() throws SchedulerException{
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		Quartzs.cron(scheduler, "*/1 * * * * ?", HelloJob.class);
		scheduler.start();
	}
	
	public static void main(String[] args) throws SchedulerException {
		test2();
	}
}
