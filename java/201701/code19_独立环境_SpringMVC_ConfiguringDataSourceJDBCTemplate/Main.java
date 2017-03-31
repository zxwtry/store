package step19ConfiguringDataSourceJDBCTemplate;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JDBCTemplateConfiguration.class);
        
        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
        
        JdbcTemplate jdbcTemplate = accountDao.getJdbcTemplate();
        
        DataSource dataSource = jdbcTemplate.getDataSource();
        Connection connection = dataSource.getConnection();
        
        System.out.println(connection.isClosed());
        connection.close();
        
        System.out.println(connection.isClosed());
        
        System.out.println(accountDao == null);
        //输出 false
        
        applicationContext.close();
        
    }
}
