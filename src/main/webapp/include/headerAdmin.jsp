<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="h-100" data-bs-theme="light">
<head>

    <title><%
    if( request.getAttribute("title") == null){
        out.print("Homepage");
    }else{
    	out.print(request.getAttribute("title"));
    }
    %></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
</head>
<body class="d-flex flex-column h-100">
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Welcome <%= request.getSession().getAttribute("username") %></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/operation/adminop?page=viewProfile"> view Profile</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/operation/adminop?page=insertStudent">Add Student</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/operation/adminop?page=insertResult">Add Student Result</a>
		</li>
		<li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/operation/adminop?page=registeredStudents">Show  Students</a>
		</li>
		<li class="nav-item">
          <a class="nav-link"  href="${pageContext.request.contextPath}/operation/adminop?page=studentResults">show Student results</a>
		</li>
		<li class="nav-item">
          <a class="nav-link"  href="${pageContext.request.contextPath}/payment?page=viewPaymentHistory">Payment Transc.</a>
		</li>
		<li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/operation?page=logoutAdmin">Logout</a>
		</li>
		<li class="nav-item">
          <button id="darkModeToggle" class="btn btn-outline-info" >☀️~~🌘</button>
          
          
		</li>
      </ul>
      


    </div>

  </div>
</nav>

<%
String alertType = (String) request.getAttribute("alertType");
String alertMsg = (String) request.getAttribute("alertMsg");

if(alertType != null && alertType == ("success")) {
	out.print("<div class=\"conatiner\" >");
	out.print("<div class=\"alert alert-success alert-dismissible\" role=\"alert\" >");
	out.print(alertMsg);
	out.print("<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aira-label=\"Close\" ></button>");
	out.print("</div>");
	out.print("</div>");
}
else if (alertType != null && alertType == ("primary")) {
	out.print("<div class=\"conatiner\" >");
	out.print("<div class=\"alert alert-primary alert-dismissible\" role=\"alert\" >");
	out.print(alertMsg);
	out.print("<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aira-label=\"Close\" ></button>");
	out.print("</div>");
	out.print("</div>");
}

else if (alertType != null && alertType == ("fail")) {
	out.print("<div class=\"conatiner\" >");
	out.print("<div class=\"alert alert-danger alert-dismissible\" role=\"alert\" >");
	out.print(alertMsg);
	out.print("<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aira-label=\"Close\" ></button>");
	out.print("</div>");
	out.print("</div>");
}


%>







