package DTO;

import java.util.regex.PatternSyntaxException;

public class StaffDTO extends Person{	
//	VARIABLES
//	static private int grossSalary = 0;
	
	private int salary;
	private String password;
	
// SETTER / GETTTER
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
// CONSTRUCTOR
	public StaffDTO() {
		
	}
	public StaffDTO(int staffId, String fullname, int phone, int gender, String birthday, int salary, String password) {
		super(staffId, fullname, phone, gender, birthday);
		this.salary = salary;
		this.password = password;
	}
	public StaffDTO(StaffDTO x) {
		super(x);
		this.salary = x.salary;
		this.password = x.password;
	}
}
