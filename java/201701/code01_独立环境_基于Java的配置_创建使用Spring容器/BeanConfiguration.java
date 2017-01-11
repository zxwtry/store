package step01BeanConfigure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
	@Bean
	public AccountService accountService() {
		AccountService accountService = new AccountServiceImpl(accountDao());
		return accountService;
	}
	@Bean
	public AccountDao accountDao() {
		AccountDao accountDao = new AccountDaoImpl();
		return accountDao;
	}
}
