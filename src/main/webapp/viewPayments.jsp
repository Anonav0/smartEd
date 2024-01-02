 <%@ page import="java.util.List" %>
<%@ page import="org.swarnavo.entity.Payment" %>

<%@include file="include/headerAdmin.jsp" %>




			

  <div class="container">
    <h1>Student Information</h1>
    <hr>
     <div class="card bg-body-tertiary rounded-3">
    <table class="table  table-striped table-hover">
      <thead>
        <tr class="table-primary ">
          <th>Serial No</th>
          <th>Date</th>
          <th>Institute</th>
          <th>Course</th>
          <th>Roll Number</th>
          <th>Semester</th>
          <th>Name</th>
		  <th>Email</th>
		  <th>Total</th>
		  <th>UTR Number</th>
        </tr>
      </thead>
      <tbody>

     
				<%
					List<Payment> listPayments = (List<Payment>) request.getAttribute("listPayments");
					String updateURL;
					for (int i = 0; i < listPayments.size(); i++) {
						out.print("<tr>");
						out.print("<td>" + listPayments.get(i).getFee_id() + "</td>");
						out.print("<td>" + listPayments.get(i).getDate() + "</td>");
						out.print("<td>" + listPayments.get(i).getInstitute() + "</td>");
						out.print("<td>" + listPayments.get(i).getCourse() + "</td>");
						out.print("<td>" + listPayments.get(i).getRoll_no() + "</td>");
						out.print("<td>" + listPayments.get(i).getSem() + "</td>");
						out.print("<td>" + listPayments.get(i).getName() + "</td>");
						out.print("<td>" + listPayments.get(i).getEmail() + "</td>");
						out.print("<td>" + listPayments.get(i).getTotal() + "</td>");
						out.print("<td>" + listPayments.get(i).getUtr() + "</td>");
						out.print("</tr>");
						
					}
				%>


      </tbody>
    </table>
    </div>
    
  </div>



    <%@include file="include/footerAdmin.jsp" %>
  