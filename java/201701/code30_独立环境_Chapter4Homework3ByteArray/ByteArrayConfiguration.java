package step30Chapter4Homework3ByteArray;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class ByteArrayConfiguration {
    
    @Bean
    public AccountDao accountDao() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.139.130:3306/test_springmvc");
        dataSource.setUsername("root");
        dataSource.setPassword("12356");
        AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
        accountDaoImpl.setDataSource(dataSource);
        accountDaoImpl.setAccountInsert(new AccountInsert(dataSource));
        accountDaoImpl.setAccountById(new AccountById(dataSource));
        return accountDaoImpl;
    }
    
    
}
