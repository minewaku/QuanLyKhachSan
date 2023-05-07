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
import java.util.Date;
import java.util.concurrent.TimeUnit;

import DTO.ReservationsDTO;
import DTO.RoomDTO;
import GUI.LoginGUI;

public class ReservationsDAO {
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
	
	public ArrayList<ReservationsDTO> getAllReservationss(){
		ArrayList<ReservationsDTO> arr = new ArrayList<ReservationsDTO>();
		
		if (openConnection()) {
			try {
				String sql = "Select * from Reservations";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					ReservationsDTO em = new ReservationsDTO();
					em.setReservationId(rs.getInt("paymentId"));
					em.setPaymentId(rs.getInt("customerId"));
					em.setRoomId(rs.getInt("roomId"));
					em.setArrivalDate(rs.getString("arrivalDate"));
					em.setDepartureDate(rs.getString("departureDate"));
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
	
	public boolean addReservations(ReservationsDTO payment) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "Insert into Reservations(reservationId, paymentId, roomId, arrivalDate, departureDate, amount) values(?, ?, ?, ?, ?, ?)"; 
				PreparedStatement stmt = con.prepareStatement(sql);
				ReservationsDTO em = new ReservationsDTO();
				stmt.setInt(1, payment.getReservationId());
				stmt.setInt(2, payment.getPaymentId());
				stmt.setInt(3, payment.getRoomId());
				stmt.setString(2, payment.getArrivalDate());
				stmt.setString(2, payment.getDepartureDate());
				stmt.setInt(4, calAmount(em, em.getRoomId()));
				
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
	
	public boolean editReservations(ReservationsDTO reservation) {
		boolean result = false;
		
		if (openConnection()) {
			try { 
				String sql = "update Reservations set ";
				Statement stmt = con.createStatement();
				
				sql = sql + "reservationId = " + "'" + reservation.getReservationId() + "'" + ", ";
				sql = sql + "paymentId = " + "'" + reservation.getPaymentId() + "'" + ", ";
				sql = sql + "roomId = " + "'" + reservation.getRoomId() + "'" + ", ";
				sql = sql + "arrivalDate = " + reservation.getArrivalDate() + ", ";
				sql = sql + "departureDate = " + "'" + reservation.getDepartureDate() + "'" + ", ";
				sql = sql + "amount = " + "'" + calAmount(reservation, reservation.getRoomId()) + "'" + ", ";
				
				sql = sql + "where reservationId = " + reservation.getReservationId() + ";";
				
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
	
	public boolean deleteReservations(ReservationsDTO reservation) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "delete from Reservations where reservationtId = " + reservation.getReservationId();
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
	

	public boolean hasReservationId(int id){
		boolean result = false;
		
		if (openConnection()) {
			try {
				String sql = "Select * from Reservations where reservationId = " + id;
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				result = rs.next();
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally { closeConnection(); } }
		return result;
	}
	
	public static long getDifferenceDays(Date d1, Date d2) {
		long diff = d2.getTime() - d1.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public int calAmount(ReservationsDTO reservations, int id) {
		int amount = 0;
		
		if (openConnection()) {
			try {
				String sql = "Select * from Room where roomId = " + id;
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				rs.next();
				
				RoomDTO room = new RoomDTO();
				room.setPrice(rs.getInt("price"));
				
				Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(reservations.getArrivalDate());  
				Date date2 = new SimpleDateFormat("MM/dd/yyyy").parse(reservations.getDepartureDate());  
				long date = getDifferenceDays(date1, date2);
				
				amount = (int) date * room.getPrice();
			}
			
			catch (Exception ex) {
				System.out.println(ex);
			} 
			finally { closeConnection(); } 
		}
		return amount;
	}
	
	 public boolean checkIfDateIsValid(String date) {
	        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	        format.setLenient(false);
	        try {
	            format.parse(date);
	        } catch (ParseException e) {
	            return false;
	        }
	        return true;
	 }
}

