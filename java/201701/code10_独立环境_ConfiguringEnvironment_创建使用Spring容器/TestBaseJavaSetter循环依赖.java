package step10ConfiguringEnvironment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class TestBaseJavaSetter循环依赖 {
    public static void main(String[] args) {
        testMyConfiguration1();
    }
    //运行java.lang.NoClassDefFoundError
    static void testMyConfiguration1() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfiguration1.class);
        applicationContext.close();
    }
    //没有错误
    static void testMyConfiguration2() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfiguration2.class);
        applicationContext.close();
    }
    @Configuration
    static class MyConfiguration1 {
        @Bean
        public O1 o1() {
            O1 o1 = new O1();
            o1.setO2(o2());
            return o1;
        }
        @Bean
        public O2 o2() {
            O2 o2 = new O2();
            o2.setO1(o1());
            return o2;
        }
    }
    @Configuration
    static class MyConfiguration2 {
        @Bean
        @Autowired
        public O1 o1() {
            O1 o1 = new O1();
            //o1.setO2(o2());
            return o1;
        }
        @Bean
        @Autowired
        public O2 o2() {
            O2 o2 = new O2();
            //o2.setO1(o1());
            return o2;
        }
    }
    static class O1 {
        O2 o2 = null;
        public void setO2(O2 o2) {
            this.o2 = o2;
        }
    }
    static class O2 {
        O1 o1 = null;
        public void setO1(O1 o1) {
            this.o1 = o1;
        }
    }
}
