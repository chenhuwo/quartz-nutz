package com.chw.test.quartz;

import org.nutz.ioc.loader.annotation.IocBean;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@IocBean
public class HelloJob2 implements Job{

	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println(this.getClass().getName()+"........");
	}
	
	public static void main(String[] args) {
		System.out.println(HelloJob2.class.getName());
	}
	
}
