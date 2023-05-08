package BUS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import DAO.PaymentDAO;
import DAO.ReservationsDAO;
import DAO.RoomDAO;
import DTO.ReservationsDTO;

public class ReservationBUS {
	ReservationsDAO reservations = new ReservationsDAO();
	PaymentDAO payment = new PaymentDAO();
	RoomDAO room = new RoomDAO();
	
	public ArrayList<ReservationsDTO> getAllReservationss(){
		return reservations.getAllReservationss();
	}

	public String addReservations(ReservationsDTO Reservations, int paymentId, int roomId) {
		if (reservations.hasReservationId(Reservations.getReservationId()))
			return "Mã Đặt Phòng đã tồn tại";
		
		if (!payment.hasPaymentId((paymentId)))
			return "Mã Hóa Đơn không tồn tại";
		
		if (!room.hasRoomId((roomId)))
			return "Mã Phòng không tồn tại";
		
		if (!room.checkRoomStatus(roomId))
			return "Phòng không trống";
		
		if (!reservations.checkIfDateIsValid(Reservations.getArrivalDate()))
			return "Ngày không hợp lệ (MM/dd/yyyy)";
		
		if (reservations.addReservations(Reservations))
			return "Thêm thành công";
		
		return "Thêm thất bại";	
	}
	
	public String editReservations(ReservationsDTO Reservations, int paymentId, int roomId) {
		if (!reservations.hasReservationId(Reservations.getReservationId()))
			return "Mã Đặt Phòng không tồn tại";
		
		if (!payment.hasPaymentId((paymentId)))
			return "Mã Hóa Đơn không tồn tại";
		
		if (!room.hasRoomId((roomId)))
			return "Mã Phòng không tồn tại";
		
		if (!reservations.checkRoomStatus(Reservations.getReservationId(), roomId))
			return "Phòng không trống";
		
		if (!reservations.checkIfDateIsValid(Reservations.getArrivalDate()))
			return "Ngày không hợp lệ (MM/dd/yyyy)";
		
		if (reservations.editReservations(Reservations))
			return "Chỉnh sửa thành công";
		
		return "Chỉnh sửa thất bại";
	}
	
	public String deleteReservations(ReservationsDTO Reservations) {
		if (!reservations.hasReservationId(Reservations.getReservationId()))
			return "Mã Đặt Phòng không tồn tại";
		
		if (reservations.deleteReservations(Reservations))
			return "Xóa thành công";
		
		return "Xóa thất bại";
	}

}
