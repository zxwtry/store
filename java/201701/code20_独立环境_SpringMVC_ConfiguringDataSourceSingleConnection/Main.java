package step20ConfiguringDataSourceSingleConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        solve1();
        solve2();
    }
    
    static void solve1() throws Exception {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SingleConnectionConfiguration.class);
        DataSource dataSource = applicationContext.getBean("dataSource", DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println("connection.isClosed() " + connection.isClosed());
        connection.close();
        Thread.sleep(1000);
        System.out.println("connection.isClosed() " + connection.isClosed());
        System.out.println("applicationContext.isActive() " + applicationContext.isActive());
        applicationContext.close();
        System.out.println("applicationContext.isActive() " + applicationContext.isActive());
    }
    
    static void solve2() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.139.130:3306/test_springmvc?user=root&password=12356");
        Statement statement = conn.createStatement();
        System.out.println(statement == null);
        statement.close();
        conn.close();
    }
    
}
