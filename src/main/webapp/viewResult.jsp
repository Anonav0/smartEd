<%@include file="include/headerAdmin.jsp" %>
     <%@ page import="java.util.List" %>
    <%@ page import="org.swarnavo.entity.ResultBBA" %>
        <%@ page import="org.swarnavo.entity.ResultBCA" %>
        <%@ page import="org.swarnavo.entity.ResultBHM" %>
    
	<div class="container">
	<h1>Listing BBA Results</h1>
			<hr />
			<table class="table table-striped table-hover">
				<thead class="table-primary">
					<th>result_id No</th>
					<th>roll_no</th>
					<th>management_ac</th>
					<th>ad_sales</th>
					<th>ind_relations</th>
					<th>public_serv Name</th>
					<th>project</th>
					<th>remark</th>
					<th>Operations</th>
				</thead>
				<%!String deleteURL1;%>
				<%
					List<ResultBBA> listBBA = (List<ResultBBA>) request.getAttribute("listBBA");
					String updateURL1;
					for (int i = 0; i < listBBA.size(); i++) {
						out.print("<tr>");
						out.print("<td>" + listBBA.get(i).getResult_id() + "</td>");
						out.print("<td>" + listBBA.get(i).getRoll_no() + "</td>");
						out.print("<td>" + listBBA.get(i).getManagement_acc() + "</td>");
						out.print("<td>" + listBBA.get(i).getAd_sales() + "</td>");
						out.print("<td>" + listBBA.get(i).getInd_relations() + "</td>");
						out.print("<td>" + listBBA.get(i).getPublic_serv() + "</td>");
						out.print("<td>" + listBBA.get(i).getProject() + "</td>");
						out.print("<td>" + listBBA.get(i).getRemark() + "</td>");
						updateURL1 = request.getContextPath() + "/operation/adminop/genform?page=updateBBA" + "&result_id="
								+ listBBA.get(i).getResult_id() + "&roll_no=" + listBBA.get(i).getRoll_no() + "&management_acc="
								+ listBBA.get(i).getManagement_acc() + "&ad_sales=" +  listBBA.get(i).getAd_sales() + "&ind_relations="
								+  listBBA.get(i).getInd_relations()  + "&public_serv="
								+  listBBA.get(i).getPublic_serv() + "&project=" +  listBBA.get(i).getProject() + "&remark="
								+ listBBA.get(i).getRemark();
						
						deleteURL1 = request.getContextPath() + "/operation/adminop/genform?page=deleteBBA" + "&result_id="
								+ listBBA.get(i).getResult_id();
						out.print("<td><a class=\"btn btn-warning\" href=" + updateURL1 + ">Update</a> ");
				%>
				<a  class="btn btn-danger" href="<%=deleteURL1%>"
					onclick="if(!confirm('Are you sure to delete the user?')) return false">Delete</a>
				</td>
				</tr>
				<%
					}
				%>
			</table>
			
			<hr>
			
			<h1>Listing BCA Results</h1>
			<hr />
			<table class="table table-striped table-hover">
				<thead class="table-warning">
					<th>result_id No</th>
					<th>roll_no</th>
					<th>it</th>
					<th>network</th>
					<th>elective</th>
					<th>it_lab</th>
					<th>network_lab</th>
					<th>Minor Project</th>
					<th>remark</th>
					<th>Operations</th>
				</thead>
				<%!String deleteURL2;%>
				<%
					List<ResultBCA> listBCA = (List<ResultBCA>) request.getAttribute("listBCA");
					String updateURL2;
					for (int i = 0; i < listBCA.size(); i++) {
						out.print("<tr>");
						out.print("<td>" + listBCA.get(i).getResult_id() + "</td>");
						out.print("<td>" + listBCA.get(i).getRoll_no() + "</td>");
						out.print("<td>" + listBCA.get(i).getIt() + "</td>");
						out.print("<td>" + listBCA.get(i).getNetwork() + "</td>");
						out.print("<td>" + listBCA.get(i).getElective() + "</td>");
						out.print("<td>" + listBCA.get(i).getIt_lab() + "</td>");
						out.print("<td>" + listBCA.get(i).getNetwork_lab() + "</td>");
						out.print("<td>" + listBCA.get(i).getMinor_project() + "</td>");
						out.print("<td>" + listBCA.get(i).getRemark() + "</td>");
						updateURL2 = request.getContextPath() + "/operation/adminop/genform?page=updateBCA" + "&result_id="
								+ listBCA.get(i).getResult_id() + "&roll_no=" + listBCA.get(i).getRoll_no() + "&it="
								+ listBCA.get(i).getIt() + "&network=" +  listBCA.get(i).getNetwork() + "&elective="
								+  listBCA.get(i).getElective()  + "&it_lab="
								+  listBCA.get(i).getIt_lab() + "&minor_project=" +  listBCA.get(i).getMinor_project() + "&network_lab"
								+ listBCA.get(i).getNetwork_lab()
								+ "&remark=" + listBCA.get(i).getRemark();
						
						deleteURL2 = request.getContextPath() + "/operation/adminop/genform?page=deleteBCA" + "&result_id="
								+ listBCA.get(i).getResult_id();
						out.print("<td><a class=\"btn btn-warning\" href=" + updateURL2 + ">Update</a> ");
				%>
				<a  class="btn btn-danger" href="<%=deleteURL2%>"
					onclick="if(!confirm('Are you sure to delete the user?')) return false">Delete</a>
				</td>
				</tr>
				<%
					}
				%>
			</table>
			
			<hr>
			
			<h1>Listing BHM Results</h1>
			<hr />
			<table class="table table-striped table-hover">
				<thead class="table-success">
					<th>result_id No</th>
					<th>roll_no</th>
					<th>epi_health</th>
					<th>support_ut</th>
					<th>fm_ra</th>
					<th>project</th>
					<th>remark</th>
					<th>Operations</th>
				</thead>
				<%!String deleteURL3;%>
				<%
					List<ResultBHM> listBHM = (List<ResultBHM>) request.getAttribute("listBHM");
					String updateURL3;
					for (int i = 0; i < listBHM.size(); i++) {
						out.print("<tr>");
						out.print("<td>" + listBHM.get(i).getResult_id() + "</td>");
						out.print("<td>" + listBHM.get(i).getRoll_no() + "</td>");
						out.print("<td>" + listBHM.get(i).getEpi_health() + "</td>");
						out.print("<td>" + listBHM.get(i).getSupport_ut() + "</td>");
						out.print("<td>" + listBHM.get(i).getFm_ra() + "</td>");
						out.print("<td>" + listBHM.get(i).getProject() + "</td>");
						out.print("<td>" + listBHM.get(i).getRemark() + "</td>");
						updateURL3 = request.getContextPath() + "/operation/adminop/genform?page=updateBHM" + "&result_id="
								+ listBHM.get(i).getResult_id() + "&roll_no=" + listBHM.get(i).getRoll_no() + "&epi_health="
								+ listBHM.get(i).getEpi_health() + "&support_ut=" +  listBHM.get(i).getSupport_ut() + "&fm_ra="
								+  listBHM.get(i).getFm_ra()  + "&project="
								+  listBHM.get(i).getProject() + "&remark=" + listBHM.get(i).getRemark();
						
						deleteURL3 = request.getContextPath() + "/operation/adminop/genform?page=deleteBHM" + "&result_id="
								+ listBHM.get(i).getResult_id();
						out.print("<td><a class=\"btn btn-warning\" href=" + updateURL3 + ">Update</a> ");
				%>
				<a  class="btn btn-danger" href="<%=deleteURL3%>"
					onclick="if(!confirm('Are you sure to delete the user?')) return false">Delete</a>
				</td>
				</tr>
				<%
					}
				%>
			</table>
				</div>
			
<%@include file="include/footerAdmin.jsp" %>
			