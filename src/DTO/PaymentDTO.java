package DTO;

public class PaymentDTO {
//	VARIABLES
	private int paymentId;
	private int customerId;
	private int staffId;
	private String paymentDate;
	private String createDate;
	private int total;
	private boolean status;

//	GETTER / SETTER
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	//	CONSTRUCTOR
	public PaymentDTO() {
		
	}
	public PaymentDTO(int paymentId, int customerId, int staffId, int total, String paymentDate) {
		this.paymentId = paymentId;
		this.customerId = customerId;
		this.staffId = staffId;
		this.total = total;
		this.paymentDate = paymentDate;
	}
	public PaymentDTO(PaymentDTO x) {
		this.paymentId = x.paymentId;
		this.customerId = x.customerId;
		this.staffId = x.staffId;
		this.total = x.total;
		this.paymentDate = x.paymentDate;
	}
}
