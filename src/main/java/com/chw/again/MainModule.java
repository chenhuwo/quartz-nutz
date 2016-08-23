package com.chw.again;

import org.nutz.mvc.annotation.Encoding;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

@Modules(scanPackage = true)
@Ok("json")
@Fail("http:500")
@IocBy(type = ComboIocProvider.class,
		args = {"*json", "conf/", "*anno", "com.chw.again", "*tx", "*quartz", "*async"})
@Encoding(input = "UTF-8", output = "UTF-8")
@SetupBy(value = MainSetup.class)
public class MainModule {
	
}
