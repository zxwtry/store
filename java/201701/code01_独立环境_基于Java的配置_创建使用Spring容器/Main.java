import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(BeanConfiguration.class);
		AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
		System.out.println(accountService.getAccount(1l).getOwnerName());
		applicationContext.close();
	}
}
