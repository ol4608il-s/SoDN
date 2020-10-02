package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {

	static String url1 = "jdbc:sqlserver://localhost:1433;database=test";
	static String user1 = "fri";
	static String password1 = "oli";

	public static Connection newConnection() throws SQLException {

		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		return DriverManager.getConnection(url1, user1, password1);

	}
}
