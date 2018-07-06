package test;

import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Driver;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainTest {

	static Connection conn = null;
	
	public static void main(String[] args) {
		
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:myslq://127.0.0.1:3306/mimos", "root", "root");
			if (conn != null) {
				System.out.println("hey hey hey");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
