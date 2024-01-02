<%@include file="include/headerAdmin.jsp" %>



 <div class="container">
    <div class="card">
      <div class="card-body">
        <h2 class="card-title">Student Marks</h2>
        <form action="${pageContext.request.contextPath}/operation/adminop/genform" method="post">
          <div class="mb-3">
            <label for="rollNumber" class="form-label">Roll Number</label>
            <input type="number" class="form-control" id="rollNumber" name="roll_no" required="required">
          </div>
          <div class="mb-3">
            <label for="epidemiologicalTransitions" class="form-label">Epidemiological Transitions in Healthcare</label>
            <input type="number" class="form-control" id="epidemiologicalTransitions" name="epi_health" required="required">
          </div>
          <div class="mb-3">
            <label for="supportUtilityServices" class="form-label">Support and Utility Services-II</label>
            <input type="number" class="form-control" id="supportUtilityServices" name="support_ut" required="required">
          </div>
          <div class="mb-3">
            <label for="financialManagement" class="form-label">Financial Management and Risk Analysis</label>
            <input type="number" class="form-control" id="financialManagement" name="fm_ra" required="required">
          </div>
          <div class="mb-3">
            <label for="minorProject" class="form-label">Minor Project/Internship</label>
            <input type="number" class="form-control" id="minorProject" name="project" required="required">
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
          
			<input type="hidden" name="generateForm" value="addResultBHM">
			<input type="submit"class="btn btn-primary" value="Add Result">
        </form>
      </div>
    </div>
  </div>

<%@include file="include/footerAdmin.jsp" %>
