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

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DTO.ReservationsDTO;
import DTO.RoomDTO;
import GUI.LoginGUI;

public class ReservationsDAO {
	private Connection con;
	PaymentDAO payment = new PaymentDAO();
	LoginGUI loginGUI = new LoginGUI();
	
	public boolean openConnection() {
		try {
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
	
	public ArrayList<ReservationsDTO> getReservation(int paymentId){
		ArrayList<ReservationsDTO> arr = new ArrayList<ReservationsDTO>();
		
		if (openConnection()) {
			try {
				String sql = "Select * from Reservations where paymentId = " + paymentId;
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
				String sql = "Insert into Reservations(reservationId, paymentId, roomId, arrivalDate, rentDate, amount) values(?, ?, ?, ?, ?, ?)"; 
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, reservation.getReservationId());
				stmt.setInt(2, reservation.getPaymentId());
				stmt.setInt(3, reservation.getRoomId());
				updateRoomStatus(reservation.getRoomId(), 1);
				stmt.setString(4, reservation.getArrivalDate());
				stmt.setInt(5, reservation.getRentDate());
	            stmt.setInt(6, calAmount(reservation, reservation.getRoomId()));
	            
				if (stmt.executeUpdate() >= 1) {
					result = true;
					payment.calTotal(reservation.getPaymentId());
				}
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
	        	
	        	String sql_getOldRoom = "select * from Reservations where reservationId = " + reservation.getReservationId();
				Statement stmt_getOldRoom = con.createStatement();
				ResultSet rs = stmt_getOldRoom.executeQuery(sql_getOldRoom);
				result = rs.next();
				
				int oldRoomId = rs.getInt("roomId");
				int oldPaymentId = rs.getInt("paymentId");
	        	
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
	            
	        	if (stmt.executeUpdate() >= 1) {
	        		updateRoomStatus(oldRoomId, 0);
					
		            payment.calTotal(oldPaymentId);
		            payment.calTotal(reservation.getPaymentId());
		            
		            updateRoomStatus(reservation.getRoomId(), 1);
		            
	                result = true;
	        	}

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
				String sql_getPaymentId = "select * from Reservations where reservationId = " + reservation.getReservationId();
				Statement stmt_getPaymentId = con.createStatement();
				ResultSet rs = stmt_getPaymentId.executeQuery(sql_getPaymentId);
				rs.next();
				int paymentId = rs.getInt("paymentId");
				int roomId = rs.getInt("roomId");
				
				String sql = "delete from Reservations where reservationId = " + reservation.getReservationId();
				PreparedStatement stmt = con.prepareStatement(sql);
	            
	         	if (stmt.executeUpdate()>=1) {
					result = true;
					updateRoomStatus(roomId, 0);
					payment.calTotal(paymentId);
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
				String sql = "Select * from Reservations where reservationId = " + reservationId + " and " + "roomId = " + roomId;
				Statement stmt = con.createStatement();
				ResultSet rs_1 = stmt.executeQuery(sql);
				if (rs_1.next()) 
					result = true;
				
				else {
					String sql1 = "Select * from Room where roomId = " + roomId + " and status = 0;";
					Statement stmt1 = con.createStatement();
					ResultSet rs_2 = stmt1.executeQuery(sql1);
					if(rs_2.next())
						result = true;
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
	 
	 public void updateRoomStatus(int id, int status) {

			if (openConnection()) {
				try {
					String sql = "Update Room set status = ? where roomId = ?;";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setInt(1, status);
					stmt.setInt(2, id);
					stmt.executeUpdate();
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


