package step10ConfiguringEnvironment;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

public class TestConfigureEnvironment {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(Configuration.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        environment.setActiveProfiles("prod");
        MutablePropertySources propertySources = environment.getPropertySources();
        propertySources.addLast(new MapPropertySource("mapSource", Collections.singletonMap("name", (Object)"my oo")));
        applicationContext.refresh();   //需要refresh()不要使用带参AnnotationConfigApplicationContext
        OO o = applicationContext.getBean(OO.class);
        System.out.println(o.getName());
        applicationContext.close();
    }
    @org.springframework.context.annotation.Configuration
    static class Configuration {
        @Bean
        @Profile("dev")
        public OO devOO(@Value("${name}") String name) {
            OO o = new OO();
            o.setName("dev " + name);
            return o;
        }
        @Bean
        @Profile("prod")
        public OO prodOO(@Value("${name}") String name) {
            OO o = new OO();
            o.setName("prod " + name);
            return o;
        }
        @Bean
        public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
            return new PropertySourcesPlaceholderConfigurer();
        }
    }
    static class OO {
        String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
