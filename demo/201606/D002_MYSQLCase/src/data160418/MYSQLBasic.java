package data160418;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class MYSQLBasic {
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/simpleonlinestore?"
                + "user=root&password=&useUnicode=true&characterEncoding=UTF8";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();
			String sql = "insert into seller values("
					+ "default, \'zxw271@163.com\',"
					+ "\'123456\', \'÷Ï–¬Œ∞\', \'÷Ï–¬Œ∞\',"
					+ "\'13776103581\',\'http:\\\\' , 1"
					+ ")";
			statement.execute(sql);
			sql = "select * from seller";
			ResultSet resultSet = statement.executeQuery(sql);
			int count = 0;
			while (resultSet.next()) {
				System.out.println(count++ +resultSet.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Test
	public void TestTransfer () {
		String s = "https://console.qcloud.com/cvm/securitygroup";
		System.out.println(s);
	}

}
