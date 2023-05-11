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

import DTO.StaffDTO;

public class StaffDAO {
	
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
	
	public ArrayList<StaffDTO> getAllStaffs(){
		ArrayList<StaffDTO> arr = new ArrayList<StaffDTO>();
		
		if (openConnection()) {
			try {
				String sql = "Select * from Staff";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					StaffDTO em = new StaffDTO();
					
					em.setId(rs.getInt("staffId"));
					em.setFullname(rs.getString("fullname"));
					em.setPhone(rs.getString("phone"));
					em.setGender(rs.getInt("gender"));
					em.setBirthday(rs.getString("birthday"));
					em.setSalary(rs.getInt("salary"));
					em.setPassword(rs.getString("password"));
					
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
	
	public boolean addStaff(StaffDTO staff) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "Insert into Staff(staffId, fullname, phone, gender, birthday, salary, password) values(?, ?, ?, ?, ?, ?, ?)"; 
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, staff.getId());
				stmt.setString(2, staff.getFullname());
				stmt.setString(3, staff.getPhone());
				stmt.setInt(4, staff.getGender());
				stmt.setString(5, staff.getBirthday());
				stmt.setInt(6, staff.getSalary());
				stmt.setString(7, staff.getPassword());
				
				if (stmt.executeUpdate() >= 1)
					result = true;

			} catch (SQLException ex) {
				System.out.println(ex);
			} finally{
				closeConnection();
			} 
		}
		
		return result;
	}
	
	public boolean editStaff(StaffDTO staff) {
		boolean result = false;
		if (openConnection()) {
			try { 
				String sql = "update Staff set fullname = ?, phone = ?, gender = ?, birthday = ?, salary = ?, password = ? where staffId = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, staff.getFullname());
				stmt.setString(2, staff.getPhone());
				stmt.setInt(3, staff.getGender());
				stmt.setString(4, staff.getBirthday());
				stmt.setInt(5, staff.getSalary());
				stmt.setString(6, staff.getPassword());
				stmt.setInt(7, staff.getId());
				
				if (stmt.executeUpdate() >= 1)
					result = true;

			} catch (SQLException ex) {
				System.out.println(ex);
			} finally{
				closeConnection();
			} 
		}
		
		return result;
	}
	
	public boolean deleteStaff(StaffDTO staff) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "delete from Staff where staffId = " + staff.getId();
				PreparedStatement stmt = con.prepareStatement(sql);
				
				if (stmt.executeUpdate() >= 1)
					result = true;

			} catch (SQLException ex) {
				System.out.println(ex);
			} finally{
				closeConnection();
			} 
		}
		
		return result;
	}
        
        public boolean searchCustomer(StaffDTO staff) {
            boolean result = false;
            if (openConnection()) {
                try {
                String sql = "SELECT * FROM Customer WHERE customerId = " + staff.getId();
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
	

	public boolean hasStaffID(int id){
		boolean result = false;
		
		if (openConnection()) {
			try {
				String sql = "Select * from Staff where staffId = " + id;
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				result = rs.next();
				
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally { closeConnection(); } }
		return result;
	}
	
	public boolean hasPhoneForAdd(String phone) {
		boolean result = false;
		
		if (openConnection()) {
			try {
				String sql = "Select * from Staff where phone = " + phone;
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				result = rs.next();
				
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally { closeConnection(); } }
		
		return result;
	}
	
	public boolean hasPhoneForEdit(String phone, int id) {
		boolean result = false;
		
		if (openConnection()) {
			try {
				String sql = "Select * from Staff where phone = " + phone + " and " + "staffId != " + id;
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				result = rs.next();
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally { closeConnection(); } }
		
		return result;
	}
	
	public boolean checkValidPhone(String phone) {
		boolean result = false;
		if(phone.length() == 10 && phone.charAt(0) == '0')
			result = true;
			
		return result;
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
	
	public boolean login(int id, String password) {
		boolean result = false;
		
		if (openConnection()) {
			try {
				String sql = "Select * from Staff where staffId = " + id + " and " + "password = " + password;
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				result = rs.next();
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally { closeConnection(); } }
		
		return result;
	}
	
	public StaffDTO loginUser(int id, String password) {		
		StaffDTO user = new StaffDTO();
		
		if (openConnection()) {
			try {
				String sql = "Select * from Staff where staffId = " + id + " and " + "password = " + password;
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				rs.next();	
				
				user.setId(rs.getInt("staffId"));
				user.setFullname(rs.getString("fullname"));
				user.setPhone(rs.getString("phone"));
				user.setGender(rs.getInt("gender"));
				user.setBirthday(rs.getString("birthday"));
				user.setSalary(rs.getInt("salary"));
				user.setPassword(rs.getString("password"));
					
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				closeConnection();
			} 
		}
		
		return user;
	}
}