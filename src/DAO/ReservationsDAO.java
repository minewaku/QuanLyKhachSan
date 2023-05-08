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
					em.setReservationId(rs.getInt("reservationId"));
					em.setPaymentId(rs.getInt("paymentId"));
					em.setRoomId(rs.getInt("roomId"));
					em.setArrivalDate(rs.getString("arrivalDate"));
					em.setRentDate(rs.getInt("rentDate"));
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
	
	public boolean addReservations(ReservationsDTO reservation) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "SET IDENTITY_INSERT Reservations ON Insert into Reservations(reservationId, paymentId, roomId, arrivalDate, rentDate, amount) values(?, ?, ?, ?, ?, ?) SET IDENTITY_INSERT Reservations OFF"; 
				PreparedStatement stmt = con.prepareStatement(sql);
				ReservationsDTO em = new ReservationsDTO();
				stmt.setInt(1, reservation.getReservationId());
				stmt.setInt(2, reservation.getPaymentId());
				stmt.setInt(3, reservation.getRoomId());
				updateRoomStatus(reservation.getRoomId());
				stmt.setString(4, reservation.getArrivalDate());
				stmt.setInt(5, reservation.getRentDate());
				stmt.setInt(6, calAmount(em, em.getRoomId()));
				
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
	        	String sql_getOldRoom = "select * from Reservations where reservationId = " +reservation.getReservationId();
				Statement stmt_getOldRoom = con.createStatement();
				ResultSet rs = stmt_getOldRoom.executeQuery(sql_getOldRoom);
				result = rs.next();
				
				int oldRoomId = rs.getInt("roomId");
				
				String sql_releaseOldRoom = "Update Room set status = 0"  + " where roomId = " + oldRoomId + ";";
				Statement stmt_releaseOldRoom = con.createStatement();
				stmt_releaseOldRoom.execute(sql_releaseOldRoom);
	        	
	            String sql = "update Reservations set ";
	            sql += "paymentId = ?, roomId = ?, arrivalDate = ?, rentDate = ?, amount = ? ";
	            sql += "where reservationId = ?";

	            PreparedStatement stmt = con.prepareStatement(sql);
	            stmt.setInt(1, reservation.getPaymentId());
	            stmt.setInt(2, reservation.getRoomId());
	            stmt.setString(3, reservation.getArrivalDate());
	            stmt.setInt(4, reservation.getRentDate());
	            stmt.setInt(5, calAmount(reservation, reservation.getRoomId()));
	            stmt.setInt(6, reservation.getReservationId());
	            
	            updateRoomStatus(reservation.getRoomId());

	            if (stmt.executeUpdate() >= 1)
	                result = true;

	        } catch (SQLException ex) {
	            System.out.println(ex);
	        } finally {
	            closeConnection();
	        }
	    }

	    return result;
	}
	
	public boolean deleteReservations(ReservationsDTO reservation) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "delete from Reservations where reservationId = " + reservation.getReservationId();
				PreparedStatement stmt = con.prepareStatement(sql);
				if (stmt.executeUpdate() >= 1) {
					result = true;
					releaseRoomStatus(reservation.getReservationId());
				}

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
	
	public boolean checkRoomStatus(int reservationId, int roomId) {
			
		boolean result = false;
		
		if (openConnection()) {
			try {
				String sql = "Select * from Reservations where reservationId = " + reservationId + " and " + "roomId != " + roomId;
				Statement stmt = con.createStatement();
				result = stmt.execute(sql);
				if (result) {
					String sql1 = "Select * from Room where roomId = " + roomId + " and status = 0;";
					Statement stmt1 = con.createStatement();
					result = stmt1.execute(sql1);
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally { closeConnection(); } }
		return result;
	}
	
	public int calAmount(ReservationsDTO reservations, int id) {
		int amount = 0;
		
		if (openConnection()) {
			try {
				String sql = "Select * from Room where roomId = " + id + ";";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				rs.next();
				RoomDTO room = new RoomDTO();
				room.setPrice(rs.getInt("price"));
				System.out.println(room.toString());
				
				amount = reservations.getRentDate() * room.getPrice();
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
	 
	 public void updateRoomStatus(int id) {

			if (openConnection()) {
				try {
					String sql = "Update Room set status = 1"  + " where roomId = " + id + ";";
					Statement stmt = con.createStatement();
					stmt.execute(sql);
				}
				
				catch (Exception ex) {
					System.out.println(ex);
				} 
				finally { closeConnection(); } 
			}
	 }
	 
	 public void releaseRoomStatus(int id) {

			if (openConnection()) {
				try {
					String sql = "Update Room set status = 0"  + " where roomId = " + id + ";";
					Statement stmt = con.createStatement();
					stmt.execute(sql);
				}
				
				catch (Exception ex) {
					System.out.println(ex);
				} 
				finally { closeConnection(); } 
			}
	 }
	 
	public boolean hasRoomId(int reservationId, int roomId){
		boolean result = false;
		
		if (openConnection()) {
			try {
				String sql = "Select * from Reservations where roomId = " + roomId + " and " + "reservationId != " + reservationId;
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				result = rs.next();
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally { closeConnection(); } }
		return result;
	}
}


