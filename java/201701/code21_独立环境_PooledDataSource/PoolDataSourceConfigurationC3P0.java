package step21PooledDatasource;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class PoolDataSourceConfigurationC3P0 {
    @Bean(destroyMethod="close")
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://192.168.139.130:3306/test_springmvc");
        dataSource.setUser("root");
        dataSource.setPassword("12356");
        return dataSource;
    }
}
