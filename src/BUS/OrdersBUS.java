package BUS;

import java.util.ArrayList;

import DAO.OrdersDAO;
import DAO.ServiceDAO;
import DAO.StaffDAO;
import DAO.ReservationsDAO;
import DAO.RoomDAO;
import DTO.OrdersDTO;

public class OrdersBUS {
	OrdersDAO orders = new OrdersDAO();
	ReservationsDAO reservations = new ReservationsDAO();
	ServiceDAO service = new ServiceDAO();
	StaffDAO staff = new StaffDAO();
	
	public ArrayList<OrdersDTO> getAllOrders(){
		return orders.getAllOrders();
	}
	
	public ArrayList<OrdersDTO> getOrder(int paymentId){
		return orders.getOrder(paymentId);
	}

	public String addOrders(OrdersDTO Orders) {
		
		if (orders.hasOrderId(Orders.getOrderId()))
			return "Mã Đặt Dịch Vụ đã tồn tại";
		
		if (!reservations.hasReservationId(Orders.getReservationId()))
			return "Mã Đặt Phòng không tồn tại";
		
		if (!service.hasServiceID(Orders.getServiceId()))
			return "Mã Dịch Vụ không tồn tại";
		
		if (orders.addOrders(Orders))
			return "Thêm thành công";
		
		return "Thêm thất bại";	
	}
	
	public String editOrders(OrdersDTO Orders) {
		
		if (!orders.hasOrderId(Orders.getOrderId()))
			return "Mã Đặt Dịch Vụ không tồn tại";
		
		if (!reservations.hasReservationId(Orders.getReservationId()))
			return "Mã Đặt Phòng không tồn tại";
		
		if (!service.hasServiceID(Orders.getServiceId()))
			return "Mã Dịch Vụ không tồn tại";
		
		if (orders.editOrders(Orders))
			return "Chỉnh sửa thành công";
		
		return "Chỉnh sửa thất bại";
	}
	
	public String deleteOrders(OrdersDTO Orders) {
		
		if (!orders.hasOrderId(Orders.getOrderId()))
			return "Mã Đặt Dịch Vụ không tồn tại";
		
		if (orders.deleteOrders(Orders))
			return "Xóa thành công";
		
		return "Xóa thất bại";
	}

}
