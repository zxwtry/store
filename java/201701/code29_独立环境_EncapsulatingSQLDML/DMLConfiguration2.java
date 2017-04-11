package step29EncapsulatingSQLDML;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DMLConfiguration2 {
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
    public AccountDelete accountDelete() {
        AccountDelete accountDelete = new AccountDelete(dataSource());
        return accountDelete;
    }
    @Bean
    public AccountInsert accountInsert() {
        AccountInsert accountInsert = new AccountInsert(dataSource());
        return accountInsert;
    }
    @Bean
    public AccountUpdate accountUpdate() {
        AccountUpdate accountUpdate = new AccountUpdate(dataSource());
        return accountUpdate;
    }
    @Bean
    public AccountDao accountDao() {
        AccountDaoImpl accountDao = new AccountDaoImpl();
        AccountInsert accountInsert = new AccountInsert(dataSource());
        accountDao.setAccountDelete(accountDelete());
        accountDao.setAccountInsert(accountInsert);
        accountDao.setAccountUpdate(accountUpdate());
        return accountDao;
    }
}
