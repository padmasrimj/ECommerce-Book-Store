<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Posts</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/post.css">
<link rel="stylesheet" href="assets/table.css">

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="assets/viewmyposts.js"></script>
</head>
<body style="background-color: #f0f0f5s">
	<div class="jumbotron text-center">
		<form action="post.jsp">
			<button type="submit" class="btn btn-primary">Add Post</button>
		</form>
	</div>
	<table class="table-fill" id="postDetails">
		<thead>
			<tr>
				<th class="text-left">Name</th>
				<th class="text-left">Author</th>
				<th class="text-left">Edition</th>
				<th class="text-left">Category</th>
				<th class="text-left">Comments</th>
				<th class="text-left"></th>
				<th class="text-left"></th>
			</tr>
		</thead>
		<tbody class="table-hover">


		</tbody>
	</table>
	
</body>
</html>

