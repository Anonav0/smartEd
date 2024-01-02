<%@include file="include/headerAdmin.jsp" %>




<div class="container">
<h1>Choose the Result Form </h1>
<hr>
<div class="row">
      <div class="col-md-6 col-lg-4 mt-3">
        <div class="card" style="width: 18rem;">
         <img src="https://durhamcollege.ca/wp-content/uploads/Computer-Programmer.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title" data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">Bachelor's of Computer Application</h5>
            <div class="collapse" id="collapseExample">
  				<div class="card card-body">
    				Some placeholder content for the collapse component. This panel is hidden by default but revealed when the user activates the relevant trigger.
	  			</div>
  			</div>	
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/operation/adminop/genform?page=bcaResultForm">Generate BCA Form</a>
          </div>
        </div>
      </div>
      
        <div class="col-md-6 col-lg-4 mt-3">
        <div class="card" style="width: 18rem;">
         <img src="https://www.patriotsoftware.com/wp-content/uploads/2019/05/9-business-formulas-math-haters-cant-ignore.jpg" class="card-img-top " alt="...">
          <div class="card-body">
            <h5 class="card-title" data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">Bachelor's of Business Administration</h5>
            <div class="collapse" id="collapseExample">
  				<div class="card card-body">
    				Some placeholder content for the collapse component. This panel is hidden by default but revealed when the user activates the relevant trigger.
	  			</div>
  			</div>	
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/operation/adminop/genform?page=bbaResultForm" >Generate BBA Form</a>
          </div>
        </div>
      </div>
      
        <div class="col-md-6 col-lg-4 mt-3">
        <div class="card" style="width: 18rem;">
         <img src="https://blog.kindgeek.com/wp-content/uploads/2019/12/OBUZORLdEFO3HofPcHMa-1024x654.jpeg" class="card-img-top " alt="...">
          <div class="card-body">
            <h5 class="card-title" data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">Bachelor's of Hospital Management</h5>
            <div class="collapse" id="collapseExample">
  				<div class="card card-body">
    				Some placeholder content for the collapse component. This panel is hidden by default but revealed when the user activates the relevant trigger.
	  			</div>
  			</div>	
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/operation/adminop/genform?page=bhmResultForm">Generate BHM Form</a>
          </div>
        </div>
      </div>

      </div>
      
    </div>




<%@include file="include/footerAdmin.jsp" %>
