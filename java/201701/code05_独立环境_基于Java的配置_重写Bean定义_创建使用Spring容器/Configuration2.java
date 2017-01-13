package step05OverrideBeanDefinition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuration2 {
	@Bean
	public Object object() {
		Object object = new Object();
		System.out.println("In Configuration2 hashCode is " + object.hashCode());
		return object;
	}
	@Bean
	public Fun fun() {
		Fun fun = new Fun();
		fun.setName("Configuration2");
		return fun;
	}
	@Bean
	public Integer integer() {
		return 2;
	}
	@Bean
	public FunSon funSon() {
		FunSon fun = new FunSon();
		fun.setName("Configuration2");
		return fun;
	}
}
