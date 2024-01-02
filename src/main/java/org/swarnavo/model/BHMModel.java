package org.swarnavo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.swarnavo.entity.ResultBHM;

public class BHMModel {
	
	public List<ResultBHM> listResults(DataSource dataSource) {
		// 1. Initialise connection objects
		List<ResultBHM> listResult = new ArrayList<ResultBHM>();
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			connect = dataSource.getConnection();
			
			// 2. Create a Sql statements string
			String query = "Select * from resultBHM";
			stmt = connect.createStatement();
			
			//3. Execute SQL statement
			rs = stmt.executeQuery(query);
			
			//4. Process the result set
			while(rs.next()) {
				listResult.add(new ResultBHM(rs.getInt("result_id"),
						rs.getInt("roll_no"),
						rs.getInt("epi_health"),
						rs.getInt("support_ut"),
						rs.getInt("fm_ra"),
						rs.getInt("project"),
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
	
	
	public void addBHMRes(DataSource dataSource, ResultBHM newRes) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			int roll_no = newRes.getRoll_no();
			int epi_health = newRes.getEpi_health();
			int support_ut = newRes.getSupport_ut();
			int fm_ra = newRes.getFm_ra();
			int project = newRes.getProject();
			String remark = newRes.getRemark();
			String query = "insert into resultBHM (roll_no,epi_health,support_ut,fm_ra,project,remark) values (?,?,?,?,?,?)";
			statement = connect.prepareStatement(query);
			statement.setInt(1, roll_no);
			statement.setInt(2, epi_health);
			statement.setInt(3, support_ut);
			statement.setInt(4, fm_ra);
			statement.setInt(5, project);
			statement.setString(6, remark);
			statement.execute();
			
			statement.close();
			connect.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateBHMRes(DataSource dataSource, ResultBHM updatedBHM) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			int reslId = updatedBHM.getResult_id();
			int roll_no = updatedBHM.getRoll_no();
			int epi_health = updatedBHM.getEpi_health();
			int support_ut = updatedBHM.getSupport_ut();
			int fm_ra= updatedBHM.getFm_ra();
			int project = updatedBHM.getProject();
			String remark = updatedBHM.getRemark();
			String query = "update resultBHM set roll_no = ? , epi_health = ?, support_ut= ?, fm_ra = ?, project = ?, remark = ? where result_id = ? ";
			statement = connect.prepareStatement(query);
			statement.setInt(1, roll_no);
			statement.setInt(2, epi_health);
			statement.setInt(3, support_ut);
			statement.setInt(4, fm_ra);
			statement.setInt(5, project);
			statement.setString(6, remark);
			statement.setInt(7, reslId );
			statement.execute();
			
			statement.close();
			connect.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}
	
	public void deleteBHMRes(DataSource dataSource,int result_id) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			String query = "delete from resultBHM where result_id = ? ";
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
