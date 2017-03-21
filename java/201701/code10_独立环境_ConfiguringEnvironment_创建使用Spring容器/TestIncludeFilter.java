package step10ConfiguringEnvironment;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIncludeFilter {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("/step10ConfiguringEnvironment/TestIncludeFilter.xml");
        boolean containsTestIncudeFilterObject = applicationContext.containsBean("testIncudeFilterObject");
        System.out.println(containsTestIncudeFilterObject);
        TestIncudeFilterObject testIncudeFilterObject = applicationContext.getBean(TestIncudeFilterObject.class);
        System.out.println(testIncudeFilterObject.getName());
        applicationContext.close();
    }
}
