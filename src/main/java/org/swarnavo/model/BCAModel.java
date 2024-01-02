package org.swarnavo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.swarnavo.entity.ResultBBA;
import org.swarnavo.entity.ResultBCA;

public class BCAModel {
	
	public List<ResultBCA> listResults(DataSource dataSource) {
		// 1. Initialise connection objects
		List<ResultBCA> listResult = new ArrayList<ResultBCA>();
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			connect = dataSource.getConnection();
			
			// 2. Create a Sql statements string
			String query = "Select * from resultBCA";
			stmt = connect.createStatement();
			
			//3. Execute SQL statement
			rs = stmt.executeQuery(query);
			
			//4. Process the result set
			while(rs.next()) {
				listResult.add(new ResultBCA(rs.getInt("result_id"),
						rs.getInt("roll_no"),
						rs.getInt("it"),
						rs.getInt("network"),
						rs.getInt("elective"),
						rs.getInt("it_lab"),
						rs.getInt("network_lab"),
						rs.getInt("minor_project"),
						rs.getString("remark")));
			}
			stmt.close();
			rs.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listResult;
	}
	
	public void addBCARes(DataSource dataSource, ResultBCA newRes) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			int roll_no = newRes.getRoll_no();
			int it = newRes.getIt();
			int network = newRes.getNetwork();
			int elective = newRes.getElective();
			int it_lab= newRes.getIt_lab();
			int network_lab = newRes.getNetwork_lab();
			int minor_project= newRes.getMinor_project();
			String remark = newRes.getRemark();
			String query = "insert into resultBCA (roll_no,it, network, elective, it_lab, network_lab, minor_project,remark) values (?,?,?,?,?,?,?,?)";
			statement = connect.prepareStatement(query);
			statement.setInt(1, roll_no);
			statement.setInt(2, it);
			statement.setInt(3, network);
			statement.setInt(4, elective);
			statement.setInt(5, it_lab);
			statement.setInt(6, network_lab);
			statement.setInt(7, minor_project);
			statement.setString(8, remark);
			statement.execute();
			
			statement.close();
			connect.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateBCARes(DataSource dataSource, ResultBCA updatedBCA) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			int reslId = updatedBCA.getResult_id();
			int roll_no = updatedBCA.getRoll_no();
			int it = updatedBCA.getIt();
			int network= updatedBCA.getNetwork();
			int elective= updatedBCA.getElective();
			int it_lab= updatedBCA.getIt_lab();
			int network_lab = updatedBCA.getNetwork_lab();
			int minor_project = updatedBCA.getMinor_project();
			String remark = updatedBCA.getRemark();
			String query = "update resultBCA set roll_no = ? , it= ?, network= ?, elective= ?, it_lab= ?, network_lab= ?, minor_project = ?, remark = ? where result_id = ? ";
			statement = connect.prepareStatement(query);
			statement.setInt(1, roll_no);
			statement.setInt(2, it);
			statement.setInt(3, network);
			statement.setInt(4, elective);
			statement.setInt(5, it_lab);
			statement.setInt(6, network_lab);
			statement.setInt(7, minor_project);
			statement.setString(8, remark);
			statement.setInt(9, reslId );
			statement.execute();
			
			statement.close();
			connect.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}
	
	public void deleteBCARes(DataSource dataSource,int result_id) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			String query = "delete from resultBCA where result_id = ? ";
			statement = connect.prepareStatement(query);
			statement.setInt(1, result_id);
			statement.execute();	
			
			statement.close();
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}

}
