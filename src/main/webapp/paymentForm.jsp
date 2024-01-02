<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@include file="include/headerStud.jsp" %>

<div class="container">
  <div class="card bg-body-tertiary rounded-3">
    <div class="card-body">
      <h2 class="card-title">Student Form</h2>
      <form
        action="${pageContext.request.contextPath}/payment"
        method="post"
      >
        <div class="mb-3 disabled">
          <label for="institute" class="form-label">Institute</label>
          <input
            type="text"
            class="form-control"
            id="institute"
            name="institute"
            value="${param.institute}"
			readonly            
          />
        </div>
        <div class="mb-3">
          <label for="course" class="form-label">Course</label>
          <input
            type="text"
            class="form-control"
            id="course"
            name="course"
            value="${param.course}"
            required="required"
            readonly
          />
        </div>
        <div class="mb-3">
          <label for="Roll_no" class="form-label">Roll Number</label>
          <input
            type="text"
            class="form-control"
            id="roll_no"
            name="roll_no"
            value="${param.roll_no}"
            required="required"
            readonly
          />
                          <div class="mb-3">
          <label for="utr" class="form-label">Semester</label>
          <input
            type="number"
            class="form-control"
            id="sem"
            name="sem"
            
          />
        </div>
        </div>
        <div class="mb-3">
          <label for="name" class="form-label">Name</label>
          <input
            type="text"
            class="form-control"
            id="name"
            name="name"
            value="${param.name }"
            readonly
          />
        </div>
                <div class="mb-3">
          <label for="name" class="form-label">Email</label>
          <input
            type="text"
            class="form-control"
            id="email"
            name="email"
            value="${param.email }"
            readonly
          />
        </div>
        <div class="container">
          <div class="row">
            <div class="col">
              <h2>Stationery</h2>
              <table class="table">
                <thead>
                  <tr>
                    <th scope="col">Item</th>
                    <th scope="col">Price</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>Books</td>
                    <td>$4000 <input type="hidden" name="books" value="4000" /></td>
                  </tr>
                  <tr>
                    <td>Copies</td>
                    <td>$6000 <input type="hidden" name="copies" value="6000" /></td>
                    
                  </tr>
                </tbody>
              </table>
            </div>
          </div>

          <div class="row mt-5">
            <div class="col">
              <h2>Fees</h2>
              <table class="table">
                <thead>
                  <tr>
                    <th scope="col">Description</th>
                    <th scope="col">Amount</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>Semester Fee</td>
                    <td>$56000 <input type="hidden" name="sem_fee" value="56000" /></td>
                    
                  </tr>
                  <tr>
                    <td>Computer Fee</td>
                    <td>$6000 <input type="hidden" name="com_fee" value="6000" /></td>
                    
                  </tr>
                  <tr>
                    <td>Miscellaneous</td>
                    <td>$2000 <input type="hidden" name="misc" value="2000" /></td>
                    
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
        
                <div class="mb-3">
          <label for="utr" class="form-label">UTR NUMBER (UPI)</label>
          <input
            type="number"
            class="form-control"
            id="utr"
            name="utr"
            
          />
        </div>
		<input type="hidden" name="total" value="74000" />
        <input type="hidden" name="operation" value="addPaymentOperation" />
        <input class="btn btn-success" type="submit" value="Make Payment" />
      </form>
    </div>
  </div>
</div>
<%@include file="include/footerStud.jsp" %>
