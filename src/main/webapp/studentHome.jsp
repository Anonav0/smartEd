<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="include/headerStud.jsp" %>
  



    



<div class="container">
    <h1>Student Home Page</h1>
    <div class="row">
      <div class="col-md-6 col-lg-4 mt-3">
        <div class="card" style="width: 18rem;">
         <img src="" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title" data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">View profile</h5>
            <div class="collapse" id="collapseExample">
  				<div class="card card-body">
    				Some placeholder content for the collapse component. This panel is hidden by default but revealed when the user activates the relevant trigger.
	  			</div>
  			</div>	
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/operation/studentop?page=viewProfile">View profile</a>
          </div>
        </div>
      </div>
      
            <div class="col-md-6 col-lg-4 mt-3">
        <div class="card" style="width: 18rem;">
         <img src="https://images.shiksha.com/mediadata/images/articles/1683883807phpuGiV83.jpeg" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title" data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">View Result</h5>
            <div class="collapse" id="collapseExample">
  				<div class="card card-body">
    				Some placeholder content for the collapse component. This panel is hidden by default but revealed when the user activates the relevant trigger.
	  			</div>
  			</div>	
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/operation/studentop?page=viewResult" >View Result</a>
          </div>
        </div>
      </div>
      
            
      

      
     
      
    </div>
</div>
    <%@include file="include/footerStud.jsp" %>
