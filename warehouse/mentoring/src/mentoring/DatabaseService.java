package mentoring;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

public class DatabaseService {
	Connection con;

	public DatabaseService() throws SQLException {
		con = ConnectionUtils.createNewConnection();
		con.createStatement().execute("SET SESSION query_cache_type=0;");
	}

	public void close() throws SQLException {
		con.close();
	}

	// SQL Abfrage mit Index--> "Anzahl Kunden die mehr als 2 Items angeschaut haben" 
	public int countCustomerBought() throws SQLException {
		final Statement stmt = con.createStatement();
		ResultSet rs = null;
		rs = stmt.executeQuery(
				"SELECT cus_email, count(*) FROM history, customer WHERE history.his_customer_id = customer.cus_id AND history.his_state_id = 1 GROUP BY cus_email HAVING count(*) > 2");
		final int count = rs.getMetaData().getColumnCount();
		stmt.close();
		return count;
	}

	// SQL Abfrage ohne Index--> "Anzahl Kunden die mehr als 2 Items angeschaut haben" 
	public int countCustomerBoughtNoIndex() throws SQLException {
		final Statement stmt = con.createStatement();
		ResultSet rs = null;
		rs = stmt.executeQuery(
				"SELECT cus_email, count(*) FROM history USE INDEX(), customer USE INDEX() WHERE history.his_customer_id = customer.cus_id AND history.his_state_id = 1 GROUP BY cus_email HAVING count(*) > 2");
		final int count = rs.getMetaData().getColumnCount();
		stmt.close();
		return count;
	}

	//"SELECT cus_email, count(*) FROM history IGNORE INDEX(PRIMARY, his_customer_id, his_state_id), customer IGNORE INDEX(PRIMARY) WHERE history.his_customer_id = customer.cus_id AND history.his_state_id = 1 GROUP BY cus_email HAVING count(*) > 2");

	// SQL Abfrage mit Index und Stored Procedure --> "Anzahl Kunden die mehr als 2 Items angeschaut haben" 
	public int countCustomerBoughtStored() throws SQLException {
		final Statement stmt = con.createStatement();
		ResultSet rs = null;
		rs = stmt.executeQuery("CALL count_customer_bought");
		final int count = rs.getMetaData().getColumnCount();
		stmt.close();
		return count;
	}

	// SQL Abfrage mit Stored Procedure, aber ohne Index--> "Anzahl Kunden die mehr als 2 Items angeschaut haben" 
	public int countCustomerBoughtStoredNoIndex() throws SQLException {
		final Statement stmt = con.createStatement();
		ResultSet rs = null;
		rs = stmt.executeQuery("CALL count_customer_bought_noindex");
		final int count = rs.getMetaData().getColumnCount();
		stmt.close();
		return count;
	}

	// SQL Abfrage mit Index --> "Anzahl gekaufter Haushaltswaren"
	public int countBoughtHaushaltswaren() throws SQLException {
		final Statement stmt = con.createStatement();
		ResultSet rs = null;
		rs = stmt.executeQuery(
				"SELECT count(h.his_id) FROM product p, category c, history h WHERE p.pro_category_id = c.cat_id AND c.cat_name LIKE 'Haushaltswaren' AND p.pro_id = h.his_product_id");
		rs.next();
		final int result = rs.getInt(1);
		stmt.close();
		return result;
	}

	// SQL Abfrage ohne Index --> "Anzahl gekaufter Haushaltswaren"
	public int countBoughtHaushaltswarenNoIndex() throws SQLException {
		final Statement stmt = con.createStatement();
		ResultSet rs = null;
		rs = stmt.executeQuery(
				"SELECT count(h.his_id) FROM product p USE INDEX(), category c USE INDEX(), history h USE INDEX() WHERE p.pro_category_id = c.cat_id AND c.cat_name LIKE 'Haushaltswaren' AND p.pro_id = h.his_product_id");
		rs.next();
		final int result = rs.getInt(1);
		stmt.close();
		return result;
	}

	// SQL Abfrage mit Index und Stored Prcedure --> "Anzahl gekaufter Haushaltswaren"
	public int countBoughtHaushaltswarenStored() throws SQLException {
		final Statement stmt = con.createStatement();
		ResultSet rs = null;
		rs = stmt.executeQuery("CALL count_bought_haushaltswaren");
		rs.next();
		final int result = rs.getInt(1);
		stmt.close();
		return result;
	}

	// SQL Abfrage mit Stored Procedure, aber ohne Index --> "Anzahl gekaufter Haushaltswaren"
	public int countBoughtHaushaltswarenStoredNoIndex() throws SQLException {
		final Statement stmt = con.createStatement();
		ResultSet rs = null;
		rs = stmt.executeQuery("CALL count_bought_haushaltswaren_noindex");
		rs.next();
		final int result = rs.getInt(1);
		stmt.close();
		return result;
	}

	// SQL Abfrage mit Index --> "Conversion-Rate"
	public float getRatioOfWatchedBought(final String mail) throws SQLException {
		final PreparedStatement stmt = con.prepareStatement(
				"SELECT (SELECT count(*) AS watched FROM history h, customer c WHERE c.cus_id = h.his_customer_id AND c.cus_email LIKE ? AND h.his_state_id = 1) AS watched, (SELECT count(*) AS bought FROM history h, customer c WHERE c.cus_id = h.his_customer_id AND c.cus_email LIKE ? AND h.his_state_id = 2) AS bought");
		stmt.setString(1, mail);
		stmt.setString(2, mail);
		ResultSet rs = null;
		rs = stmt.executeQuery();
		rs.next();
		final float result = (float) rs.getInt(1) / (float) rs.getInt(2);
		stmt.close();
		return result;
	}

	// SQL Abfrage ohne Index --> "Conversion-Rate"
	public float getRatioOfWatchedBoughtNoIndex(final String mail) throws SQLException {
		final PreparedStatement stmt = con.prepareStatement(
				"SELECT (SELECT count(*) AS watched FROM history h USE INDEX(), customer c USE INDEX() WHERE c.cus_id = h.his_customer_id AND c.cus_email LIKE ? AND h.his_state_id = 1) AS watched, (SELECT count(*) AS bought FROM history h USE INDEX(), customer c USE INDEX() WHERE c.cus_id = h.his_customer_id AND c.cus_email LIKE ? AND h.his_state_id = 2) AS bought");
		stmt.setString(1, mail);
		stmt.setString(2, mail);
		ResultSet rs = null;
		rs = stmt.executeQuery();
		rs.next();
		final float result = (float) rs.getInt(1) / (float) rs.getInt(2);
		stmt.close();
		return result;
	}

	// SQL Abfrage mit Index und Stored Procedure --> "Conversion-Rate" 
	public float getRatioOfWatchedBoughtStored(final String mail) throws SQLException {
		final PreparedStatement stmt = con.prepareStatement("CALL watched_bought(?)");
		stmt.setString(1, mail);
		ResultSet rs = null;
		rs = stmt.executeQuery();
		rs.next();
		final float result = (float) rs.getInt(1) / (float) rs.getInt(2);
		stmt.close();
		return result;
	}

	// SQL Abfrage mit Stored Procedure, aber ohne Index --> "Conversion-Rate"
	public float getRatioOfWatchedBoughtStoredNoIndex(final String mail) throws SQLException {
		final PreparedStatement stmt = con.prepareStatement("CALL watched_bought_noindex(?)");
		stmt.setString(1, mail);
		ResultSet rs = null;
		rs = stmt.executeQuery();
		rs.next();
		final float result = (float) rs.getInt(1) / (float) rs.getInt(2);
		stmt.close();
		return result;
	}

	// Funktion die den Cache leert
	public void resetCache(boolean force) throws SQLException {
		final Statement stmt = con.createStatement();
		stmt.executeQuery("RESET QUERY CACHE");
		stmt.close();
		if (force) {
			try {
				Runtime.getRuntime().exec("rm -rf ~/.mysql_history");
			} catch (Exception e) {
			}
		}
		return;
	}
}
