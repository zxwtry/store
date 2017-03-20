package step11InstantiationMethods;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

public class TestFactoryBean {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyFactoryBean.class);
        FactoryBean<OO> factoryBean = applicationContext.getBean(MyFactoryBean.class);
        System.out.printf("factoryBean.getObject().getName() is \"%s\"  hashcode is %d\r\n", factoryBean.getObject().getName(), factoryBean.getObject().hashCode());
        System.out.printf("factoryBean.getObject().getName() is \"%s\"  hashcode is %d\r\n", factoryBean.getObject().getName(), factoryBean.getObject().hashCode());
        System.out.printf("factoryBean hashcode is %d\r\n", applicationContext.getBean(MyFactoryBean.class).hashCode());
        System.out.printf("factoryBean hashcode is %d\r\n", applicationContext.getBean(MyFactoryBean.class).hashCode());
        /*
            factoryBean.getObject().getName() is "oo name in MyFactoryBean"  hashcode is 1735934726
            factoryBean.getObject().getName() is "oo name in MyFactoryBean"  hashcode is 861842890
            factoryBean hashcode is 553871028
            factoryBean hashcode is 553871028
         */
        applicationContext.close();
    }
    
    static class OO {
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
    
    @Component
    static class MyFactoryBean implements FactoryBean<OO> {
        @Override
        public OO getObject() throws Exception {
            OO o = new OO();
            o.setName("oo name in MyFactoryBean");
            return o;
        }
        @Override
        public Class<?> getObjectType() {
            return OO.class;
        }
        @Override
        public boolean isSingleton() {
            return true;
        }
    }
}
