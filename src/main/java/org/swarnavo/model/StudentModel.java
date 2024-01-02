package org.swarnavo.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.swarnavo.entity.Admin;
import org.swarnavo.entity.Student;

public class StudentModel {
	
	public List<Student> studentDet(DataSource dataSource, String name) throws IOException {
		List<Student> studentDet = new ArrayList<Student>();
		Connection connect = null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
		try {
			connect = dataSource.getConnection();
			System.out.println(name);
			String query = "Select * from students where name= ?";
			pstmt = connect.prepareStatement(query);
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				studentDet.add(new Student( rs.getString("course"),rs.getString("branch"),rs.getInt("roll_no"),rs.getString("name"),
						rs.getDate("dob"), rs.getString("email"),rs.getString("father_name"),rs.getString("gender")
						));
			}
			
			pstmt.close();
			rs.close();
			connect.close();
			System.out.println("Retriving Student detail successful.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(studentDet);

		return studentDet;
		
	}
	
	public String studentName(DataSource dataSource, int roll_no) {
		String name = "";
        Connection connect = null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
		try {
			connect = dataSource.getConnection();
			
			String query = "Select name from students where roll_no= ?";
			pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, roll_no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				name = rs.getString("name");
				pstmt.close();
				rs.close();
				connect.close();
				return name;
			}
			
			pstmt.close();
			rs.close();
			connect.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return name;
		
	}
	
	public int studentPass(DataSource dataSource, int roll_no) {
		int password = 000;
        Connection connect = null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
		try {
			connect = dataSource.getConnection();
			
			String query = "Select password from students where roll_no= ?";
			pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, roll_no);
			
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
	
	public void addStudent(DataSource dataSource, Student newStudent) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			String course= newStudent.getCourse();
			String branch = newStudent.getBranch();
			int roll_no = newStudent.getRoll_no();
			String name = newStudent.getName();
			Date dob = newStudent.getDob();
			int password = newStudent.getPassword();
			String email = newStudent.getEmail();
			String fatherName = newStudent.getFather_name();
			String gender = newStudent.getGender();
			String query = "insert into students (course,branch,roll_no,name,dob,password,email,father_name,gender) values (?,?,?,?,?,?,?,?,?)";
			statement = connect.prepareStatement(query);
			statement.setString(1, course);
			statement.setString(2, branch);
			statement.setInt(3, roll_no);
			statement.setString(4, name);
			statement.setDate(5, dob);
			statement.setInt(6, password);
			statement.setString(7, email);
			statement.setString(8, fatherName);
			statement.setString(9, gender);
			statement.execute();
			
			
			statement.close();
			connect.close();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudent(DataSource dataSource, Student updatedUser) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			int stdId = updatedUser.getStudent_id();
			String course= updatedUser.getCourse();
			String branch = updatedUser.getBranch();
			int roll_no = updatedUser.getRoll_no();
			String name = updatedUser.getName();
			Date dob = updatedUser.getDob();
			int password = updatedUser.getPassword();
			String email = updatedUser.getEmail();
			String fatherName = updatedUser.getFather_name();
			String gender = updatedUser.getGender();
			String query = "update students set course = ? , branch = ?, roll_no = ?, name = ?,dob=?, password=?, email = ?, father_name = ?, gender = ? where student_id = ? ";
			statement = connect.prepareStatement(query);
			statement.setString(1, course);
			statement.setString(2, branch);
			statement.setInt(3, roll_no);
			statement.setString(4, name);
			statement.setDate(5, dob);
			statement.setInt(6, password);
			statement.setString(7, email);
			statement.setString(8, fatherName);
			statement.setString(9, gender);
			statement.setInt(10, stdId);
			statement.execute();
			
			statement.close();
			connect.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}
	
	public void deleteStudent(DataSource dataSource,int student_id) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			String query = "delete from students where student_id = ? ";
			statement = connect.prepareStatement(query);
			statement.setInt(1, student_id);
			statement.execute();	
			
			statement.close();
			connect.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}

}
