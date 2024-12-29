package myy14.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class Database {
	String url = "jdbc:mysql://localhost:3306/students";
	Connection con;
	public void connect() throws SQLException {
		con = DriverManager.getConnection(url, "root", "pass1234");
	}
	
	public void save(Students sd) throws SQLException {
		String name = sd.getName();
		String email = sd.getEmail();
		String sql = "insert into student (name,email) values (?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.setString(2, email);
		stmt.execute();
	}
	
	public List<Students> getStudent() throws SQLException {
		String sql = "select * from student";
		Statement stmt = con.createStatement();
		ResultSet result= stmt.executeQuery(sql);
		List<Students> sdlist = new ArrayList<>();
		while(result.next()) {
			int id = result.getInt("id");
			String name = result.getString("name");
			String email = result.getString("email");
			Students sd = new Students(id, name, email);
			sdlist.add(sd);
		}
		return sdlist;
		
	}

	public Students getStudentById(int id) throws SQLException {
		String sql = "select * from student where id=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet result= stmt.executeQuery();
		Students sd = null;
		if(result.next()) {
			String name = result.getString("name");
			String email = result.getString("email");
			sd = new Students(id, name, email);
		}
		return sd;
	}
	public Students getStudentByEmail(String email) throws SQLException {
		String sql = "select * from student where email=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, email);
		ResultSet result= stmt.executeQuery();
		Students sd = null;
		if(result.next()) {
			int id = result.getInt("id");
			String name = result.getString("name");
			sd = new Students(id, name, email);
		}
		return sd;
	}
	public void updateStudent(Students student) throws SQLException {
		int id = student.getId();
		String name = student.getName();
		String email = student.getEmail();
		String sql = "update student set name=?,email=? where id=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.setString(2, email);
		stmt.setInt(3, id);
		stmt.executeUpdate();	
				
	}
	public void deleteById(int id) throws SQLException {
		String sql = "delete from student where id = "+id;
		Statement stmt = con.createStatement();
		stmt.executeUpdate(sql);
	}
	public void disconnect() throws SQLException {
		con.close();
	}
	
}
