package com.chw.test.quartz;

import org.junit.Before;
import org.nutz.dao.Dao;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.combo.ComboIocLoader;

public class DaoTest {
	
	Dao dao;
	Ioc ioc;
	
	@Before
	public void setup() throws ClassNotFoundException{
		ioc = new NutIoc(new ComboIocLoader("*js","conf/","*anno","com.chw.test.quartz","*quartz"));
	}
	
	
}
