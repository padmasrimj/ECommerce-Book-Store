
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


</div>
</section> <section id="two">
<div class="container">
<div id="rightbox">

<form action="http://localhost:8080/EcommerceBookStore/rest/email/send" method="get" name="myform" id="formdiv">
<h3 align="center">Card details</h3>
<table class="table table-hover">
	<tr>
		<td>Card type</td>
		<td class="text-col-centered"><input type="radio" name=cardtype value=credit>Credit card
		<input type="radio" name=cardtype id="cardtype" value=debit required>Debit card 
		</td>
	</tr>
	<tr >
		<td class="col-sm-1 col-md-1 text-center">Card Details</td>
		<td><input type="text" name="card" id="card" maxlength="16" required></td>
	</tr>
	<tr>
		<td class="col-sm-1 col-md-1 text-center">CVV Number</td>
		<td><input type="text" name="cvv" id ="cvv" required ></td>
	</tr>
	<tr>
		<td class="col-sm-1 col-md-1 text-center">Expiration Date</td>
		<td><input type="date" name="date" id="date" required></td>
	</tr>
	<tr>
		<td class="col-sm-1 col-md-1 text-center">Name on Card</td>
		<td><input type="text" name="cname" id="cname" required></td>
	</tr>
	<tr>
<%--		<td class="col-sm-1 col-md-1 text-center"><td><input type="submit" value="Pay" class="submit" onclick="/thankCustomer.jsp">
  	<td class="col-sm-1 col-md-1 text-center"><td><a href="<c:url value="/thankCustomer.jsp" />" class="btn btn-default">Pay</a>
 --%>	
 	<td class="col-sm-1 col-md-1 text-center"></td><td><input type="button" value="Pay" id="pay"></td>
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