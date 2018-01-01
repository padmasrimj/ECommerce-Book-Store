<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bid</title>
<link rel="stylesheet" href="assets/demo.css">
<link rel="stylesheet" href="assets/form-labels-on-top.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="assets/bidItem.js"></script>
<style>
.astreik {
color:red;
}
</style>
</head>
<body>

	<div class="main-content">
		
		<!-- You only need this form and the form-labels-on-top.css -->

		<form class="form-labels-on-top"  method="post"
			action="#">
			<p align="right">* Fields are mandatory</p>
			<br/>
			<div class="form-title-row">
				<h1>Register</h1>
			</div>

			<div class="form-row">
				<label>Name*</label> <input id="name" name="name" type="text" placeholder="Enter Name">
			</div>

			<div class="form-row">
				<label>User Name*</label> <input type="text" id="username" name="username" placeholder="Enter User Name">
			</div>

			<div class="form-row">
				<label> Email*</label> <input type="email" id="title" placeholder="Enter Email">
			</div>

			<div class="form-row">
				<label> Password*</label> <input type="password" placeholder="Enter Password"
					id="password">
			</div>
			<div class="form-row">
				<label> Phone Number*</label> <input type="number" placeholder="Enter Phone Number"
					id="phoneNumber">
			</div>
			<div class="form-row">
				<label> Address*</label> <input type="text" id="address" placeholder="Enter Address">
			</div>

			<div class="form-row">
				<label> City*</label> <input type="text" id="city" placeholder="Enter City">
			</div>
			<div class="form-row">
				<label> Zip*</label> <input type="number" id="zip" placeholder="Enter Zip">
			</div>
			<div class="form-row">
				<label> State*</label> <input type="text" id="state" placeholder="Enter State">
			</div>
			<div class="form-row">
				<button type="button" id="register">Register</button>
			</div>

		</form>

	</div>

<script src="Resources/js/Register.js"></script>
</body>
</html>