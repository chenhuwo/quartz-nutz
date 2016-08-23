package com.chw.test.quartz;

import org.junit.Test;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.combo.ComboIocLoader;
import org.quartz.JobExecutionException;

public class HelloJobTest extends DaoTest {
	
	@Test
	public void testExecute() throws Exception{
		HelloJob hj = ioc.get(HelloJob.class);
		hj.execute(null);
	}
}
