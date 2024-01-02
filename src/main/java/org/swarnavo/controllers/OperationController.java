package org.swarnavo.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import org.swarnavo.model.AdminModel;


/**
 * Servlet implementation class OperationController
 */
@WebServlet("/operation")
public class OperationController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Resource(name = "jdbc/project")
  private DataSource dataSource;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String page = request.getParameter("page");
    page = page.toLowerCase();

    switch (page) {
    case "adminreg":
      adminRegPage(request, response);
      break;
    case "adminlogin":
      adminLoginPage(request, response);
      break;
    case "studentlogin":
      studentLoginPage(request, response);
      break;
    case "logoutadmin" :
    	logoutAdmin(request, response);
    	break;
    case "forgotpassword":
    	loadEmailForm(request,response);
    	break;
    default:
      errorPage(request, response);
    }

  }

  private void loadEmailForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setAttribute("title", "Forgot Password");
	  request.getRequestDispatcher("/forgotEmail.jsp").forward(request, response);
}

private void logoutAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	  	request.getSession().removeAttribute("username");
		request.setAttribute("title", "Homepage");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
}

private void adminRegPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setAttribute("title", "Admin Registration ");
    request.getRequestDispatcher("adminReg.jsp").forward(request, response);
  }

  public void adminLoginPage(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    request.setAttribute("title", "Admin Login Page");
    request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
  }

  public void studentLoginPage(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    request.setAttribute("title", "Student Login Page");
    request.getRequestDispatcher("studentlogin.jsp").forward(request, response);
  }

  public void errorPage(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    request.setAttribute("title", "Error page");
    request.getRequestDispatcher("error.jsp").forward(request, response);

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String operation = request.getParameter("form");
    operation = operation.toLowerCase();

    switch (operation) {
    case "adminemailsendmail":
      adminEmailSendMail(request, response);

      break;
    case "adminregistrationoperation":
      adminRegistrationOperation(request, response);
      break;
    case "adminloginoperation":
      String username = request.getParameter("username");
      int password = Integer.parseInt(request.getParameter("password"));

      adminLoginOperation(username, password, request, response);

      break;
    case "loadsquestionandotp" :
    	loadQuestionAndOTP(request,response);
    	
    	break;
    case "changepass":
    	changePassOp(request,response);

    default:
      break;
    }
  }

  private void changePassOp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String userEnteredOTP = request.getParameter("otp");
	    String answer = request.getParameter("sanswer");
	    int storedOTP = (int) request.getSession().getAttribute("forgotPasswordOTP");
	    String retrivedAnswer = (String) request.getSession().getAttribute("sanswer");
	    
	    if (userEnteredOTP != null && userEnteredOTP.equals(String.valueOf(storedOTP)) 
	    		&& answer != null && answer.equals(retrivedAnswer)) {
	        request.setAttribute("alertType", "primary");
	        request.setAttribute("alertMsg", "OTP verification successful");
	    	request.getRequestDispatcher("/changePass.jsp").forward(request, response);
	    } else {
	        request.setAttribute("alertType", "danger");
	        request.setAttribute("alertMsg", "password does not match");
	    	request.getRequestDispatcher("/changePass.jsp").forward(request, response);
	    }
	    
	    
	
}

private void loadQuestionAndOTP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	//Get email from form
	  String email = (String) request.getParameter("email");
	  
	  AdminModel adminObj = new AdminModel();
	  List<Admin> adminDet = new ArrayList<Admin>();
	  adminDet = adminObj.adminUnameAndSanswer(dataSource, email);
	  for(int i=0; i< adminDet.size(); i++) {
		  request.setAttribute("user", adminDet.get(i).getName());
		  request.getSession().setAttribute("user", adminDet.get(i).getName());
		  request.getSession().setAttribute("sanswer", adminDet.get(i).getSanswer());
	  }
	  
	  System.out.println(adminDet);
	  
	    // Generate OTP
	    int otp = generateOTP();

	    // Send OTP via email
	    String to = email; // Recipient's email address
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
	      message.setText("You are reseting your password to the company. Your OTP for verification is: " + otp);

	      Transport.send(message);

	      // Store the OTP in a session attribute or database for verification
	      request.getSession().setAttribute("forgotPasswordOTP", otp);

	      System.out.println("OTP sent successfully!");
	      request.setAttribute("alertType", "primary");
	      request.setAttribute("alertMsg", "Successfully sent OTP! Please check your inbox");
	      request.getRequestDispatcher("/verifyEmail.jsp").forward(request, response);
	    } catch (MessagingException e) {
	      throw new RuntimeException(e);
	    }
	
}

private void adminRegistrationOperation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String userEnteredOTP = request.getParameter("otp");
    int storedOTP = (int) request.getSession().getAttribute("registrationOTP");

    if (userEnteredOTP != null && userEnteredOTP.equals(String.valueOf(storedOTP))) {
      // OTP verification successful
      // You can proceed with user registration or other actions

      // Clear the OTP from the session
      request.getSession().removeAttribute("registrationOTP");

      String dobStr = request.getParameter("dob");

       
		try {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date utilDate = sdf.parse(dobStr);
		    java.sql.Date sqlDateDob = new java.sql.Date(utilDate.getTime());
		      Admin newAdmin = new Admin(request.getParameter("name"), Integer.parseInt(request.getParameter("password")), sqlDateDob, request.getParameter("gender"), request.getParameter("email"), request.getParameter("squestion"), request.getParameter("sanswer"));
		      addAdminOperation(newAdmin);
		      request.setAttribute("alertType", "success");
		      request.setAttribute("alertMsg", "Admin Registration was successful");
		      request.setAttribute("title", "admin Login");
				request.getRequestDispatcher("adminlogin.jsp").forward(request, response);


		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


      System.out.println("Admin added to DB!");
      System.out.println("Registration successful!");
      
      
    } else {
      // OTP verification failed
      System.out.println("OTP verification failed. Please try again.");
    }

  }

  private void addAdminOperation(Admin newAdmin) {
	new AdminModel().addAdmin(dataSource, newAdmin);
	
}

private void adminEmailSendMail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Generate OTP
    int otp = generateOTP();

    // Send OTP via email
    String to = request.getParameter("email"); // Recipient's email address
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
      message.setText("You are registering to the company. Your OTP for registration is: " + otp);

      Transport.send(message);

      // Store the OTP in a session attribute or database for verification
      request.getSession().setAttribute("registrationOTP", otp);

      System.out.println("OTP sent successfully!");
      request.setAttribute("alertType", "primary");
      request.setAttribute("alertMsg", "Successfully sent OTP! Please check your inbox");
      request.getRequestDispatcher("verifyReg.jsp").forward(request, response);
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
  }

  private int generateOTP() {
    // Generate a random 6-digit OTP
    Random random = new Random();
    return 100000 + random.nextInt(900000);
  }

  private void adminLoginOperation(String username, int password, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    AdminModel adminObj = new AdminModel();
    int retrivedPass = adminObj.adminPass(dataSource, username);
    System.out.println("The password is " + retrivedPass);
    System.out.println("The uname is " + username);
    if (username.equalsIgnoreCase(username) && password == retrivedPass) {
    	request.getSession().setAttribute("username", username);
        request.setAttribute("alertType", "primary");
        request.setAttribute("alertMsg", "Successfully logged in!");
      request.getRequestDispatcher("adminhome.jsp").forward(request, response);
    } else {
        request.setAttribute("alertType", "fail");
        request.setAttribute("alertMsg", "Wrong password or username");
    	adminLoginPage(request, response);
    }

  }




}