package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.ServiceDTO;

public class ServiceDAO {
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
	
	public ArrayList<ServiceDTO> getAllServices(){
		ArrayList<ServiceDTO> arr = new ArrayList<ServiceDTO>();
		
		if (openConnection()) {
			try {
				String sql = "Select * from Service";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					ServiceDTO em = new ServiceDTO();
					em.setServiceId(rs.getInt("serviceId"));
					em.setName(rs.getString("name"));
					em.setPrice(rs.getInt("price"));
					
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
	
	public boolean addService(ServiceDTO service) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "Insert into Service(serviceId, name, price) values(?, ?, ?)"; 
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, service.getServiceId());
				stmt.setString(2, service.getName());
				stmt.setInt(3, service.getPrice());
				
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
	
	public boolean editService(ServiceDTO service) {
		boolean result = false;
		if (openConnection()) {
			try { 
				String sql = "update Service set ";
				Statement stmt = con.createStatement();
				
				sql = sql + "serviceId = " + service.getServiceId() + ", ";
				sql = sql + "name = " + "'" + service.getName() + "'"  + ", ";
				sql = sql + "price = " + service.getPrice() + " ";
				
				sql = sql + "where serviceId = " + service.getServiceId() + ";";
				
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
	
	public boolean deleteService(ServiceDTO service) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "delete from Service where serviceId = " + service.getServiceId();
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
	
    public boolean searchCustomer(ServiceDTO service) {
            boolean result = false;
            if (openConnection()) {
                try {
                String sql = "SELECT * FROM Customer WHERE customerId = " + service.getServiceId();
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
    

	public boolean hasServiceID(int id){
		boolean result = false;
		
		if (openConnection()) {
			try {
				String sql = "Select * from Service where serviceId = " + id;
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				result = rs.next();
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally { closeConnection(); } }
		return result;
	}
	
	public boolean hasName(String name) {
		boolean result = false;
		
		if (openConnection()) {
			try {
				String sql = "Select * from Service where name = " + "'" + name + "'";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				result = rs.next();
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally { closeConnection(); } }
		return result;
	}
}
