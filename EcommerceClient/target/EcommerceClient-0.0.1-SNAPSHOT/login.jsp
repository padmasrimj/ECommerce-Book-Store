<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bid</title>
<link rel="stylesheet" href="assets/demo.css">
<link rel="stylesheet" href="assets/form-labels-on-top.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

</head>
<body>
	<div class="main-content">

		<!-- You only need this form and the form-labels-on-top.css -->

		<form class="form-labels-on-top"  method="post" >
			<p id="msgd"></p>
			<div class="form-title-row">
				<h1>Log in to your My Book Store account</h1>
			</div>

			<div class="form-row">
				<label> <span>Username</span></label> <input type="text" id="username">
			</div>

			<div class="form-row">
				<label> <span>Password </span> <input id="password"
					type="password"></input>
				</label>
			</div>


			<div class="form-row">
				<button type="button" id="login">Login</button>
			</div>

		</form>

	</div>
<script src="Resources/js/loginjs.js"></script>
</body>
</html>