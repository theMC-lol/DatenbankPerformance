package mentoring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

	public static Connection createNewConnection() throws SQLException {
		String url = "jdbc:mariadb://localhost:3306/warehouse";
		String url1 = "jdbc:mariadb://db:3306/warehouse";
		String user = "root";
		String password = "";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to localhost:3306!");
		} catch(SQLException ex) {
			System.out.println("Database at localhost:3306 not found. Connecting to db:3306.");
			con = DriverManager.getConnection(url1, user, password);
			System.out.println("Connected to db:3306!");
		}
		return con;
	}
	
}
