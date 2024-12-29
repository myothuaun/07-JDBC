package myy11.update_student_method;

public class Students {
	private int id;
	private String name;
	private String email;
	public Students(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public Students(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}