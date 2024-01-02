 <%@ page import="java.util.List" %>
<%@ page import="org.swarnavo.entity.Student" %>

<%@include file="include/headerAdmin.jsp" %>




			

  <div class="container">
    <h1>Student Information</h1>
    <hr>
     <div class="card bg-body-tertiary rounded-3">
    <table class="table  table-striped table-hover">
      <thead>
        <tr class="table-primary ">
          <th>Serial No</th>
          <th>Name</th>
          <th>Roll Number</th>
          <th>Date of Birth</th>
          <th>Password</th>
          <th>Email</th>
          <th>Course</th>
          <th>Branch</th>
          <th>Father's Name</th>
          <th>Gender</th>
          <th>Operations</th>
        </tr>
      </thead>
      <tbody>

        		<%!String deleteURL;%>
				<%
					List<Student> listStudents = (List<Student>) request.getAttribute("listStudents");
					String updateURL;
					for (int i = 0; i < listStudents.size(); i++) {
						out.print("<tr>");
						out.print("<td>" + listStudents.get(i).getStudent_id() + "</td>");
						out.print("<td>" + listStudents.get(i).getName() + "</td>");
						out.print("<td>" + listStudents.get(i).getRoll_no() + "</td>");
						out.print("<td>" + listStudents.get(i).getDob() + "</td>");
						out.print("<td>" + listStudents.get(i).getPassword() + "</td>");
						out.print("<td>" + listStudents.get(i).getEmail() + "</td>");
						out.print("<td>" + listStudents.get(i).getCourse() + "</td>");
						out.print("<td>" + listStudents.get(i).getBranch() + "</td>");
						out.print("<td>" + listStudents.get(i).getFather_name() + "</td>");
						out.print("<td>" + listStudents.get(i).getGender() + "</td>");
						updateURL = request.getContextPath() + "/operation/adminop?page=updateStudent" + "&student_id="
								+ listStudents.get(i).getStudent_id() + "&name=" + listStudents.get(i).getName() + "&course="
								+ listStudents.get(i).getCourse() + "&branch=" +  listStudents.get(i).getBranch() + "&roll_no="
								+  listStudents.get(i).getRoll_no()+ "&dob=" + listStudents.get(i).getDob() + "&password="+ listStudents.get(i).getPassword()+ "&email="+ listStudents.get(i).getEmail()  + "&father_name="
								+  listStudents.get(i).getFather_name() + "&gender=" +  listStudents.get(i).getGender();
						
						deleteURL = request.getContextPath() + "/operation/adminop?page=deleteStudent" + "&student_id="
								+ listStudents.get(i).getStudent_id();
						out.print("<td><a   class=\"btn btn-primary\" href=" + updateURL + ">Update</a> ");
				%>
				<a  class="btn btn-danger" href="<%=deleteURL%>"
					onclick="if(!confirm('Are you sure to delete the user?')) return false">Delete</a>
				</td>
				</tr>
				<%
					}
				%>
      </tbody>
    </table>
    </div>
    
  </div>



    <%@include file="include/footerAdmin.jsp" %>
  