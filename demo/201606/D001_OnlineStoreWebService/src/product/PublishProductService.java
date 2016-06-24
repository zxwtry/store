package product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Product;
import model.ProductCollection;
import model.SimpleModel;

public class PublishProductService {
	public String getPublishString(String name) {
		return "HHH Name is : " + name;
	}
	public SimpleModel getPublishModel(int id, String name) {
		return new SimpleModel(id, name);
	}
	
	public String getAllProducts (String cipher) {
		String url = "jdbc:mysql://localhost:3306/onlinestore?"
                + "user=root&password=12356&useUnicode=true&characterEncoding=UTF8";
		Connection conn = null;
		JSONArray jsonArray = new JSONArray();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();
			String sql = "select * from products where id < 6";
			ResultSet resultSet = statement.executeQuery(sql);
			//System.out.println("fetchsize : " + resultSet.getFetchSize());
			int count = 0;
			while (resultSet.next()) {
				JSONObject newJson = new JSONObject();
				//jsonArray.
				newJson.append("id", resultSet.getInt("id"));
				newJson.append("allBuyers", resultSet.getString("allBuyers"));
				newJson.append("allFiles", resultSet.getString("allFiles"));
				newJson.append("productName", resultSet.getString("productName"));
				newJson.append("productPrice", resultSet.getString("productPrice"));
				newJson.append("sellerID", resultSet.getInt("sellerID"));
				jsonArray.put(count++, newJson.toString());
//				stringBuffer.append(String.valueOf(resultSet.getInt("id"))+"###");
//				stringBuffer.append(resultSet.getString("allBuyers")+"###");
//				stringBuffer.append(resultSet.getString("allFiles")+"###");
//				stringBuffer.append(resultSet.getString("productName")+"###");
//				stringBuffer.append(resultSet.getString("productPrice")+"###");
//				stringBuffer.append(String.valueOf(resultSet.getInt("sellerID")));
//				stringBuffer.append("***");
			}
			//System.out.println("The count is : " + count);
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
		//stringBuffer.delete(stringBuffer.length() - 3, stringBuffer.length());
		//System.out.println(stringBuffer.toString());
		return jsonArray.toString();
	}
	
	public ProductCollection getListOfProducts (String cipher) {
		List<Product> returnList = new ArrayList<Product>();
		String url = "jdbc:mysql://localhost:3306/onlinestore?"
                + "user=root&password=12356&useUnicode=true&characterEncoding=UTF8";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();
			String sql = "select * from products where id >0 and id < 5";
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
		ProductCollection productCollection = new ProductCollection(returnList.size());
		productCollection.addProducts(returnList);
		return productCollection;
	}
}