package myy03.ResultSet;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/students";
		try {
			Connection con = DriverManager.getConnection(url, "root","pass1234");
			String sql = "select * from student";
//			String sql = "insert into student(name,email) values ('myo','myo@email.com')";
			Statement stmt = con.createStatement();
//			stmt.execute(sql);
			ResultSet result = stmt.executeQuery(sql);
			while(result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String email = result.getString("email");
				System.out.println(id+":"+name+":"+email);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
