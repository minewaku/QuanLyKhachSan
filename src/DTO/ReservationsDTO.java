package DTO;

public class ReservationsDTO {
//	VARIABLES
	private int reservationId;
	private int paymentId;
	private int roomId;
	private String arrivalDate;
	private int rentDate;
	private int amount;
	
//	GETTER / SETTER
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	
	public int getRentDate() {
		return rentDate;
	}
	public void setRentDate(int rentDate) {
		this.rentDate = rentDate;
	}

	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
//	CONSTRUCTOR
	public ReservationsDTO() {
		
	}
	public ReservationsDTO(int reservationId, int paymentId, int roomId, String arrivalDate, int rentDate, int amount) {
		this.reservationId = reservationId;
		this.paymentId = paymentId;
		this.roomId = roomId;
		this.arrivalDate = arrivalDate;
		this.rentDate = rentDate;
		this.amount = amount;
	}
	public ReservationsDTO(ReservationsDTO x) {
		this.reservationId = x.reservationId;
		this.paymentId = x.paymentId;
		this.roomId = x.roomId;
		this.arrivalDate = x.arrivalDate;
		this.rentDate = x.rentDate;
		this.amount = x.amount;
	}
}
