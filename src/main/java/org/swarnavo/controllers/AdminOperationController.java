package org.swarnavo.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.annotation.Resource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.swarnavo.entity.Admin;
import org.swarnavo.entity.ResultBBA;
import org.swarnavo.entity.ResultBCA;
import org.swarnavo.entity.ResultBHM;
import org.swarnavo.entity.Student;
import org.swarnavo.model.AdminModel;
import org.swarnavo.model.BBAModel;
import org.swarnavo.model.BCAModel;
import org.swarnavo.model.BHMModel;
import org.swarnavo.model.StudentModel;

/**
 * Servlet implementation class AdminOperationController
 */
@WebServlet("/operation/adminop")
public class AdminOperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/project")
	private DataSource dataSource;
	
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		page = page.toLowerCase();
		
		switch (page) {
		case "viewprofile":
			viewAdminProfile(request,response);
			
			break;
		case "insertstudent":
			request.setAttribute("title", "Add Student");
			request.getRequestDispatcher("/insertStudent.jsp").forward(request, response);
			break;
		case "insertresult":
			request.setAttribute("title", "Insert Result");
			request.getRequestDispatcher("/resultChoice.jsp").forward(request, response);
			break;
		case "updatestudent" :
			request.setAttribute("title", "Update Student");
			request.getRequestDispatcher("/updateStudent.jsp").forward(request, response);
			break;
		case "deletestudent":
			deleteStudent(Integer.parseInt(request.getParameter("student_id")));
		      request.setAttribute("alertType", "fail");
		      request.setAttribute("alertMsg", "Deletion operation successful");
			listStudents(request,response);
			break;
		case "registeredstudents":
			listStudents(request,response);
			break;
		case "studentresults":
			listResults(request,response);
			break;

		default:
			request.getRequestDispatcher("error.jsp").forward(request, response);
			break;
		}
	}
	
	private void viewAdminProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("username");
		
		
		List<Admin> adminDetArr = new ArrayList<Admin>();
		adminDetArr = new AdminModel().adminDet(dataSource, username);

		for(int i=0; i< adminDetArr.size(); i++) {
			request.setAttribute("name", adminDetArr.get(i).getName());
			request.setAttribute("dob", adminDetArr.get(i).getDob());
			request.setAttribute("gender", adminDetArr.get(i).getGender());
			request.setAttribute("email", adminDetArr.get(i).getEmail());
		}
		request.setAttribute("adminDetArr", adminDetArr);
		System.out.println(adminDetArr);
//		System.out.println(request.getAttribute("adminDetArr"));
		request.setAttribute("title","Admin Profile");
		request.getRequestDispatcher("/adminProfile.jsp").forward(request, response);
	}

	private void deleteStudent(int student_id) {
		new StudentModel().deleteStudent(dataSource,student_id);
		return;
		
	}
	
	protected void listResults(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("title", "All Student Results");
		List<ResultBBA> listBBA = new ArrayList<ResultBBA>();
		listBBA = new BBAModel().listResults(dataSource);
		request.setAttribute("listBBA", listBBA);
		
		List<ResultBCA> listBCA = new ArrayList<ResultBCA>();
		listBCA = new BCAModel().listResults(dataSource);
		request.setAttribute("listBCA", listBCA);
		
		List<ResultBHM> listBHM = new ArrayList<ResultBHM>();
		listBHM = new BHMModel().listResults(dataSource);
		request.setAttribute("listBHM", listBHM);
		request.getRequestDispatcher("/viewResult.jsp").forward(request, response);
		return;

	}

	protected void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "List Students");
		List<Student> listStudents = new ArrayList<Student>();
		listStudents = new StudentModel().listStudents(dataSource);
		request.setAttribute("listStudents", listStudents);
		request.getRequestDispatcher("/viewStudent.jsp").forward(request, response);
		return;
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("form");
		operation = operation.toLowerCase();
		
		switch (operation) {
		case "addstudentoperation":
			try {
			 String dobStr = request.getParameter("dob");
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date utilDate = sdf.parse(dobStr);
			java.sql.Date sqlDateDob = new java.sql.Date(utilDate.getTime());
			
			Student newStudent = new Student(request.getParameter("course"),
					request.getParameter("branch"), 
					Integer.parseInt(request.getParameter("roll_no")), 
					request.getParameter("name"),
					sqlDateDob,
					Integer.parseInt(request.getParameter("password")),
					request.getParameter("email"),
					request.getParameter("father_name"),
					request.getParameter("gender"));
			
			addStudentOperation(newStudent);
		      request.setAttribute("alertType", "success");
		      request.setAttribute("alertMsg", "Add opration successful!");
			listStudents(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			

			break;
		case "updatestudentoperation":

			
			try {
				 String dobStr = request.getParameter("dob");
				 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date utilDate = sdf.parse(dobStr);
				java.sql.Date sqlDateDob = new java.sql.Date(utilDate.getTime());
				
				Student updatedStudent = new Student(Integer.parseInt(request.getParameter("student_id")),request.getParameter("course"),
						request.getParameter("branch"), 
						Integer.parseInt(request.getParameter("roll_no")), 
						request.getParameter("name"),
						sqlDateDob,
						Integer.parseInt(request.getParameter("password")),
						request.getParameter("email"),
						request.getParameter("father_name"),
						request.getParameter("gender"));
				
				updateStudentOperation(dataSource, updatedStudent);
			      request.setAttribute("alertType", "success");
			      request.setAttribute("alertMsg", "update opration successful!");
				listStudents(request,response);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			break;
		
		case "sendmailforpasschange":
			sendMailForPassChange(request,response);
			break;
		case "updateadminpassword":
			upateAdminPassword(request,response);
			break;
		case "updateandchangeadminpass":
			changeAdminPass(request,response);
			break;
		default:
			break;
		}
		
		
	}

	



	private void changeAdminPass(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("user");
		int password = Integer.parseInt(request.getParameter("password"));
        updatePasswordOp(username,password);
        request.setAttribute("alertType", "primary");
        request.setAttribute("alertMsg", "password changed! Login again with new pasword");
        request.getRequestDispatcher("/adminLogin.jsp").forward(request, response);

		
	}

	private void upateAdminPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
	    String userEnteredOTP = request.getParameter("otp");
	    String username = (String) request.getSession().getAttribute("username");
	    int password = Integer.parseInt(request.getParameter("password"));
	    int storedOTP = (int) request.getSession().getAttribute("changePasswordOTP");
	    if (userEnteredOTP != null && userEnteredOTP.equals(String.valueOf(storedOTP))) {
	        // OTP verification successful
	        // You can proceed with user registration or other actions

	        // Clear the OTP from the session
	        request.getSession().removeAttribute("changePasswordOTP");
	        
	        updatePasswordOp(username,password);
		      request.setAttribute("alertType", "success");
		      request.setAttribute("alertMsg", "Password updated!");
	        request.getRequestDispatcher("/adminProfile.jsp").forward(request, response);
	        
	    }
	}

	private void updatePasswordOp(String username, int password) {
		new AdminModel().updateAdminPass(dataSource, username, password);		
	}

	private void sendMailForPassChange(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Generate OTP
	    int otp = generateOTP();

	    // Send OTP via email
	    String to = request.getParameter("email"); // Recipient's email address
	    String username = (String) request.getParameter("uname");
	    String from = "minorprojectgroup4@gmail.com"; // Your Gmail address
	    String password = "fbowzakjmaxpphio"; // Your Gmail password

	    // Configure email properties
	    Properties props = new Properties();
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "587");

	    Session session = Session.getInstance(props, new Authenticator() {
	      protected PasswordAuthentication getPasswordAuthentication() {
	        return new PasswordAuthentication(from, password);
	      }
	    });

	    try {
	      Message message = new MimeMessage(session);
	      message.setFrom(new InternetAddress(from));
	      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
	      message.setSubject("OTP for Registration");
	      message.setText("You are changing the password to the company. Your OTP for change password is: " + otp);

	      Transport.send(message);

	      // Store the OTP in a session attribute or database for verification
	      request.getSession().setAttribute("changePasswordOTP", otp);
	      request.getSession().setAttribute("name", username);
	      request.getSession().setAttribute("email", to);
	      
	      System.out.println(request.getSession().getAttribute("username"));
	      System.out.println(to);
	      System.out.println("OTP sent successfully!");
	      request.setAttribute("alertType", "success");
	      request.setAttribute("alertMsg", "OTP Sent successfully! check inbox");
	      request.getRequestDispatcher("/verifyPassChange.jsp").forward(request, response);
	    } catch (MessagingException e) {
	      throw new RuntimeException(e);
	    }
		
	}
	
	  private int generateOTP() {
		    // Generate a random 6-digit OTP
		    Random random = new Random();
		    return 100000 + random.nextInt(900000);
		  }

	private void updateStudentOperation(DataSource dataSource2, Student updatedStudent) {
		new StudentModel().updateStudent(dataSource,updatedStudent);
		return;
		
	}

	private void addStudentOperation(Student newStudent) {
		new StudentModel().addStudent(dataSource, newStudent);	
		return;
	}
	
	

}
