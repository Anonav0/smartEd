
    <%@include file="include/headerAdmin.jsp" %>

		
    <div class="container">
    <div class="card bg-body-tertiary rounded-3">
      <div class="card-body">
        <h2 class="card-title">Student Form</h2>
        <form  action="${pageContext.request.contextPath}/operation" method="post">
          
   
          <div class="mb-3">
                <label for="email" class="form-label">Enter Email to find user corresponding to the mail id</label>
                <input type="email" class="form-control" id="email" name="email" required>
		  </div>
          
		<input type="hidden" name="form" value="loadSquestionAndOTP">
		<input class="btn btn-success" type="submit" value="Find User">
        </form>
      </div>
    </div>
  </div>
    <%@include file="include/footerAdmin.jsp" %>
		