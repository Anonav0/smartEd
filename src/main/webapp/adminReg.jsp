<%@include file="include/header.jsp" %>
  <div class="container">
    <div class="row justify-content-center mt-5">
      <div class="col-md-6">
        <div class="card">
          <div class="card-body">
            <h2 class="card-title">Administrator Registration</h2>
            <form action="${pageContext.request.contextPath}/operation" method="post">
              <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <input type="text" class="form-control" id="name" name="name" required>
              </div>

              <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" required>
              </div>

              <div class="mb-3">
                <label for="dob" class="form-label">Date of Birth</label>
                <input type="date" class="form-control" id="dob" name="dob" required>
              </div>

              <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" required>
              </div>

              <div class="mb-3">
                <label for="security-question" class="form-label">Security Question</label>
                <input type="text" class="form-control" id="security-question" name="squestion" value="What is your favourite food?" readonly required>
              </div>

              <div class="mb-3">
                <label for="security-answer" class="form-label">Security Answer</label>
                <input type="text" class="form-control" id="security-answer" name="sanswer" required>
              </div>


              <div class="mb-3">
            <label for="gender" class="form-label">Gender</label>
            <select class="form-select" id="gender" name="gender"  required="required">
              <option value="male">Male</option>
              <option value="female">Female</option>
              <option value="others">Others</option>
            </select>
          </div>
			<input type="hidden" name="form" value="adminEmailSendMail">
              <input type="submit" class="btn btn-primary" value="Register">
              
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>

<%@include file="include/footer.jsp" %>
