package com.chw.test.quartz;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.nutz.integration.quartz.QuartzJob;
import org.nutz.integration.quartz.QuartzManager;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.combo.ComboIocLoader;
import org.nutz.ioc.loader.json.JsonLoader;

public class QuartzMain {
	
	static Ioc ioc;
	
	static QuartzManager qm;
	
	
	public static void main(String[] args) throws ClassNotFoundException {
		ioc = new NutIoc(new ComboIocLoader("*js","conf/","*anno","com.chw.test.quartz","*quartz"));
		qm = ioc.get(QuartzManager.class, "quartzManager");
		
		QuartzJob job1 = new QuartzJob();
		job1.setJobName("job1");
		job1.setJobGroup("group1");
		job1.setCron("*/2 * * * * ?");
		job1.setClassName(HelloJob.class.getName());
		
		QuartzJob job2 = new QuartzJob();
		job2.setJobName("job2");
		job2.setJobGroup("group2");
		job2.setCron("*/5 * * * * ?");
		job2.setClassName(HelloJob2.class.getName());
		
		qm.add(job1);
		qm.add(job2);
		
	}
}
