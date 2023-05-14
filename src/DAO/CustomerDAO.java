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

import DTO.CustomerDTO;
import DTO.ServiceDTO;

public class CustomerDAO {
	
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
	
	public ArrayList<CustomerDTO> getAllCustomers(){
		ArrayList<CustomerDTO> arr = new ArrayList<CustomerDTO>();
		
		if (openConnection()) {
			try {
				String sql = "Select * from Customer";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					CustomerDTO em = new CustomerDTO();
					em.setId(rs.getInt("customerId"));
					em.setFullname(rs.getString("fullname"));
					em.setPhone(rs.getString("phone"));
					em.setGender(rs.getInt("gender"));
					em.setBirthday(rs.getString("birthday"));
					em.setAddress(rs.getString("address")); 

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
	
	public boolean addCustomer(CustomerDTO cus) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "Insert into Customer(customerId, fullname, phone, gender, birthday, address) values(?, ?, ?, ?, ?, ?)"; 
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, cus.getId());
				stmt.setString(2, cus.getFullname());
				stmt.setString(3, cus.getPhone());
				stmt.setInt(4, cus.getGender());
				stmt.setString(5, cus.getBirthday());
				stmt.setString(6, cus.getAddress());
				
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
	
	public boolean editCustomer(CustomerDTO cus) {
		boolean result = false;
		if (openConnection()) {
			try { 
				String sql = "update Customer set fullname = ?, phone = ?, gender = ?, birthday = ?, address = ? where customerId = ?;";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, cus.getFullname());
				stmt.setString(2, cus.getPhone());
				stmt.setInt(3, cus.getGender());
				stmt.setString(4, cus.getBirthday());
				stmt.setString(5, cus.getAddress());
				stmt.setInt(6, cus.getId());
				
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
	
	public boolean deleteCustomer(CustomerDTO cus) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "delete from Customer where customerId = " + cus.getId();
				Statement stmt = con.createStatement();
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
	
        public boolean searchCustomer(CustomerDTO cus) {
                boolean result = false;
                if (openConnection()) {
                    try {
                    String sql = "SELECT * FROM Customer WHERE customerId = " + cus.getId();
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
        
        
	public boolean hasCustomerID(int id){
		boolean result = false;
		
		if (openConnection()) {
			try {
				String sql = "Select * from Customer where customerId = " + id;
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
				String sql = "Select * from Customer where phone ?;";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, phone);
				
				ResultSet rs = stmt.executeQuery();
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
				String sql = "Select * from Customer where phone = ? and customerId != ?;";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, phone);
				stmt.setInt(2, id);
				
				ResultSet rs = stmt.executeQuery();
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
	 
	 public String getCurrentDate() {
	        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	        format.setLenient(false);
	        
	        Date now = new Date();
	        return format.format(now);
	 }
	 
	 public int compareDate(String date1, String date2) {
		 int result = 0;
		 
		 try {
	        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	        format.setLenient(false);
	        
	        Date d1 = format.parse(date1);
	        Date d2 = format.parse(date2);
	        
	        if(d1.compareTo(d2) > 0) {
	            result = 2;
	         } else if(d1.compareTo(d2) < 0) {
	            result = 1;
	         } else if(d1.compareTo(d2) == 0) {
	            result = 0;
	         }
		 } catch(ParseException e) {
			 System.out.println(e);
		 }
		 
		 return result;
	 }

}	