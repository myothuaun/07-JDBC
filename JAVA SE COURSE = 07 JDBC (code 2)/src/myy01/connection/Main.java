package myy01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/login";
		
		try {
			Connection con = DriverManager.getConnection(url, "root", "pass1234");
			System.out.println("Connection successful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("can not connect");
			e.printStackTrace();
		}
	}

}
