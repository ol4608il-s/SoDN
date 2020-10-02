package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {

	static String url1 = "jdbc:sqlserver://localhost:1433;database=test";
	static String user1 = "fri";
	static String password1 = "oli";
//	static String url2 = "1";
//	static String user2 = "1";
//	static String password2 = "";

public static Connection newConnection() throws SQLException {
		
		
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			return DriverManager.getConnection(url1, user1, password1);	

}
}

/*
 * public static void ConnectDemo() throws SQLException {
 * 
 * try { Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 * Connection con2 = DriverManager.getConnection(url2, user2, password2);
 * 
 * System.out.println("Successfully Connected to the database");
 * 
 * } catch (ClassNotFoundException e) {
 * 
 * System.out.println("Catch1 " + e.getMessage());
 * 
 * } }
 */