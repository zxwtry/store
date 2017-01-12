package step03ComponentScan;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import step01BeanConfigure.AccountService;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("/step03ComponentScan/component_scan.xml");
		AccountService accountService = applicationContext.getBean("accountServiceImpl", AccountService.class);
		System.out.println(accountService.getAccount(1l).getOwnerName());
		applicationContext.close();
	}
}
