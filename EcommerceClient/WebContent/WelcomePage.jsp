<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
	var username = localStorage.getItem("username"); 
	alert("hello" + username);
});
</script>
</head>
<body>
<div>
<p id="welcome"> Welcome <%= session.getAttribute("username") %></p>
<a href="/EcommerceClient/Profile.jsp">Edit Profile</a>
</div>
</body>
</html>