

<%@include file="include/headerAdmin.jsp" %>



<div class="container">
    <div class="card">
      <div class="card-body">
        <h2 class="card-title">Student Marks</h2>
        <form action="${pageContext.request.contextPath}/operation/adminop/genform" method="post">
          <div class="mb-3">
            <label for="rollNumber" class="form-label">Roll Number</label>
            <input type="number" class="form-control" id="rollNumber" name="roll_no" value="${param.roll_no }" required="required">
          </div>
          <div class="mb-3">
            <label for="internetTech" class="form-label">Internet Technology</label>
            <input type="number" class="form-control" id="internetTech" name="it" value="${param.it }" required="required">
          </div>
          <div class="mb-3">
            <label for="computerNetwork" class="form-label">Computer Network</label>
            <input type="number" class="form-control" id="computerNetwork" name="network"  value="${param.network }"  required="required">
          </div>
          <div class="mb-3">
            <label for="elective" class="form-label">Elective</label>
            <input type="number" class="form-control" id="elective" name="elective" value="${param.elective }" required="required">
          </div>
          <div class="mb-3">
            <label for="internetTechLab" class="form-label">Internet Technology Lab</label>
            <input type="number" class="form-control" id="internetTechLab" name="it_lab" value="${param.it_lab }" required="required">
          </div>
          <div class="mb-3">
            <label for="computerNetworkLab" class="form-label">Computer Network Lab</label>
            <input type="number" class="form-control" id="computerNetworkLab" name="network_lab"  value="${param.network_lab }" required="required">
          </div>
          <div class="mb-3">
            <label for="industrialTraining" class="form-label">Industrial Training & Minor Project</label>
            <input type="number" class="form-control" id="industrialTraining" name="minor_project" value="${param.minor_project }" required="required">
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
				<input type="hidden" name="generateForm" value="updateResultBCA">
				<input type="submit" class="btn btn-warning" value="Update Result">
        </form>
      </div>
    </div>
  </div>

 
<%@include file="include/footerAdmin.jsp" %>