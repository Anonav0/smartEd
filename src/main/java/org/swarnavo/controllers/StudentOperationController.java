package org.swarnavo.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.swarnavo.entity.Admin;
import org.swarnavo.entity.Student;
import org.swarnavo.model.AdminModel;
import org.swarnavo.model.StudentModel;

/**
 * Servlet implementation class StudentOperationController
 */
@WebServlet("/operation/studentop")
public class StudentOperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  @Resource(name = "jdbc/project")
	  private DataSource dataSource;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getParameter("page");
		page = page.toLowerCase();
		
		switch (page) {
		case "viewresult":
		      HttpSession session = request.getSession();
		      String course = (String) session.getAttribute("course");
		      System.out.println(course);
		      int roll_no = Integer.parseInt((String) session.getAttribute("roll_no"));
		      course = course.toLowerCase();
		      if (course.equalsIgnoreCase("bca")) {
		        listStudentResultBCA(request, response, roll_no);
		      } else if (course.equalsIgnoreCase("bba")) {
		    	  listStudentResultBBA(request,response,roll_no);
		      } else if (course.equalsIgnoreCase("bhm")) {
		    	  listStudentResultBHM(request,response,roll_no);
		      }
			break;
		case "viewprofile":
			viewProfile(request,response);
			break;
		case "studentlogout":
			studentLogoutOperation(request,response);
			break;

		default:
			break;
		}
	}

	private void viewProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("username");
		
		
		List<Student> studentDetArr = new ArrayList<Student>();
		studentDetArr = new StudentModel().studentDet(dataSource, username);

		for(int i=0; i< studentDetArr.size(); i++) {
			request.setAttribute("course", studentDetArr.get(i).getCourse());
			request.setAttribute("branch", studentDetArr.get(i).getBranch());
			request.setAttribute("roll_no", studentDetArr.get(i).getRoll_no());
			request.setAttribute("name", studentDetArr.get(i).getName());
			request.setAttribute("dob", studentDetArr.get(i).getDob());
			request.setAttribute("email", studentDetArr.get(i).getEmail());
			request.setAttribute("father_name", studentDetArr.get(i).getFather_name());
			request.setAttribute("gender", studentDetArr.get(i).getGender());

		}
		request.setAttribute("studentDetArr", studentDetArr);
		System.out.println(studentDetArr);
//		System.out.println(request.getAttribute("adminDetArr"));

		request.getRequestDispatcher("/studentProfile.jsp").forward(request, response);
	}

	private void studentLogoutOperation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	  	request.getSession().removeAttribute("username");
	  	request.getSession().removeAttribute("course");
	  	request.getSession().removeAttribute("roll_no");

		request.setAttribute("title", "Home ");
//		request.getRequestDispatcher("/index.jsp").forward(request, response);
		response.sendRedirect("http://localhost:8080/Student_Result_Management_System/");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		operation = operation.toLowerCase();

		switch (operation) {
		case "studentloginoperation":
			studentLoginOp(request,response);
			
			break;


		default:
			break;
		}

		
	}

	private void studentLoginOp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
	      String course = request.getParameter("course");
	      String roll_no = request.getParameter("roll_no");
	      int password = Integer.parseInt(request.getParameter("password"));
	      
	      
	      StudentModel studentObj = new StudentModel();
	      String name = studentObj.studentName(dataSource, Integer.parseInt(roll_no));
	      int retrivedPass = studentObj.studentPass(dataSource, Integer.parseInt(roll_no));
	      
	      HttpSession session = request.getSession();
	      
	      session.setAttribute("course", course);
	      session.setAttribute("roll_no", roll_no);
	      session.setAttribute("username", name );
	      if (roll_no.equalsIgnoreCase(roll_no) && password == retrivedPass) {
		      request.setAttribute("alertType", "Primary");
		      request.setAttribute("alertMsg", "Student Login confirmed!");
	  		request.getRequestDispatcher("/studentHome.jsp").forward(request, response);	    	  
	      } else {
	    	  //error page handling
		      request.setAttribute("alertType", "danger");
		      request.setAttribute("alertMsg", "Password or roll is wrong.Check proper stream");
//	  		request.getRequestDispatcher("/studentlogin.jsp").forward(request, response);
		      response.sendRedirect("http://localhost:8080/Student_Result_Management_System/operation?page=studentLogin");
	      }


	}
	
	
	  protected void listStudentResultBCA(HttpServletRequest request, HttpServletResponse response, int roll_no) throws ServletException, IOException {
		    Connection connect = null;
		    PreparedStatement statement = null;
		    ResultSet rs = null;

		    try {
		      connect = dataSource.getConnection();

		      String query = "SELECT students.roll_no, students.course, students.branch, students.name, students.father_name, students.gender,students.email,  resultBCA.it, resultBCA.network,  resultBCA.elective, resultBCA.it_lab,  resultBCA.network_lab,resultBCA.minor_project, resultBCA.remark FROM students INNER JOIN resultBCA  ON students.roll_no = resultBCA.roll_no where students.roll_no =? ";

		      statement = connect.prepareStatement(query);
		      statement.setInt(1, roll_no);
		      rs = statement.executeQuery();

		      while (rs.next()) {
		        System.out.println("Working" + rs.getString("roll_no"));
		        request.setAttribute("roll_no", rs.getString(1));
		        request.setAttribute("course", rs.getString(2));
		        request.setAttribute("branch", rs.getString(3));
		        request.setAttribute("name", rs.getString(4));
		        request.setAttribute("father_name", rs.getString(5));
		        request.setAttribute("gender", rs.getString(6));
		        request.setAttribute("email", rs.getString(7));
		        request.setAttribute("it", rs.getString(8));
		        request.setAttribute("network", rs.getString(9));
		        request.setAttribute("elective", rs.getString(10));
		        request.setAttribute("it_lab", rs.getString(11));
		        request.setAttribute("network_lab", rs.getString(12));
		        request.setAttribute("minor_project", rs.getString(13));
		        request.setAttribute("remark", rs.getString(14));

		      }
		      connect.close();
		      statement.close();
		      rs.close();
		      request.setAttribute("alertType", "Primary");
		      request.setAttribute("alertMsg", "Please check you score properly. If any doubt contact institute.");
		      request.getRequestDispatcher("/viewStudentBCA.jsp").forward(request, response);
		    } catch (SQLException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }

		  }
	  
	  protected void listStudentResultBBA(HttpServletRequest request, HttpServletResponse response, int roll_no) throws ServletException, IOException {
		    Connection connect = null;
		    PreparedStatement statement = null;
		    ResultSet rs = null;

		    try {
		      connect = dataSource.getConnection();

		      String query = "SELECT students.roll_no, students.course, students.branch, students.name, students.father_name, students.gender, students.email, resultBBA.management_acc, resultBBA.ad_sales,  resultBBA.ind_relations, resultBBA.public_serv,  resultBBA.project,  resultBBA.remark FROM students INNER JOIN resultBBA ON students.roll_no = resultBBA.roll_no where students.roll_no =? ";

		      statement = connect.prepareStatement(query);
		      statement.setInt(1, roll_no);
		      rs = statement.executeQuery();

		      while (rs.next()) {
		        System.out.println("Working" + rs.getString("roll_no"));
		        request.setAttribute("roll_no", rs.getString(1));
		        request.setAttribute("course", rs.getString(2));
		        request.setAttribute("branch", rs.getString(3));
		        request.setAttribute("name", rs.getString(4));
		        request.setAttribute("father_name", rs.getString(5));
		        request.setAttribute("gender", rs.getString(6));
		        request.setAttribute("email", rs.getString(7));
		        request.setAttribute("management_acc", rs.getString(8));
		        request.setAttribute("ad_sales", rs.getString(9));
		        request.setAttribute("ind_relations", rs.getString(10));
		        request.setAttribute("public_serv", rs.getString(11));
		        request.setAttribute("project", rs.getString(12));
		        request.setAttribute("remark", rs.getString(13));

		      }
		      connect.close();
		      statement.close();
		      rs.close();
		      request.setAttribute("alertType", "Primary");
		      request.setAttribute("alertMsg", "Please check you score properly. If any doubt contact institute.");
	  		request.getRequestDispatcher("/studentHome.jsp").forward(request, response);
		      request.getRequestDispatcher("/viewStudentBBA.jsp").forward(request, response);
		    } catch (SQLException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }

		  }
	  
	  protected void listStudentResultBHM(HttpServletRequest request, HttpServletResponse response, int roll_no) throws ServletException, IOException {
		    Connection connect = null;
		    PreparedStatement statement = null;
		    ResultSet rs = null;

		    try {
		      connect = dataSource.getConnection();

		      String query = "SELECT students.roll_no, students.course, students.branch, students.name, students.father_name, students.gender, students.email, resultBHM.epi_health, resultBHM.support_ut,  resultBHM.fm_ra, resultBHM.project,  resultBHM.remark FROM students INNER JOIN resultBHM ON students.roll_no = resultBHM.roll_no where students.roll_no =? ";

		      statement = connect.prepareStatement(query);
		      statement.setInt(1, roll_no);
		      rs = statement.executeQuery();

		      while (rs.next()) {
		        System.out.println("Working" + rs.getString("roll_no"));
		        request.setAttribute("roll_no", rs.getString(1));
		        request.setAttribute("course", rs.getString(2));
		        request.setAttribute("branch", rs.getString(3));
		        request.setAttribute("name", rs.getString(4));
		        request.setAttribute("father_name", rs.getString(5));
		        request.setAttribute("gender", rs.getString(6));
		        request.setAttribute("email", rs.getString(7));
		        request.setAttribute("epi_health", rs.getString(8));
		        request.setAttribute("support_ut", rs.getString(9));
		        request.setAttribute("fm_ra", rs.getString(10));
		        request.setAttribute("project", rs.getString(11));
		        request.setAttribute("remark", rs.getString(12));

		      }
		      connect.close();
		      statement.close();
		      rs.close();
		      request.setAttribute("alertType", "Primary");
		      request.setAttribute("alertMsg", "Please check you score properly. If any doubt contact institute.");
		      request.getRequestDispatcher("/viewStudentBHM.jsp").forward(request, response);
		    } catch (SQLException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }

		  }

}
