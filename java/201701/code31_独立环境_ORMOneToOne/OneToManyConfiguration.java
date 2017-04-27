package step31ORMOneToOne;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class OneToManyConfiguration {
    
    @Bean
    public DataSource dataSource() {
       DriverManagerDataSource dataSource = 
               new DriverManagerDataSource();
       dataSource.setDriverClassName("com.mysql.jdbc.Driver");
       dataSource.setUrl("jdbc:mysql://192.168.139.130/test_springmvc");
       dataSource.setUsername("root");
       dataSource.setPassword("12356");
       return dataSource;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = 
                new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan("step31ORMOneToOne");
        Map<String, String> jpaPropertyMap = new HashMap<String, String>();
        jpaPropertyMap.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        jpaPropertyMap.put("hibernate.hbm2ddl.auto", "create");
        //update: not exist create; exist just update
        //create: create always
        entityManagerFactoryBean.setJpaPropertyMap(jpaPropertyMap);
        return entityManagerFactoryBean;
    }
    
}
