package myy10.get_student_by_Id_and_Email;

import java.sql.SQLException;
import java.util.List;



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
//			Students sd = db.getStudentById(3);
			Students sd = db.getStudentByEmail("hein@email.com");
			if(sd!=null) {
	       System.out.println(sd.getId()+":"+sd.getName()+":"+sd.getEmail() );
			}else {
				System.out.println("Student cannot found");			}
			
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
