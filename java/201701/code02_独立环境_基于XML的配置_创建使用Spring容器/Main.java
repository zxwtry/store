package step02XMLBean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import step01BeanConfigure.AccountService;
public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("/step02XMLBean/beanconfig.xml");
		AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
		System.out.println(accountService.getAccount(1l).getOwnerName());
		applicationContext.close();
	}
}
