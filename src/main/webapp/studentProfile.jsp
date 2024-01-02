<%@include file="include/headerStud.jsp" %>

<div class="container">

  <div class="card mb-3">
    <div class="card-header">
      <h1>Profile</h1>
    </div>
    <div class="card-body">

      <div class="row">
        <div class="col-md-4">
          <img id="profile-image" src="https://placehold.it/200x200" alt="Profile Image" class="img-rounded">
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
              <th>Father Name:</th>
                <td><%= request.getAttribute("father_name") %></td>
              </tr>
			  <tr>
              <th>Course:</th>
                <td><%= request.getAttribute("course") %></td>
              </tr>
              			  <tr>
              <th>Gender:</th>
                <td><%= request.getAttribute("branch") %></td>
              </tr>
				<tr>
                <th>Password:</th>
                <td>**********</td>
              </tr>
            </tbody>
          </table>
			
        </div>
      </div>

    </div>
  </div>

</div>

<%@include file="include/footerStud.jsp" %>
