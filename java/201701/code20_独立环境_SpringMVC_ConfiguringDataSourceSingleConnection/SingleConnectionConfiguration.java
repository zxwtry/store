package step20ConfiguringDataSourceSingleConnection;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class SingleConnectionConfiguration {
    @Bean
    public DataSource dataSource() {
        SingleConnectionDataSource singleConnectionDataSource = new SingleConnectionDataSource();
        singleConnectionDataSource.setSuppressClose(true);
        singleConnectionDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        singleConnectionDataSource.setUrl("jdbc:mysql://192.168.139.130:3306/test_springmvc");
        singleConnectionDataSource.setUsername("root");
        singleConnectionDataSource.setPassword("12356");
        return singleConnectionDataSource;
    }
}
