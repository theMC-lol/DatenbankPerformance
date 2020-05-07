package mentoring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DatabaseService {

	public String queryBertoBartName() throws SQLException {
		Connection conn = ConnectionUtils.createNewConnection();
		String name = "";
		
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT pro_name FROM product where pro_id = 16");

		rs.next();
		
		name = rs.getString(1);

		stmt.close();
		conn.close();
		
		return name;
	}
	
	
	
	
}
