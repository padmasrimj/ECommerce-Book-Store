<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Posts</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/bid.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="assets/bid.js"></script>
<script src="assets/viewbids.js"></script>
</head>
<body style="background-color: #f0f0f5s">
	<div class="container">
		<div class="well well-sm">
			<strong>Display</strong>
			<div class="btn-group">
				<a href="#" id="list" class="btn btn-default btn-sm"><span
					class="glyphicon glyphicon-th-list"> </span>List</a> <a href="#"
					id="grid" class="btn btn-default btn-sm"><span
					class="glyphicon glyphicon-th"></span>Grid</a>
			</div>
		</div>
		<div id="products" class="row list-group"></div>

	</div>
</body>
</html>

