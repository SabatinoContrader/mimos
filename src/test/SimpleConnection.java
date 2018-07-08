package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnection {

	static Connection conn = null;

	public static void main(String[] args) {

		try {
			// The newInstance() call is a work around for some
			// broken Java implementations

			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			// handle the error
		}

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mimos", "root", "root");
			if (conn != null) 
				System.out.println("hey hey hey");
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

}
