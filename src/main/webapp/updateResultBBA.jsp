
<%@include file="include/headerAdmin.jsp" %>

  <div class="container">
    <div class="card">
      <div class="card-body">
        <h2 class="card-title">Student Marks</h2>
        <form  action="${pageContext.request.contextPath}/operation/adminop/genform" method="post">
          <div class="mb-3">
            <label for="rollNumber" class="form-label">Roll Number</label>
            <input type="number" class="form-control" id="rollNumber" name="roll_no" value="${param.roll_no }"  required="required">
          </div>
          <div class="mb-3">
            <label for="managementAccounting" class="form-label">Management Accounting</label>
            <input type="number" class="form-control" id="managementAccounting" name="management_acc" value="${param.management_acc }" required="required">
          </div>
          <div class="mb-3">
            <label for="advertisingSalesPromotion" class="form-label">Advertising & Sales Promotion</label>
            <input type="number" class="form-control" id="advertisingSalesPromotion" name="ad_sales" value="${param.ad_sales }" required="required">
          </div>
          <div class="mb-3">
            <label for="industrialRelations" class="form-label">Industrial Relations</label>
            <input type="number" class="form-control" id="industrialRelations" name="ind_relations" value="${param.ind_relations }" required="required">
          </div>
          <div class="mb-3">
            <label for="publicServiceManagement" class="form-label">Public Service Management</label>
            <input type="number" class="form-control" id="publicServiceManagement" name="public_serv" value="${param.public_serv }" required="required">
          </div>
          <div class="mb-3">
            <label for="projectAndViva" class="form-label">Project and Viva</label>
            <input type="number" class="form-control" id="projectAndViva" name="project" value="${param.project}" required="required">
          </div>
          <div class="mb-3">
            <label class="form-label">Remark: Pass/Fail</label>
            <div class="form-check">
              <input class="form-check-input" type="radio" name="remark" id="pass" value="pass">
              <label class="form-check-label" for="pass">Pass</label>
            </div>
            <div class="form-check">
              <input class="form-check-input" type="radio" name="remark" id="fail" value="fail">
              <label class="form-check-label" for="fail">Fail</label>
            </div>
          </div>

			
			<input type="hidden" name="result_id" value="${param.result_id }"/>
			<input type="hidden" name="generateForm" value="updateResultBBA">
			<input type="submit" class="btn btn-warning" value="Update Result">
		
        </form>
      </div>
    </div>
  </div>

<%@include file="include/footerAdmin.jsp" %>
