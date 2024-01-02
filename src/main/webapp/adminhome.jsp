<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="include/headerAdmin.jsp" %>
  



    



<div class="container">
    <h1>Admin Home Page</h1>
    <div class="row">
      <div class="col-md-6 col-lg-4 mt-3">
        <div class="card" style="width: 18rem;">
         <img src="https://www.nasdaq.com/sites/acquia.prod/files/styles/720x400/public/2022/11/21/education.jpg?h=b1a91ebe&itok=cZ_Lt_PP" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title" data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">Add Student</h5>
            <div class="collapse" id="collapseExample">
  				<div class="card card-body">
    				Some placeholder content for the collapse component. This panel is hidden by default but revealed when the user activates the relevant trigger.
	  			</div>
  			</div>	
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/operation/adminop?page=insertStudent">Add Student</a>
          </div>
        </div>
      </div>
      
            <div class="col-md-6 col-lg-4 mt-3">
        <div class="card" style="width: 18rem;">
         <img src="https://images.shiksha.com/mediadata/images/articles/1683883807phpuGiV83.jpeg" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title" data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">Add Student Result</h5>
            <div class="collapse" id="collapseExample">
  				<div class="card card-body">
    				Some placeholder content for the collapse component. This panel is hidden by default but revealed when the user activates the relevant trigger.
	  			</div>
  			</div>	
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/operation/adminop?page=insertResult" >Add Student Result</a>
          </div>
        </div>
      </div>
      
            <div class="col-md-6 col-lg-4 mt-3">
        <div class="card" style="width: 18rem;">
         <img src="https://img.freepik.com/free-vector/college-university-students-group-young-happy-people-standing-isolated-white-background_575670-66.jpg?size=626&ext=jpg&ga=GA1.1.867424154.1698019200&semt=ais" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title" data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">View Registered Student</h5>
            <div class="collapse" id="collapseExample">
  				<div class="card card-body">
    				Some placeholder content for the collapse component. This panel is hidden by default but revealed when the user activates the relevant trigger.
	  			</div>
  			</div>	
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/operation/adminop?page=registeredStudents">View Registered Student</a>
          </div>
        </div>
      </div>
      

      
            <div class="col-md-6 col-lg-4 mt-3">
        <div class="card" style="width: 18rem;">
         <img src="https://www.voxco.com/wp-content/uploads/2021/05/Survey-results-into-presentations-cvr.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title" data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">Show All Student Result</h5>
            <div class="collapse" id="collapseExample">
  				<div class="card card-body">
    				Some placeholder content for the collapse component. This panel is hidden by default but revealed when the user activates the relevant trigger.
	  			</div>
  			</div>	
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/operation/adminop?page=studentResults">Show All Student Result</a>
          </div>
        </div>
      </div>
      
    </div>
</div>
    <%@include file="include/footerAdmin.jsp" %>
