package com.chw.again.job;

import java.util.Date;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
/**
 * 
 * @author chw
 *
 */
@IocBean
public class TestJob implements Job{
	
	private static Log log = Logs.get();
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println(new Date());
	}
	
}
