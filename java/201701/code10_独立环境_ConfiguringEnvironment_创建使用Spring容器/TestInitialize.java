package step10ConfiguringEnvironment;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInitialize {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("/step10ConfiguringEnvironment/TestInitialize.xml");
        applicationContext.close();
        /*
            TestInitializeObject init
            TestInitializeObject afterPropertiesSet
            TestInitializeObject initialize
         */
    }
}
