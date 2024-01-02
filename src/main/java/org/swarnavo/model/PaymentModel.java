package org.swarnavo.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.swarnavo.entity.Payment;

public class PaymentModel {

  public List < Payment > listPayments(DataSource dataSource) {

    List < Payment > listPayments = new ArrayList < > ();
    Connection connect = null;
    Statement stmt = null;
    ResultSet rs = null;

    
    try {
		connect = dataSource.getConnection();

    	
    	String query = "Select * from fees";
      stmt = connect.createStatement();
      rs = stmt.executeQuery(query);

      while (rs.next()) {

        listPayments.add(new Payment(rs.getInt("fee_id"), rs.getDate("date"), rs.getString("institute"),
          rs.getString("course"), rs.getInt("roll_no"), rs.getInt("sem"), rs.getString("name"), rs.getString("email"), rs.getInt("books"), rs.getInt("copies"), rs.getInt("sem_fee"),
          rs.getInt("com_fee"), rs.getInt("misc"), rs.getInt("total"), rs.getInt("utr")
        ));
      }
		connect.close();
		stmt.close();
		rs.close();

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return listPayments;
  }

  public void addPayment(DataSource dataSource, Payment newPayment) {
    Connection connect = null;
    PreparedStatement statement = null;
    java.util.Date currentDate = new java.util.Date();
    Date sqlDate = new Date(currentDate.getTime());

    try {
      connect = dataSource.getConnection();
      String institute = newPayment.getInstitute();
      String course = newPayment.getCourse();
      int roll_no = newPayment.getRoll_no();
      int sem = newPayment.getSem();
      String name = newPayment.getName();
      String email = newPayment.getEmail();
      int books = newPayment.getBooks();
      int copies = newPayment.getCopies();
      int sem_fee = newPayment.getSem_fee();
      int com_fee = newPayment.getCom_fee();
      int misc = newPayment.getMisc();
      int total = newPayment.getTotal();
      int utr = newPayment.getUtr();

      String query = "insert into fees (date,institute,course,roll_no,sem,name,email,books,copies,sem_fee,com_fee,misc,total,utr) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      statement = connect.prepareStatement(query);
      statement.setDate(1, sqlDate);
      statement.setString(2, institute);
      statement.setString(3, course);
      statement.setInt(4, roll_no);
      statement.setInt(5, sem);
      statement.setString(6, name);
      statement.setString(7, email);
      statement.setInt(8, books);
      statement.setInt(9, copies);
      statement.setInt(10, sem_fee);
      statement.setInt(11, com_fee);
      statement.setInt(12, misc);
      statement.setInt(13, total);
      statement.setInt(14, utr);
      statement.execute();
      
		statement.close();
		connect.close();

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}