<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title><%
    if( request.getAttribute("title") == null){
        out.print("Homepage");
    }else{
    	out.print(request.getAttribute("title"));
    }
    %></title>
</head>
<body>

</body>
</html>