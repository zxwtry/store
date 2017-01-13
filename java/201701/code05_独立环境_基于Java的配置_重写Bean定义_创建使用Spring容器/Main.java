package step05OverrideBeanDefinition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new 
				AnnotationConfigApplicationContext(Configuration2.class, Configuration1.class);
		
		Object object1 = applicationContext.getBean("object", Object.class);
		System.out.println("applicationContext get object1 hashCode is " + object1.hashCode());
		
//		Object object2 = applicationContext.getBean(Object.class); //取消注释，运行会报错1
		
		Integer i1 = applicationContext.getBean(Integer.class);
		System.out.println("applicationContext get Integer.class i1 is " + i1);
		
//		Fun fun1 = applicationContext.getBean(Fun.class); //取消注释，运行会报错2
		Fun fun2 = applicationContext.getBean("fun", Fun.class);
		System.out.println("fun2 name is " + fun2.getName());
		
//		FunSon funSon1 = applicationContext.getBean(FunSon.class); //取消注释，运行会报错3
		FunSon funSon2 = applicationContext.getBean("funSon", FunSon.class);
		System.out.println("funSon2 name is " + funSon2.getName());
		
		applicationContext.close();
	}
}
