
<%@ include file="/Views/template/header.jsp" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Resources/css/main.css">
<link rel="stylesheet" href="Resources/css/bootstrap.css">

	
</head>
<body id="mainpage">
<div id="wrapper">
<section id="header">
<div class="container">
<div id="heading">

<h4 class="highlight">Order Page</h4>

<h2>Book Reservation</h2>

</div>

<div id="loginheader">
<%
						if (session.getAttribute("user") == null) {
					%>

					<div class="dropdown">
						<a id="dLabel" role="button" data-toggle="dropdown"
							data-target="#" href="#"> Welcome <%=session.getAttribute("username")%>
							<span class="caret"></span>
						</a>


						<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
							<a href="ViewProfile.jsp">View Profile</a>
							<a href="UpdateProfile.jsp">Update Profile</a>
							<a href="Logout.jsp">Logout</a>
						</ul>
					</div>
 
					<%
						} else {
							response.sendRedirect("login.jsp");
						}
					%> 

</div>
</div>
</section> <section id="two">
<div class="container">
<div id="rightbox">

<form action="/EcommerceBookStore/rest/email/send" method="get" name="myform" id="formdiv">
<h3 align="center">Card details</h3>
<table class="table table-hover">
	<tr>
		<td>Card type</td>
		<td class="text-col-centered"><input type="radio" name=cardtype value=credit>Credit card
		<input type="radio" name=cardtype value=debit>Debit card 
		</td>
	</tr>
	<tr >
		<td class="col-sm-1 col-md-1 text-center">Card Details</td>
		<td><input type="text" name="card" maxlength="16"></td>
	</tr>
	<tr>
		<td class="col-sm-1 col-md-1 text-center">CVV Number</td>
		<td><input type="text" name="cvv" ></td>
	</tr>
	<tr>
		<td class="col-sm-1 col-md-1 text-center">Expiration Date</td>
		<td><input type="date" name="date"></td>
	</tr>
	<tr>
		<td class="col-sm-1 col-md-1 text-center">Name on Card</td>
		<td><input type="text" name="cname"></td>
	</tr>
	<tr>
<%--		<td class="col-sm-1 col-md-1 text-center"><td><input type="submit" value="Pay" class="submit" onclick="/thankCustomer.jsp">
  	<td class="col-sm-1 col-md-1 text-center"><td><a href="<c:url value="/thankCustomer.jsp" />" class="btn btn-default">Pay</a>
 --%>	
 	<td class="col-sm-1 col-md-1 text-center"></td><td><input type="button" value="Pay" id="pay" class="btn btn-default"></td>
 	</tr>
</table>
</form>
</div>
</div>
</section></div>
</body>
<%@ include file="/Views/template/footer.jsp" %>
<script src="Resources/js/Pay.js"></script>

</html>