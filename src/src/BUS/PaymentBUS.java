package BUS;

import java.util.ArrayList;

import DAO.CustomerDAO;
import DAO.PaymentDAO;
import DTO.CustomerDTO;
import DTO.PaymentDTO;

public class PaymentBUS {
	PaymentDAO payment = new PaymentDAO();
	CustomerDAO customer = new CustomerDAO();
	
	public ArrayList<PaymentDTO> getAllPayments(){
		return payment.getAllPayments();
	}

	public String addPayment(PaymentDTO Payment, int id) {
		if (payment.hasPaymentId(Payment.getPaymentId()))
			return "Mã Thanh Toán đã tồn tại";
		
		if (!customer.hasCustomerID((id)))
			return "Mã Khách Hàng không tồn tại";
		
		if (payment.addPayment(Payment))
			return "Thêm thành công";
		
		return "Thêm thất bại";	
	}
	
	public String editPayment(PaymentDTO Payment, int id) {
		if (!payment.hasPaymentId(Payment.getPaymentId()))
			return "Mã Thanh Toán không tồn tại";
		
		if (!customer.hasCustomerID((id)))
			return "Mã Khách Hàng không tồn tại";
		
		if (payment.editPayment(Payment))
			return "Chỉnh sửa thành công";
		
		return "Chỉnh sửa thất bại";
	}
	
	public String deletePayment(PaymentDTO Payment) {
		if (!payment.hasPaymentId(Payment.getPaymentId()))
			return "Mã Thanh Toán không tồn tại";
		
		if (payment.deletePayment(Payment))
			return "Xóa thành công";
		
		return "Xóa thất bại";
	}
	
	public String pay(PaymentDTO Payment) {
		if (payment.pay(Payment))
			return "Thanh toán thành công";
		
		return "Thanh toán thất bại";
	}

	public String calTotal(int id) {
		if (payment.calTotal(id))
			return "Cập nhập thanh toán thành công";
		
		return "Cập nhật thanh toán thất bại";
	}
	
}
