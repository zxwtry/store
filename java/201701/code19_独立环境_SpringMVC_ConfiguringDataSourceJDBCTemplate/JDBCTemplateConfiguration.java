package step19ConfiguringDataSourceJDBCTemplate;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JDBCTemplateConfiguration {
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://192.168.139.130:3306/test_springmvc");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("12356");
        return driverManagerDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
    
    @Bean
    public AccountDao accountDao() {
        AccountDaoJdbcImpl accountDaoJdbcImpl = new AccountDaoJdbcImpl();
        accountDaoJdbcImpl.setJdbcTemplate(jdbcTemplate());
        return accountDaoJdbcImpl;
    }
}
