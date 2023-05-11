package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import DTO.OrdersDTO;
import DTO.ServiceDTO;
import GUI.LoginGUI;

public class OrdersDAO {
	private Connection con;
	
	PaymentDAO payment = new PaymentDAO();
	LoginGUI loginGUI = new LoginGUI();
	
	public boolean openConnection() {
		try {
//			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			String dbUrl = "jdbc:sqlserver://localhost:1433; DatabaseName=QuanLyKhachSan; encrypt=true;trustServerCertificate=true;";
			String username = "sa"; String password= "sqlmnwk11112003";
			con = DriverManager.getConnection(dbUrl, username, password);
			return true;
			
		} catch (Exception ex) {
			System.out.println(ex);
			return false; 
		}
	}
	
	public void closeConnection() {
		try {
			if (con!=null)
				con.close();
		} catch (SQLException ex) {
			System.out.println(ex); 
		}
	}
	
	public ArrayList<OrdersDTO> getAllOrders(){
		ArrayList<OrdersDTO> arr = new ArrayList<OrdersDTO>();
		
		if (openConnection()) {
			try {
				String sql = "Select * from Orders";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()){
					OrdersDTO em = new OrdersDTO();
					em.setOrderId(rs.getInt("orderId"));
					em.setReservationId(rs.getInt("reservationId"));
					em.setServiceId(rs.getInt("serviceId"));
					em.setStaffId(rs.getInt("staffId"));
					em.setQuantity(rs.getInt("quantity"));
					em.setDate(rs.getString("date"));
					em.setAmount(rs.getInt("amount")); 

					arr.add(em); 
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				closeConnection();
			} 
		}
		
		return arr;
	}
	
	public boolean addOrders(OrdersDTO order) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "Insert into Orders(orderId , reservationId, serviceId, staffId, quantity, amount) values(?, ?, ?, ?, ?, ?)"; 
				PreparedStatement stmt = con.prepareStatement(sql);
				OrdersDTO em = new OrdersDTO();
				stmt.setInt(1, order.getOrderId());
				stmt.setInt(2, order.getReservationId());
				stmt.setInt(3, order.getServiceId());
				stmt.setInt(4, loginGUI.loginUser.getId());
				stmt.setInt(5, order.getQuantity());
				stmt.setInt(6, calAmount(order));
				
				if (stmt.executeUpdate() >= 1) {
					result = true;
					updatePayment(order);
				}

			} catch (SQLException ex) {
				System.out.println(ex);
			} finally{
				closeConnection();
			} 
		}
		
		return result;
	}
	
	public boolean editOrders(OrdersDTO order) {
		boolean result = false;
		
		if (openConnection()) {
			try { 
				String sql = "update Orders set reservationId = ?, serviceId = ?, staffId = ?, quantity = ?, amount = ? where orderId = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, order.getReservationId());
				stmt.setInt(2, order.getServiceId());
				stmt.setInt(3, loginGUI.loginUser.getId());
				stmt.setInt(4, order.getQuantity());
				stmt.setInt(5, calAmount(order));
				stmt.setInt(6, order.getOrderId());
				
				if (stmt.executeUpdate() >= 1) {
					result = true;
					updatePayment(order);
				}

			} catch (SQLException ex) {
				System.out.println(ex);
			} finally{
				closeConnection();
			} 
		}
		
		return result;
	}
	
	public boolean deleteOrders(OrdersDTO order) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "delete from Orders where orderId = " + order.getOrderId();
				Statement stmt = con.createStatement();
				
				if (stmt.executeUpdate(sql) >= 1) {
					result = true;
					updatePayment(order);
				}

			} catch (SQLException ex) {
				System.out.println(ex);
			} finally{
				closeConnection();
			} 
		}
		
		return result;
	}
	
	public boolean hasOrderId(int orderId){
		boolean result = false;
		
		if (openConnection()) {
			try {
				String sql = "Select * from Orders where orderId = " + orderId;
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				result = rs.next();
				
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally { closeConnection(); } }
		return result;
	}
	
	public int calAmount(OrdersDTO order) {
		int amount = 0;
		
		if (openConnection()) {
			try {
				String sql = "Select * from Service where serviceId = " + order.getServiceId();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				rs.next();
				
				ServiceDTO service = new ServiceDTO();
				service.setPrice(rs.getInt("price"));
				
				amount = order.getQuantity() *  service.getPrice();
			}
			
			catch (Exception ex) {
				System.out.println(ex);
			} 
			finally { closeConnection(); } 
		}
		return amount;
	}
	
	private void updatePayment(OrdersDTO order) {
		if (openConnection()) {
			try {
				String url = "Select * from Reservations as r inner join Orders as o on r.reservationId = o.reservationId where orderId = " + order.getOrderId();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(url);
				rs.next();
				int paymentId = rs.getInt("paymentId");
				payment.calTotal(paymentId);
			}
			catch (Exception ex) {
				System.out.println(ex);
			} 
			finally { closeConnection(); } 
		}
	}
}
