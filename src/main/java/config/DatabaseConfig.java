package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

	
	public static Connection getConnection() throws SQLException, InstantiationException, IllegalAccessException {
		String dbURL="jdbc:mysql://localhost:3306/javademo?useSSL=false";
		String dbUsername="root";
		String dbUserpassword="Database@123";
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(dbURL,dbUsername,dbUserpassword);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
		}
}
