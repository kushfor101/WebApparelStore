
import java.sql.*;

public class Database {
	
	private Connection conn = null;
	
	public Database(String url, String username, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
 
			this.conn = DriverManager.getConnection(url, username, password);
 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
	public Connection getConnection() {
		return this.conn;
	}
 
	public ResultSet runQuery(String sql) throws SQLException {
		Statement sta = conn.createStatement();
		return sta.executeQuery(sql);
	}
	
	public void executeUpdate(String sql) throws SQLException {
		Statement sta = conn.createStatement();
		sta.executeUpdate(sql);
	}
	
}
