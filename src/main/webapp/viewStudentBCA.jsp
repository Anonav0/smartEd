<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.List" %>
<%@ page import="org.swarnavo.entity.StudentResultBCA" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="java.io.*" %>
<%@ page import="javax.sql.DataSource" %>
<%@ include file="include/headerStud.jsp" %>

<div class="container">
<style>


table{
  width:100%;
  table-layout: fixed;
}
th{
  padding: 20px 15px;
  text-align: left;
  font-weight: 500;

    font-size: 14px;
  

  text-transform: uppercase;
 border: 2px solid rgba(255,255,255,0.3);
}
</style>




	<table cellpadding="0" cellspacing="0" border="0">
	<thead>
	 <tr>
	 	 <th >institution Name: TIIT</th>
	 	 <th >Course Name: <%= request.getAttribute("course") %></th>
	 	 <th >Branch Name: <%= request.getAttribute("branch") %></th>
	 	 <th >Roll No:<%= request.getAttribute("roll_no") %></th>
	 	 <th >Email :<%= request.getAttribute("email") %></th>	 	 


	 </tr>
	</thead>
	<thead>
		<tr>
			<th>Name:<%= request.getAttribute("name") %></th>
			<th>Father Name: <%= request.getAttribute("father_name") %></th>
			<th>Gender: <%= request.getAttribute("gender") %></th>
 			<th><a class="btn btn-outline-warning" titlt="print screen" alt="print screen" onclick="window.print();" target="_blank" style="cursor:pointer;">Print Result</a></th>

		</tr>
	</thead>
	</table>
	
	
	<style>


td {
  border: 2px solid #726E6D;
  padding: 15px;
  text-align:center;
}

thead{
  font-weight:bold;
  text-align:center;
}

table {
  border-collapse: collapse;
}



</style>
	<table class="table">
		<thead>
			<tr>
		        <td class="table-primary" colspan="3" >Course</td>
		        <td class="table-primary"  rowspan="2">Type</td>
		        <td class="table-primary"rowspan="2">Full Marks</td>
		        <td class="table-primary" rowspan="2">Passing Marks</td>
		        <td  class="table-primary" rowspan="2">Obtained Marks</td>

	      	</tr>
			<tr>
			    <td class="table-secondary" >Code </td>
			    <td class="table-secondary" colspan="2"> Name </td>
		    </tr>
		    
		    
		    	
		</thead>
		
    <tbody>
      <tr>
        <td >BCAC501</td>
        <td colspan="2">Internet Technology </td>
        <td>Theory</td>
        <td>100</td>
        <td> 30 </td>
        <td><%= request.getAttribute("it") %></td>
      </tr>
      <tr>
        <td>BCAC502</td>
        <td colspan="2" >Computer Networking </td>
        <td>Theory</td>
        <td>100</td>
        <td> 30 </td>
        <td><%= request.getAttribute("network") %></td>
      </tr>
      <tr>
        <td>BCAD501E</td>
        <td colspan="2" >Elective Subject </td>
        <td>Theory</td>
        <td>100</td>
        <td> 30 </td>
        <td><%= request.getAttribute("elective") %></td>
      </tr>
      <tr>
        <td>BCAC591</td>
        <td colspan="2">Internet Technology Lab</td>
        <td>Practical</td>
        <td>100</td>
        <td> 30 </td>
        <td><%= request.getAttribute("it_lab") %></td>
      </tr>
      <tr>
        <td>BCAC592</td>
        <td colspan="2">Computer Networking Lab </td>
        <td>Practical</td>
        <td>100</td>
        <td> 30 </td>
        <td><%= request.getAttribute("network_lab") %></td>
      </tr>
      <tr>
        <td>BCAD581</td>
        <td colspan="2">Industrial Training and Minor Project</td>
        <td>Practical</td>
        <td>100</td>
        <td> 30 </td>
        <td><%= request.getAttribute("minor_project") %></td>
      </tr>

    </tbody>
<tfoot>
<%
String itVal = (String)  request.getAttribute("it");
String netVal = (String)  request.getAttribute("network");
String electVal = (String)  request.getAttribute("elective");
String itLabVal = (String)  request.getAttribute("it_lab");
String minorProjectValue = (String) request.getAttribute("minor_project");
String networkLabValue = (String) request.getAttribute("network_lab");

int itInt = 0;
int netInt = 0;
int electInt = 0;
int itLabInt = 0;
int minorProjectInt = 0;
int networkLabInt = 0;


if (itVal !=null) {
	itInt = Integer.parseInt(itVal);
}
if(netVal !=null) {
	netInt = Integer.parseInt(netVal);
}
if(electVal != null) {
	electInt = Integer.parseInt(electVal);
}
if(itLabVal != null) {
	itLabInt = Integer.parseInt(itLabVal);
}

if (minorProjectValue != null) {
    minorProjectInt = Integer.parseInt(minorProjectValue);
}

if (networkLabValue != null) {
    networkLabInt = Integer.parseInt(networkLabValue);
}



int sum = itInt + netInt + electInt + itLabInt +minorProjectInt + networkLabInt;
double percent = ((double)sum / 600) * 100;
String perStr =  Double.toString(percent);
%>
<%
 				
 				String studInfoURL = "/Student_Result_Management_System/payment?page=makePayment" + "&institute=TIIT" + "&course=" + request.getAttribute("course")
 							+ "&roll_no=" + request.getAttribute("roll_no") + "&name=" + request.getAttribute("name")+"&email=" + request.getAttribute("email");
%>

      <tr>
        <td colspan="4" class="footer">Total Marks</td>
        <td>560</td>
        <td>180</td>
        <td><%= sum %> </td>
      </tr>
      <tr>
        <td colspan="4" class="footer">Percentage</td>
        <td colspan="3"><%= perStr %>%</td>
      </tr>
</tfoot>
	
	</table>


      <a class="btn btn-outline-success" href="<%=studInfoURL%>">make payment</a>    


</div>
<%@ include file="include/footerStud.jsp" %>
