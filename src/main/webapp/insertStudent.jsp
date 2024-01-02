<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="include/headerAdmin.jsp" %>

		
    <div class="container">
    <div class="card bg-body-tertiary rounded-3">
      <div class="card-body">
        <h2 class="card-title">Student Form</h2>
        <form  action="${pageContext.request.contextPath}/operation/adminop" method="post">
          <div class="mb-3">
            <label for="course" class="form-label">Course</label>
            <select class="form-select" id="course" name="course" required="required">
              <option value="BCA">Bachelor's of Computer Application</option>
              <option value="BBA">Bachelor's of Business Administration</option>
              <option value="BHM">Bachelor's of Hospital Management</option>
            </select>
          </div>
          <div class="mb-3">
            <label for="branch" class="form-label">Branch</label>
            <input type="text" class="form-control" id="branch" name="branch" required="required">
          </div>
          <div class="mb-3">
            <label for="rollNumber" class="form-label">Roll Number</label>
            <input type="number" class="form-control" id="rollNumber" name="roll_no" required="required">
          </div>
          <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" name="name">
          </div>
          <div class="mb-3">
                <label for="dob" class="form-label">Date of Birth</label>
                <input type="date" class="form-control" id="dob" name="dob" required>
          </div>
          <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" required>
          </div>
          
          <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" required>
		  </div>
          <div class="mb-3">
            <label for="fatherName" class="form-label">Father's Name</label>
            <input type="text" class="form-control" id="fatherName" name="father_name" required="required">
          </div>
          <div class="mb-3">
            <label class="form-label">Gender</label>
            <div class="form-check">
              <input class="form-check-input" type="radio" name="gender" id="male" value="male">
              <label class="form-check-label" for="male">Male</label>
            </div>
            <div class="form-check">
              <input class="form-check-input" type="radio" name="gender" id="female" value="female">
              <label class="form-check-label" for="female">Female</label>
            </div>
          </div>
		<input type="hidden" name="form" value="addStudentOperation">
		<input class="btn btn-success" type="submit" value="Add Student">
        </form>
      </div>
    </div>
  </div>
    <%@include file="include/footerAdmin.jsp" %>
		