package DTO;

public class OrdersDTO {
//	VARIABLES
	private int orderId;
	private int reservationId;
	private int serviceId;
	private int staffId;
	private int quantity;
	private String date;
	private int amount;
	
//	GETTER / SETTER
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	
//	CONSTRUCTOR
	public OrdersDTO() {
		
	}
	
	public OrdersDTO(int orderId, int reservationId, int serviceId, int staffId, int quanity, String date, int amount) {

		this.orderId = orderId;
		this.reservationId = reservationId;
		this.serviceId = serviceId;
		this.staffId = staffId;
		this.quantity = quanity;
		this.date = date;
		this.amount = amount;
	}
	public OrdersDTO(OrdersDTO x) {
		this.orderId = x.orderId;
		this.reservationId = x.reservationId;
		this.serviceId = x.serviceId;
		this.staffId = x.staffId;
		this.quantity = x.quantity;
		this.date = x.date;
		this.amount = x.amount;
	}
}
