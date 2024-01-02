<%@include file="include/headerAdmin.jsp" %>

<div class="container">

  <div class="card mb-3">
    <div class="card-header">
      <h1>Profile</h1>
    </div>
    <div class="card-body">

      <div class="row">
        <div class="col-md-4">
          <img id="profile-image" src="https://placehold.it/200x200" alt="Profile Image" class="img-rounded">
          <button type="button" class="btn btn-primary mt-3" id="upload-image-button">Upload Image</button>
        </div>

        <div class="col-md-8">
          <table class="table table-striped">
            <tbody>
              <tr>
                <th>Name:</th>
                <td><%= request.getAttribute("name") %></td>
              </tr>
              <tr>
                <th>Date of Birth:</th>
                <td><%= request.getAttribute("dob") %></td>
              </tr>
              <tr>
                <th>Email:</th>
                <td><%= request.getAttribute("email") %></td>
              </tr>
			  <tr>
                <th>Gender:</th>
                <td><%= request.getAttribute("gender") %></td>
              </tr>
				<tr>
                <th>Password:</th>
                <td>**********</td>
              </tr>
            </tbody>
          </table>
			<%
				String email = (String) request.getAttribute("email");
			%>
          <form action="${pageContext.request.contextPath}/operation/adminop" method="post">
          	<input type="hidden" name="email" value="${email}"/>
          	<input type="hidden" name="form" value="sendMailForPassChange"/>
          	<input type="submit" class="btn btn-danger" value="change password"/>
          </form>
        </div>
      </div>

    </div>
  </div>

</div>

<%@include file="include/footerAdmin.jsp" %>
