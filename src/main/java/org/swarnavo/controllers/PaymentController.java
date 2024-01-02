package org.swarnavo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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

import org.swarnavo.entity.Payment;
import org.swarnavo.entity.Student;
import org.swarnavo.model.PaymentModel;
import org.swarnavo.model.StudentModel;

/**
 * Servlet implementation class PaymentController
 */
@WebServlet("/payment")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/project")
	private DataSource dataSource;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = request.getParameter("page");
		page = page.toLowerCase();
		switch (page) {
		case "makepayment":
			paymentProcess(request, response);
			break;
		case "viewpaymenthistory":
			loadPayments(request, response);
			break;
		default:
			errorPage(request, response);
		}
	}

	private void loadPayments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		List<Payment> listPayments = new ArrayList<Payment>();
		listPayments = new PaymentModel().listPayments(dataSource);
		request.setAttribute("listPayments", listPayments);
		request.getRequestDispatcher("/viewPayments.jsp").forward(request, response);
		
	}

	private void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("title", "Payment Page");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}

	private void paymentProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("paymentForm.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		operation = operation.toLowerCase();
		
		switch (operation) {
		case "addpaymentoperation":
			
			Payment newPayment = new Payment(request.getParameter("institute"), request.getParameter("course"),
					Integer.parseInt(request.getParameter("roll_no")), Integer.parseInt(request.getParameter("sem")),
					request.getParameter("name"),request.getParameter("email"), Integer.parseInt(request.getParameter("books")), 
					Integer.parseInt(request.getParameter("copies")), Integer.parseInt(request.getParameter("sem_fee")),
					Integer.parseInt(request.getParameter("com_fee")), Integer.parseInt(request.getParameter("misc")), 
					Integer.parseInt(request.getParameter("total")), Integer.parseInt(request.getParameter("utr")));
			
			String to = request.getParameter("email");
			String receipt = "Hello " + request.getParameter("name") + ".Your payment was SUCCESSFUL!.\n Please check the receipt of your payment of fee for semester : " + request.getParameter("sem")+ "\n"+
					"Stationaries \n \t BOOKS : \t\t\t" + request.getParameter("books") + "\n \t COPIES : \t\t\t" + request.getParameter("copies") +
					"\n FEE STRUCTURE \n \t SEMESTER FEE : \t\t\t" + request.getParameter("sem_fee") + "\n \t COMPUTER FEE : \t\t\t" + request.getParameter("com_fee") +
					"\n MISCELANEOUS EXPENSES : \t\t\t" + request.getParameter("misc") + "\n TOTAL : \t\t\t\t" + request.getParameter("total") +
					"\n THANK YOU FOR THE PAYMENT. \n regards, Swarnavo"; 
			
			addPaymentOperation(newPayment);
			sendMailToStudent(to, receipt);
			request.getRequestDispatcher("/paymentSuccess.jsp").forward(request, response);
			System.out.println("add payment working");
			
			
			break;

		default:
			break;
		}
	}

	private void sendMailToStudent(String to, String receipt) {
        String from = "minorprojectgroup4@gmail.com"; // Your Gmail address
        String password = "fbowzakjmaxpphio"; // Your Gmail password
        String subject = "PAYMENT SUCCESSFULL! RECEIPT.";
        
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
            message.setSubject(subject);
            message.setText(receipt);

            Transport.send(message);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
		
	}

	private void addPaymentOperation(Payment newPayment) {
		new PaymentModel().addPayment(dataSource, newPayment);
		return;
		
	}

}
