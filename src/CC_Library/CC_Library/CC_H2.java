package CC_Library;
import java.sql.*;

import org.h2.jdbcx.JdbcConnectionPool;
import org.joda.time.DateTime;

import CC_Library.CC_Numeric;

public class CC_H2 {
	private JdbcConnectionPool cp;
	private Connection conn;

	public CC_H2(String dbURL, String dbUser, String dbPassword, String dbMode) {
		ConnectionPool(dbURL, dbUser, dbPassword, dbMode);
	}

	public void ConnectionPool(String dbURL, String dbUser, String dbPassword,
			String dbMode) {
		try {
			Class.forName("org.h2.Driver");
			String strMode = null;
			switch (dbMode) {
			case "Embedded":
				strMode = "jdbc:h2:";
				break;
			case "InMemory":
				strMode = "jdbc:h2:mem:";
				break;
			case "Server":
				strMode = "jdbc:h2:tcp://";
				break;

			default:
				break;
			}
			cp = JdbcConnectionPool.create(strMode + dbURL, dbUser, dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ClosePool(){
		cp.dispose();
	}

	public void Connect() throws SQLException {
		conn = cp.getConnection();
	}

	public ResultSet query(String strSQL) {
		try {
			// Create a result set containing all data from my_table
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(strSQL);
			return rs;
			// Fetch each row from the result set
			// db.Connect();
			// ResultSet rs = db.query("SELECT * FROM TEST");
			// while (rs.next()) {
			// // Get the data from the row using the column index
			// String s = rs.getString(1);
			// // Get the data from the row using the column name
			// s = rs.getString("col_string");
			// }
			// db.Disconnect();
		} catch (SQLException e) {
			return null;
		}
	}

	public void executeQuery(String strSQL) throws SQLException {
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(strSQL);
	}

	public void Disconnect() throws SQLException {
		conn.close();
	}

	public Connection getConnection() {
		return conn;
	}
	
	public static String Embedded(){
		return "Embedded";
	}
	
	public static String InMemory(){
		return "InMemory";
	}
	
	public static String Server(){
		return "Server";
	}

	public static String SQL_DateTimeString(DateTime dateTime) {
		String strSQLDate = "";
		strSQLDate = dateTime.getYear() + "-" + CC_Numeric.Num0fCharacters(dateTime.getMonthOfYear(), 2)
		+ "-" + CC_Numeric.Num0fCharacters(dateTime.getDayOfMonth(), 2) + " "
		+ CC_Numeric.Num0fCharacters(dateTime.getHourOfDay(), 2) + ":"
		+ CC_Numeric.Num0fCharacters(dateTime.getMinuteOfHour(), 2) + ":"
		+ CC_Numeric.Num0fCharacters(dateTime.getSecondOfMinute(), 2) + ".0";
		return strSQLDate;
	}
}
