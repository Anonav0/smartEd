package org.swarnavo.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HexFormat;
import java.util.List;

import javax.sql.DataSource;

import org.swarnavo.entity.Admin;
import org.swarnavo.entity.Student;

public class AdminModel {
	
	public int adminPass(DataSource dataSource, String name) {
		int password = 000;
        Connection connect = null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
		try {
			connect = dataSource.getConnection();
			
			String query = "Select password from admin where name= ?";
			pstmt = connect.prepareStatement(query);
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				password = rs.getInt("password");
				pstmt.close();
				rs.close();
				connect.close();
				return password;
			}
			
			pstmt.close();
			rs.close();
			connect.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return password;
		
	}
	
	public List<Admin> adminUnameAndSanswer(DataSource dataSource, String email) {
		List<Admin> adminDet = new ArrayList<Admin>();
        Connection connect = null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
		try {
			connect = dataSource.getConnection();
			
			String query = "Select name, sanswer from admin where email= ?";
			pstmt = connect.prepareStatement(query);
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				adminDet.add(new Admin(rs.getString("name"), rs.getString("sanswer")));
			}
			
			pstmt.close();
			rs.close();
			connect.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("retriving data successful");
		return adminDet;
		
	}
	
	
	public List<Admin> adminDet(DataSource dataSource, String name) throws IOException {
		List<Admin> adminDet = new ArrayList<Admin>();
		Connection connect = null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
		try {
			connect = dataSource.getConnection();
			System.out.println(name);
			String query = "Select * from admin where name= ?";
			pstmt = connect.prepareStatement(query);
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				adminDet.add(new Admin(rs.getString("name"), rs.getInt("password"),
						rs.getDate("dob"), rs.getString("gender"), rs.getString("email"), getBytesFromBlob(rs.getBlob("imageData"))
						));
			}
			
			pstmt.close();
			rs.close();
			connect.close();
			System.out.println("Retriving admin detail successful.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(adminDet);

		return adminDet;
		
	}
	
	public List<Student> listStudents(DataSource dataSource) {
		// 1. Initialise connection objects
		List<Student> listStudents = new ArrayList<Student>();
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			connect = dataSource.getConnection();
			
			// 2. Create a Sql statements string
			String query = "Select * from students";
			stmt = connect.createStatement();
			
			//3. Execute SQL statement
			rs = stmt.executeQuery(query);
			
			//4. Process the result set
			while(rs.next()) {
				listStudents.add(new Student(rs.getInt("student_id"), 
						rs.getString("course"), 
						rs.getString("branch"),
						rs.getInt("roll_no"),
						rs.getString("name"),
						rs.getDate("dob"),
						rs.getInt("password"),
						rs.getString("email"),
						rs.getString("father_name"),
						rs.getString("gender")));
			}
			connect.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listStudents;
	}
	
	
	public void addAdmin(DataSource dataSource, Admin newAdmin) {
		Connection connect = null;
		PreparedStatement stmt = null ;
		
		try {
			connect = dataSource.getConnection();
			String name = newAdmin.getName();
			int password = newAdmin.getPassword();
			Date dob = newAdmin.getDob();
			String gender = newAdmin.getGender();
			String email = newAdmin.getEmail();
			String squestion = newAdmin.getSquestion();
			String sanswer = newAdmin.getSanswer();
			byte[] imageData = HexFormat.of().parseHex("e04fd020ea3a6910a2d808002b30309d");
			
			String query = "insert into admin (name,password,dob,gender,email,squestion,sanswer, imageData) values (?,?,?,?,?,?,?,?)";
			stmt = connect.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setInt(2, password);
			stmt.setDate(3, dob);
			stmt.setString(4, gender);
			stmt.setString(5, email);
			stmt.setString(6, squestion);
			stmt.setString(7, sanswer);
			stmt.setBytes(8, imageData);
			stmt.execute();
			
			stmt.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateAdminPass(DataSource dataSource, String username, int password ) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			
			String query = "update admin set password= ? where name = ? ";
			statement = connect.prepareStatement(query);
			statement.setInt(1, password);
			statement.setString(2, username);
			statement.execute();
			
			statement.close();
			connect.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}
	
	 public static byte[] getBytesFromBlob(Blob blob) throws SQLException, IOException {
	        if (blob == null) {
	            return null;
	        }

	        try (InputStream inputStream = blob.getBinaryStream();
	             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

	            byte[] buffer = new byte[4096];
	            int bytesRead;

	            while ((bytesRead = inputStream.read(buffer)) != -1) {
	                outputStream.write(buffer, 0, bytesRead);
	            }

	            return outputStream.toByteArray();
	        }
	 }
}
