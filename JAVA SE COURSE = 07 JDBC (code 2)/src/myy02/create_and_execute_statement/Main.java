package myy02.create_and_execute_statement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/students";
		String username = "root";
		String password = "pass1234";
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection successful");
//			String sql = "create table student(id int primary key auto_increment,name varchar(40),email varchar(40))";
			String sql = "insert into student(name,email) values ('khin','khin@email.com')";
			Statement stmt = con.createStatement();
			stmt.execute(sql);
			System.out.println("create table and insert data success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("can not connect");
			e.printStackTrace();
		}
	}

}
