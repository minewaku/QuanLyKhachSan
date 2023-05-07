package BUS;
import java.util.ArrayList;

import DAO.CustomerDAO;
import DTO.CustomerDTO;

public class CustomerBUS {
	CustomerDAO cus = new CustomerDAO();
	
	public ArrayList<CustomerDTO> getAllCustomers(){
		return cus.getAllCustomers();
	}

	public String addCustomer(CustomerDTO Customer) {
		if (cus.hasCustomerID(Customer.getId()))
			return "Mã Khách Hàng đã tồn tại";
		
		if (cus.hasPhone(Customer.getPhone(), Customer.getId()))
			return "Số điện thoại đã tồn tại";
		
		if (cus.checkValidPhone(Customer.getPhone()))
			return "Số điện thoại không hợp lệ";
		
		if (cus.checkIfDateIsValid(Customer.getBirthday()))
			return "Ngày không hợp lệ (MM/dd/yyyy)";
		
		if (cus.addCustomer(Customer))
			return "Thêm thành công";
		
		return "Thêm thất bại";	
	}
	
	public String editCustomer(CustomerDTO Customer) {
		if (!cus.hasCustomerID(Customer.getId()))
			return "Mã Khách Hàng không tồn tại";
		
		if (cus.hasPhone(Customer.getPhone(), Customer.getId()))
			return "Số điện thoại đã tồn tại";
		
		if (cus.checkValidPhone(Customer.getPhone()))
			return "Số điện thoại không hợp lệ";
		
		if (cus.checkIfDateIsValid(Customer.getBirthday()))
			return "Ngày không hợp lệ (MM/dd/yyyy)";
		
		if (cus.editCustomer(Customer))
			return "Chỉnh sửa thành công";
		
		return "Chỉnh sửa thất bại";
	}
	
	public String deleteCustomer(CustomerDTO Customer) {
		if (!cus.hasCustomerID(Customer.getId()))
			return "Mã Khách Hàng không tồn tại";
		
		if (cus.deleteCustomer(Customer))
			return "Xóa thành công";
		
		return "Xóa thất bại";
	}
	
}

