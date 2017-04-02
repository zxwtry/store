package step25JdbcTemplateCRUD;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class ConfigurationCRUD {
    
    @Bean
    public AccountDao accountDao() {
        AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        accountDaoImpl.setJdbcTemplate(jdbcTemplate);
        return accountDaoImpl;
    }
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.139.130:3306/test_springmvc");
        dataSource.setUsername("root");
        dataSource.setPassword("12356");
        return dataSource;
    }
    
}
