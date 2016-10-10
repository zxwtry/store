package edu.zxw.grid.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class ServiceProviderCore {
	
	protected static ApplicationContext ac = null;
	
	//加载beans.xml文件
	static void load(String filename) {
		ac = new ClassPathXmlApplicationContext(filename);
	}
}
