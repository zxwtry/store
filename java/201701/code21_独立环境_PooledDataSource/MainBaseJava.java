package step21PooledDatasource;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainBaseJava {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext applicationContext = 
                new AnnotationConfigApplicationContext(PoolDataSourceConfigurationDBCP.class);
        DataSource dataSource = applicationContext.getBean("dataSource", DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.printf("connection.isClosed() is %b\r\n", connection.isClosed());
        connection.close();
        System.out.printf("connection.isClosed() is %b\r\n", connection.isClosed());
        applicationContext.close();

        applicationContext = new AnnotationConfigApplicationContext(PoolDataSourceConfigurationC3P0.class);
        dataSource = applicationContext.getBean("dataSource", DataSource.class);
        connection = dataSource.getConnection();
        System.out.printf("connection.isClosed() is %b\r\n", connection.isClosed());
        connection.close();
        System.out.printf("connection.isClosed() is %b\r\n", connection.isClosed());
        applicationContext.close();
    }
}
