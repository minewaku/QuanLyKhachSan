package DTO;

public class ReservationsDTO {
//	VARIABLES
	private int reservationId;
	private int paymentId;
	private int roomId;
	private String arrivalDate;
	private String departureDate;
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
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
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
	public ReservationsDTO(int reservationId, int paymentId, int roomId, String arrivalDate, String departureDate, int amount) {
		this.reservationId = reservationId;
		this.paymentId = paymentId;
		this.roomId = roomId;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.amount = amount;
	}
	public ReservationsDTO(ReservationsDTO x) {
		this.reservationId = x.reservationId;
		this.paymentId = x.paymentId;
		this.roomId = x.roomId;
		this.arrivalDate = x.arrivalDate;
		this.departureDate = x.departureDate;
		this.amount = x.amount;
	}
}
