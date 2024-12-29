package myy08.create_data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	String url = "jdbc:mysql://localhost:3306/students";
	Connection con;
	public void connect() throws SQLException {
		con = DriverManager.getConnection(url, "root", "pass1234");
	}
	public void disconnect() throws SQLException {
		con.close();
	}
	public void createStudent(String name,String email) throws SQLException {
		String sql = "insert into student (name,email) values ('"+name+"','"+email+"')";
		Statement stmt = con.createStatement();
		stmt.execute(sql);
	}

}
