package DTO;

public class Person {
	
//	VARIABLES
	private int Id;
	private String fullname;
	private String phone;
	private int gender;
	private String birthday;
	
//	GETTER / SETTER
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
//	CONSTRUCTOR
	public Person() {
		
	}
	public Person(int Id, String fullname, String phone, int gender, String birthday) {
		this.Id = Id;
		this.fullname = fullname;
		this.phone = phone;
		this.gender = gender;
		this.birthday = birthday;
	}
	public Person(Person x) {
		this.Id = x.Id;
		this.fullname = x.fullname;
		this.phone = x.phone;
		this.gender = x.gender;
		this.birthday = x.birthday;
	}
}
