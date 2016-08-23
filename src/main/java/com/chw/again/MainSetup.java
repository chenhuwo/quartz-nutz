package com.chw.again;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.integration.quartz.QuartzJob;
import org.nutz.integration.quartz.QuartzManager;
import org.nutz.integration.quartz.QuartzManagerImpl;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;

import com.chw.again.entity.Task;

public class MainSetup implements Setup{

	public void init(NutConfig nc) {
		Ioc ioc = nc.getIoc();
		Dao dao = ioc.get(Dao.class);
		initDatabase(ioc,dao);
		initQuartz(ioc,dao);
	}

	public void destroy(NutConfig nc) {
		Ioc ioc = nc.getIoc();
		Scheduler scheduler = ioc.get(Scheduler.class);
		try {
			scheduler.shutdown();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	private void initQuartz(Ioc ioc,Dao dao){
		QuartzManager qm = ioc.get(QuartzManagerImpl.class,"quartzManager");
		qm.clear();
		List<Task> tasks = dao.query(Task.class, Cnd.where("flag", "=", true));
		
		for(Task t : tasks){
			QuartzJob qj = new QuartzJob();
			qj.setJobName(t.getId());
			qj.setClassName(t.getClassName());
			qj.setCron(t.getCron());
			qj.setComment(t.getComment());
			qm.add(qj);
		}
	}
	
	private void initDatabase(Ioc ioc,Dao dao){
		Daos.createTablesInPackage(dao, "com.chw.again.entity", false);//初始化数据库
		List<Task> tasks = dao.query(Task.class, null);
		if(tasks.isEmpty()){
			Task task = new Task();
			task.setClassName("com.chw.again.job.TestJob");
			task.setCron("*/5 * * * * ?");
			task.setComment("用来测试");
			dao.insert(task);
		}
	}
	
}
