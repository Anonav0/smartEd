
    <%@include file="include/headerAdmin.jsp" %>

		
    <div class="container">
    <div class="card bg-body-tertiary rounded-3">
      <div class="card-body">
        <h2 class="card-title">Student Form</h2>
        <form  action="${pageContext.request.contextPath}/operation" method="post">
          
   
          <div class="mb-3">
                <label for="email" class="form-label">Entered Email</label>
                <input type="email" class="form-control" id="email" name="email" value="${param.email }" required>
		  </div>
		  
		  <div class="mb-3">
                <label for="user" class="form-label">The found user : </label>
                <p><%= request.getAttribute("user") %></p>
		  </div>

		  <div class="mb-3">
                <label for="sanswer" class="form-label">What is your favourite food?</label>
                <input type="text" class="form-control" id="sanswer" name="sanswer"  required>
		  </div>		  
		  <div class="mb-3">
                <label for="otp" class="form-label">Your OTP</label>
                <input type="number" class="form-control" id="otp" name="otp"  required>
		  </div>
          
		<input type="hidden" name="form" value="changePass">
		<input class="btn btn-success" type="submit" value="Verify">
        </form>
      </div>
    </div>
  </div>
    <%@include file="include/footerAdmin.jsp" %>
		