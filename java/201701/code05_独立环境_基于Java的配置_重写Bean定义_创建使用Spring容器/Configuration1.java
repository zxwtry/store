package step05OverrideBeanDefinition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuration1 {
	@Bean
	public Object object() {
		Object object = new Object();
		System.out.println("In Configuration1 hashCode is " + object.hashCode());
		return object;
	}
	@Bean
	public Fun fun() {
		FunSon fun = new FunSon();
		fun.setName("Configuration1");
		return fun;
	}
	@Bean
	public Integer integer() {
		return 1;
	}
	@Bean
	public FunSon funSon() {
		FunSon fun = new FunSon();
		fun.setName("Configuration1");
		return fun;
	}
}
