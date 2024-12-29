package myy14.PreparedStatement;

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
		try {
//			Students sd = new Students("myo","myo@gmail.com");
//			db.save(sd);
			
//			Students sd = db.getStudentById(3);
			
//			Students sd = db.getStudentByEmail("hein@email.com");
	
//			if(sd!=null) {
//	       System.out.println(sd.getId()+":"+sd.getName()+":"+sd.getEmail() );
//			}else {
//				System.out.println("Student cannot found");			}
			
			Students student = db.getStudentById(2);
			student.setName("myomyo");
			student.setEmail("myo@gmail.com");
			
			db.updateStudent(student);
			
//			db.deleteById(8);
			
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
