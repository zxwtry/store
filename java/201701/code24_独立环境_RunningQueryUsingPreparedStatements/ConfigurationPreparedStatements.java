package step24RunningQueryUsingPreparedStatements;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@org.springframework.context.annotation.Configuration
public class ConfigurationPreparedStatements {
    @Bean
    public AccountDao accountDao() {
        AccountDaoImpl accountDao = new AccountDaoImpl();
        accountDao.setJdbcTemplate(jdbcTemplate());
        return accountDao;
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("12356");
        dataSource.setUrl("jdbc:mysql://192.168.139.130:3306/test_springmvc");
        return dataSource;
    }
}
