package pack.jdbc.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 */
public class JdbcConnection {

	public static Connection getMySqlConnection() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String driverClass = "com.mysql.cj.jdbc.Driver";   //com.mysql.cj.jdbc.Driver
		String connectionUrl ="jdbc:mysql://localhost:3306/hospital?allowPublicKeyRetrieval=true&useSSL=false"; 
		String dbUserName = "root"; 
	    String dbPassword ="Hari@123";
		
	    Class.forName(driverClass); 
	    Connection mysqlConn = DriverManager.getConnection(connectionUrl, dbUserName, dbPassword);
		return mysqlConn;
	}
}

