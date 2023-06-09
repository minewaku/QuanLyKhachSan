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

import DTO.RoomDTO;
import DTO.ServiceDTO;

public class RoomDAO {
	private Connection con;
	
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
	
	public ArrayList<RoomDTO> getAllRooms(){
		ArrayList<RoomDTO> arr = new ArrayList<RoomDTO>();
		
		if (openConnection()) {
			try {
				String sql = "Select * from Room";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					RoomDTO em = new RoomDTO();
					em.setRoomId(rs.getInt("roomId"));
					em.setSize(rs.getString("size"));
					em.setType(rs.getString("type"));
					em.setPrice(rs.getInt("price"));
					em.setStatus(rs.getBoolean("status"));
					
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
	
	public ArrayList<RoomDTO> mostRoom(String from, String to){
		
		ArrayList<RoomDTO> arr = new ArrayList<RoomDTO>();
		if (openConnection()){
			try {
				String sql = "SELECT x.roomId, x.size, x.type, x.price, sum(x.rentDate) as totalRent FROM (select r.roomId, r.size, r.type, r.price, a.rentDate FROM Room as r INNER JOIN Reservations as a on r.roomId = a.roomId WHERE a.arrivalDate >= ? and a.arrivalDate <= ?) as x GROUP BY x.roomId, x.size, x.type, x.price ORDER BY totalRent DESC;";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, from);
				stmt.setString(2, to);
				
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					RoomDTO em = new RoomDTO();
					em.setRoomId(rs.getInt("roomId"));
					em.setSize(rs.getString("size"));
					em.setType(rs.getString("type"));
					em.setPrice(rs.getInt("totalRent"));
					
					arr.add(em);
				}	
			}
			
			catch (SQLException ex) {System.out.println(ex);}
			finally {closeConnection();}
		}
		
		return arr;
	}
	
	public ArrayList<RoomDTO> getAllEmptyRooms(){
		ArrayList<RoomDTO> arr = new ArrayList<RoomDTO>();
		
		if (openConnection()) {
			try {
				String sql = "Select * from Room where status = 0";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					RoomDTO em = new RoomDTO();
					em.setRoomId(rs.getInt("roomId"));
					em.setSize(rs.getString("size"));
					em.setType(rs.getString("type"));
					em.setPrice(rs.getInt("price"));
					em.setStatus(rs.getBoolean("status"));
					
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
	
	public ArrayList<RoomDTO> getAllFullRooms(){
		ArrayList<RoomDTO> arr = new ArrayList<RoomDTO>();
		
		if (openConnection()) {
			try {
				String sql = "Select * from Room where status = 1";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					RoomDTO em = new RoomDTO();
					em.setRoomId(rs.getInt("roomId"));
					em.setSize(rs.getString("size"));
					em.setType(rs.getString("type"));
					em.setPrice(rs.getInt("price"));
					em.setStatus(rs.getBoolean("status"));
					
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
	
	public boolean addRoom(RoomDTO room) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "Insert into Room(roomId, size, type, price, status) values(?, ?, ?, ?, ?)"; 
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, room.getRoomId());
				stmt.setString(2, room.getSize());
				stmt.setString(3, room.getType());
				stmt.setInt(4, room.getPrice());
				stmt.setBoolean(5, false); 
				
				if (stmt.executeUpdate()>=1)
					result = true;

			} catch (SQLException ex) {
				System.out.println(ex);
				System.out.println("error 1");
			} finally{
				closeConnection();
			} 
		}
		
		return result;
	}
	
	public boolean editRoom(RoomDTO room) {
		boolean result = false;
		if (openConnection()) {
			try { 
				String sql = "update Room set size = ?, type = ?, price = ? where roomId = ?;";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, room.getSize());
				stmt.setString(2, room.getType());
				stmt.setInt(3, room.getPrice());
				stmt.setInt(4, room.getRoomId());
				
				if (stmt.executeUpdate() >= 1)
					result = true;

			} catch (SQLException ex) {
				System.out.println(ex);
				System.out.println("error 2");
			} finally{
				closeConnection();
			} 
		}
		
		return result;
	}
	
	public boolean deleteRoom(RoomDTO room) {
		boolean result = false;
		if (openConnection()) {
			try {
				if (room.getStatus() == true)
					return result;
				
				String sql = "delete from Room where roomId = " + room.getRoomId();
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
	
    public boolean searchRoom(RoomDTO room) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "Select * from Room where roomId = " + room.getRoomId();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				result = rs.next();

			} catch (SQLException ex) {
				System.out.println(ex);
			} finally{
				closeConnection();
			} 
		}
		
		return result;
	}
        
	public boolean hasRoomId(int id){
		boolean result = false;
		
		if (openConnection()) {
			try {
				String sql = "Select * from Room where roomId = " + id;
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				result = rs.next();
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally { closeConnection(); } }
		return result;
	}
	
	public boolean checkRoomStatus(int roomId) {
		boolean result = false;
		
		if (openConnection()) {
			try {
				String sql = "Select * from Room where roomId = " + roomId + " and status = 0";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				result = rs.next();
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally { closeConnection(); } }
		return result;
	}
	
	public boolean checkIfDateIsValid(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        try {
            format.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
	}
	
	public boolean compareDate(String dateString1, String dateString2) {
		boolean result = false;
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
			Date date1 = format.parse(dateString1);  
			Date date2 = format.parse(dateString2);
			
			if (date2.compareTo(date1) >= 0)
				result = true;
			
		} catch (ParseException ex) {
			System.out.println(ex);
		}
		
		return result;
	}
}
