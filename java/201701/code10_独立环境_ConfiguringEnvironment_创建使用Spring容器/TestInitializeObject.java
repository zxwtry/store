package step10ConfiguringEnvironment;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;

public class TestInitializeObject implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("TestInitializeObject afterPropertiesSet");
    }
    
    @PostConstruct
    public void init() {
        System.out.println("TestInitializeObject init");
    }
    
    //在TestInitialize.xml将其设置为default-init-method
    public void initialize() {
        System.out.println("TestInitializeObject initialize");
    }
    
}
