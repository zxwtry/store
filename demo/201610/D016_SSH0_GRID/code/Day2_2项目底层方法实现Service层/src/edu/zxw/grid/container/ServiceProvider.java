package edu.zxw.grid.container;

import org.springframework.context.ApplicationContext;

public class ServiceProvider {
	private static ApplicationContext ac = null;
	//加载beans.xml文件
	static {
		ServiceProviderCore.load("beans.xml");
		ac = ServiceProviderCore.ac;
	}
	
	public static Object getService(String serviceName) {
		if (serviceName == null || serviceName.trim().equals("") 
				|| ! ac.containsBean(serviceName)) {
			throw new RuntimeException(
					String.format("当前服务名称(%s)不存在", serviceName));
		}
		return ac.getBean(serviceName);
	}
}
