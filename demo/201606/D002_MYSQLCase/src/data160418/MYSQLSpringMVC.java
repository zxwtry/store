package data160418;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MYSQLSpringMVC {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/onlinestore?"
                + "user=root&password=12356&useUnicode=true&characterEncoding=UTF8";
		String email = null;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();
			String sql = "update table seller set version = 1 where email = \'"+email+"\'";
			statement.execute(sql);
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
}
