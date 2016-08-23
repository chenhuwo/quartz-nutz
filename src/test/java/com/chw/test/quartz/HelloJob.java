package com.chw.test.quartz;

import java.util.Date;
import java.util.List;

import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.entity.Record;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@IocBean
public class HelloJob implements Job {
	
	@Inject
	Dao dao;
	private static Log log = Logs.get();
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		System.out.println(new Date());
		
		Sql sql = Sqls.queryRecord("select * from sys_user");
		dao.execute(sql);
		List<Record> list = sql.getList(Record.class);
		System.out.println(list);
	}
	
	
	
}
