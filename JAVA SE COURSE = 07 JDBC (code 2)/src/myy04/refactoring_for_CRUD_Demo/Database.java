package myy04.refactoring_for_CRUD_Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	String url = "jdbc:mysql://localhost:3306/students";
	Connection con;
	public void connect() throws SQLException {
		con = DriverManager.getConnection(url, "root", "pass1234");
	}
	public void disconnect() throws SQLException {
		con.close();
		
	}
	public void save(String name, String email) {
		
	}

}
