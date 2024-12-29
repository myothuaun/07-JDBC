package myy04.refactoring_for_CRUD_Demo;

import java.sql.SQLException;

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
		db.save("myothuaung","myothuaung@gmail.com");

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
