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
import org.swarnavo.entity.Student;

public class BBAModel {
	public List<ResultBBA> listResults(DataSource dataSource) {
		// 1. Initialise connection objects
		List<ResultBBA> listResult = new ArrayList<ResultBBA>();
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			connect = dataSource.getConnection();
			
			// 2. Create a Sql statements string
			String query = "Select * from resultBBA";
			stmt = connect.createStatement();
			
			//3. Execute SQL statement
			rs = stmt.executeQuery(query);
			
			//4. Process the result set
			while(rs.next()) {
				listResult.add(new ResultBBA(rs.getInt("result_id"),
						rs.getInt("roll_no"),
						rs.getInt("management_acc"),
						rs.getInt("ad_sales"),
						rs.getInt("ind_relations"),
						rs.getInt("public_serv"),
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
	
	public void addBBARes(DataSource dataSource, ResultBBA newRes) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			int roll_no = newRes.getRoll_no();
			int management_acc = newRes.getManagement_acc();
			int ad_sales = newRes.getAd_sales();
			int ind_relations = newRes.getInd_relations();
			int public_serv= newRes.getPublic_serv();
			int project = newRes.getProject();
			String remark = newRes.getRemark();
			String query = "insert into resultBBA (roll_no,management_acc,ad_sales,ind_relations,public_serv,project,remark) values (?,?,?,?,?,?,?)";
			statement = connect.prepareStatement(query);
			statement.setInt(1, roll_no);
			statement.setInt(2, management_acc);
			statement.setInt(3, ad_sales);
			statement.setInt(4, ind_relations);
			statement.setInt(5, public_serv);
			statement.setInt(6, project);
			statement.setString(7, remark);
			statement.execute();
			
			
			statement.close();
			connect.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateBBARes(DataSource dataSource, ResultBBA updatedBBA) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			int reslId = updatedBBA.getResult_id();
			int roll_no = updatedBBA.getRoll_no();
			int management_acc = updatedBBA.getManagement_acc();
			int ad_sales = updatedBBA.getAd_sales();
			int ind_relations = updatedBBA.getInd_relations();
			int public_serv= updatedBBA.getPublic_serv();
			int project = updatedBBA.getProject();
			String remark = updatedBBA.getRemark();
			String query = "update resultBBA set roll_no = ? , management_acc = ?, ad_sales = ?, ind_relations = ?, public_serv = ?, project = ?, remark = ? where result_id = ? ";
			statement = connect.prepareStatement(query);
			statement.setInt(1, roll_no);
			statement.setInt(2, management_acc);
			statement.setInt(3, ad_sales);
			statement.setInt(4, ind_relations);
			statement.setInt(5, public_serv);
			statement.setInt(6, project);
			statement.setString(7, remark);
			statement.setInt(8, reslId );
			statement.execute();
			
			statement.close();
			connect.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}
	
	public void deleteBBARes(DataSource dataSource,int result_id) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			String query = "delete from resultBBA where result_id = ? ";
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
