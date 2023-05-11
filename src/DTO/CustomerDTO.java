package DTO;

public class CustomerDTO extends Person{
	
//	VARIABLES
	private String address;
	
//	GETTER / SETTER
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

//	CONSTRUCTOR
	public CustomerDTO() {
		
	}
	public CustomerDTO(int customerId, String fullname, String phone, int gender, String birthday, String address) {
		super(customerId, fullname, phone, gender, birthday);
		this.address = address;
	}
	public CustomerDTO(CustomerDTO x) {
		super(x);
		this.address = x.address;
	}
}
