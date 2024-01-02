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
	 	 <th>institution Name: DGI</th>
	 	 <th>Course Name: <%= request.getAttribute("course") %></th>
	 	 <th>Branch Name: <%= request.getAttribute("branch") %></th>
	 	 <th>Roll No:<%= request.getAttribute("roll_no") %></th>	
	 	 	 	 <th>Email:<%= request.getAttribute("email") %></th>	 	 
	 	  	 


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
		        <td class="table-primary" rowspan="2">Type</td>
		        <td class="table-primary" rowspan="2">Full Marks</td>
		        <td class="table-primary" rowspan="2">Passing Marks</td>
		        <td class="table-primary" rowspan="2">Obtained Marks</td>

	      	</tr>
			<tr>
			    <td class="table-secondary">Code </td>
			    <td class="table-secondary" colspan="2"> Name </td>
		    </tr>
		    
		    
		    	
		</thead>
		
    <tbody>
      <tr>
        <td>BHM(N)-401 </td>
        <td colspan="2">Epidemiology and Analysis
of Health Information Data </td>
        <td>Theory</td>
        <td>100</td>
        <td> 30 </td>
        <td><%= request.getAttribute("epi_health") %></td>
      </tr>
      <tr>
        <td>BHM(N)-402 </td>
        <td colspan="2" >Support, Utility and
Clinical services-II</td>
        <td>Theory</td>
        <td>100</td>
        <td> 30 </td>
        <td><%= request.getAttribute("support_ut") %></td>
      </tr>
      <tr>
        <td>BHM(N)-404  </td>
        <td colspan="2" >Financial Management  </td>
        <td>Theory</td>
        <td>100</td>
        <td> 30 </td>
        <td><%= request.getAttribute("fm_ra") %></td>
      </tr>

        <td>BHM(N)-405 </td>
        <td colspan="2">Project and Viva</td>
        <td>Practical</td>
        <td>100</td>
        <td> 30 </td>
        <td><%= request.getAttribute("project") %></td>
      </tr>

    </tbody>
<tfoot>
<%
String s1 = (String)  request.getAttribute("epi_health");
String s2 = (String)  request.getAttribute("support_ut");
String s3 = (String)  request.getAttribute("fm_ra");
String s4 = (String)  request.getAttribute("project");


int s1Int = 0;
int s2Int = 0;
int s3Int = 0;
int s4Int = 0;


if (s1 !=null) {
	s1Int = Integer.parseInt(s1);
}
if(s2 !=null) {
	s2Int = Integer.parseInt(s2);
}
if(s3 != null) {
	s3Int = Integer.parseInt(s3);
}
if(s4 != null) {
	s4Int = Integer.parseInt(s4);
}




int sum = s1Int + s2Int + s3Int + s4Int ;
double percent = ((double)sum / 600) * 100;
String perStr =  Double.toString(percent);
%>
<%
 				
 				String studInfoURL = "/Student_Result_Management_System/payment?page=makePayment" + "&institute=TIIT" + "&course=" + request.getAttribute("course")
 							+ "&roll_no=" + request.getAttribute("roll_no") + "&name=" + request.getAttribute("name")+"&email=" + request.getAttribute("email");
%>

      <tr>
        <td colspan="4" class="footer">Total Marks</td>
        <td>400</td>
        <td>120</td>
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
