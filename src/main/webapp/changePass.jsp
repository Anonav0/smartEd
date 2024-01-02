<%@include file="include/headerAdmin.jsp" %>




<div class="container">

  <div class="card mb-3">
    <div class="card-header">
      <h1>Form View</h1>
    </div>
    <div class="card-body">

      <form id="form" action="${pageContext.request.contextPath}/operation/adminop" method="post">



        <div class="mb-3">
          <label for="new-password" class="form-label">New Password</label>
          <input type="password" class="form-control" id="new-password" name="password" placeholder="Enter your new password">
        </div>

        <div class="mb-3">
          <label for="confirmPass" class="form-label">Confirm Password</label>
          <input type="password" class="form-control" id="confirmPass" name="confirmPass" placeholder="Enter your new password">
        </div>


        <input type="hidden" name="form" value="updateAndChangeAdminPass"/>
         <input type="submit" class="btn btn-danger" value="change password"/>

      </form>

    </div>
  </div>

</div>




<%@include file="include/footerAdmin.jsp" %>