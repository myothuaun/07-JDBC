package myy11.update_student_method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import myy10.get_student_by_Id_and_Email.Students;

public class Database {
	String url = "jdbc:mysql://localhost:3306/students";
	Connection con;
	public void connect() throws SQLException {
		con = DriverManager.getConnection(url, "root", "pass1234");
	}
	public void disconnect() throws SQLException {
		con.close();
	}
	public void save(Students student) throws SQLException {
		String name = student.getName();
		String email = student.getEmail();
		String sql = "insert into student (name,email) values ('"+name+"','"+email+"')";
		Statement stmt = con.createStatement();
		stmt.execute(sql);
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

	public  Students getStudentById(int id) throws SQLException {
		String sql = "select * from student where id="+id;
		Statement stmt = con.createStatement();
		ResultSet result= stmt.executeQuery(sql);
		Students sd = null;
		if(result.next()) {
			String name = result.getString("name");
			String email = result.getString("email");
			sd = new Students(id, name, email);
		}
		return sd;
	}
//	public Students getStudentByEmail(String email) throws SQLException {
//		String sql = "select * from student where email='"+email+"'";
//		Statement stmt = con.createStatement();
//		ResultSet result= stmt.executeQuery(sql);
//		Students sd = null;
//		if(result.next()) {
//			int id = result.getInt("id");
//			String name = result.getString("name");
//			sd = new Students(id, name, email);
//		}
//		return sd;
//	}
	public void updateStudent(Students student) throws SQLException {
		int id = student.getId();
		String name = student.getName();
		String email = student.getEmail();
		String sql = "update student set name='"+name+"',email='"+email+"' where id="+id;
		Statement stmt = con.createStatement();
		stmt.executeUpdate(sql);
		
		
		
		
		
				
	}

}
