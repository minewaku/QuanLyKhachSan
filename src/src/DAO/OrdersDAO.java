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
				String sql = "Insert into Orders(reservationId, serviceId, staffId, quantity, amount) values(?, ?, ?, ?, ?)"; 
				PreparedStatement stmt = con.prepareStatement(sql);
				OrdersDTO em = new OrdersDTO();
				stmt.setInt(1, order.getReservationId());
				stmt.setInt(2, order.getServiceId());
				stmt.setInt(3, loginGUI.loginUser.getId());
				stmt.setInt(4, order.getQuantity());
				stmt.setInt(5, calAmount(order));
				
				if (stmt.executeUpdate()>=1)
					result = true;

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
				String sql = "update Orders set ";
				Statement stmt = con.createStatement();
				
				sql = sql + "reservationId = " + "'" + order.getReservationId() + "'" + ", ";
				sql = sql + "serviceId = " + "'" + order.getServiceId() + "'" + ", ";
				sql = sql + "staffId = " + loginGUI.loginUser.getId() + " ";
				sql = sql + "quantity = " + order.getQuantity() + ", ";
				sql = sql + "amount = " + "'" + calAmount(order) + "'" + ", ";
				
				sql = sql + "where reservationId = " + order.getReservationId() + " and " + "serviceId = " + order.getServiceId() + ";" ;
				
				if (stmt.executeUpdate(sql)>=1)
					result = true;

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
				String sql = "delete from Orders where reservationId = " + order.getReservationId() + " and " + "serviceId = " + order.getServiceId() + ";" ;
				PreparedStatement stmt = con.prepareStatement(sql);
				if (stmt.executeUpdate()>=1)
					result = true;

			} catch (SQLException ex) {
				System.out.println(ex);
			} finally{
				closeConnection();
			} 
		}
		
		return result;
	}
	
	public boolean hasOrderId(int reservationId, int serviceId){
		boolean result = false;
		
		if (openConnection()) {
			try {
				String sql = "Select * from Orders where reservationId = " + reservationId + " and " + "serviceId = " + serviceId + ";" ;
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
}
