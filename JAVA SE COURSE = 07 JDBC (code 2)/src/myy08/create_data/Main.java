package myy08.create_data;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database db = new Database();
		try {
			db.connect();
			System.out.println("connection successful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("cannot connect to database");
			e.printStackTrace();
		}
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter your name");
			System.out.println("enter your email");
			String name = sc.nextLine();
			String email = sc.nextLine();
			db.createStudent(name,email);
			System.out.println("success");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			db.disconnect();
			System.out.println("conneciton close");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("cannot close connection");
			e.printStackTrace();
		}
	
	}

}
