package step28EncapsulatingSQLQueries;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class FindObjectConfiguration {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.139.130:3306/test_springmvc");
        dataSource.setUsername("root");
        dataSource.setPassword("12356");
        return dataSource;
    }
    @Bean
    public AccountDao accountDao() {
        AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
        accountDaoImpl.setAccountByIdQuery(new AccountByIdQuery(dataSource()));
        return accountDaoImpl;
    }
}
