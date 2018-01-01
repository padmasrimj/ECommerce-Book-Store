<!DOCTYPE html>
<html lang="en">
<head>
<title>My Store</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="Resources/css/profile_style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-formhelpers/2.3.0/js/bootstrap-formhelpers.js"></script>
	<script>
	
edit = function(){
	$("#fname").hide();
	$("#email").hide();
	$("#phone_number").hide();
	$("#city").hide();
	$("#address").hide();
	$("#state").hide();
	$("#zip").hide();
	$("#edit1").hide();
	$("#fname1").show();
	$("#email1").show();
	$("#phone_number1").show();
	$("#city1").show();
	$("#address1").show();
	$("#state1").show();
	$("#zip1").show();
	$("#sbt1").show();
}
</script>
<script src="Resources/js/profile.js"></script>
</head>
<body>
<%@ include file="/Views/template/header.jsp" %>
	<div class="container">
		<div class="row profile">
			<div class="col-md-3">
				<div class="profile-sidebar">
					<!-- SIDEBAR USERPIC -->
					<div class="profile-userpic">
						<img
							src="images/profile-user.jpg"
							class="img-responsive" alt="">
					</div>
					<!-- END SIDEBAR USERPIC -->
					<!-- SIDEBAR USER TITLE -->
					<div class="profile-usertitle">
						<div class="profile-usertitle-name">Marcus Doe</div>
						<div class="profile-usertitle-job">Developer</div>
					</div>
					<!-- END SIDEBAR USER TITLE -->
					<!-- SIDEBAR BUTTONS -->
					<div class="profile-userbuttons">
						<button type="button" id="post" class="btn btn-success btn-sm">Post</button>
					</div>
					<!-- END SIDEBAR BUTTONS -->
					<!-- SIDEBAR MENU -->
					<div class="profile-usermenu">
						<ul class="nav">
							<li class="active"><a href="#"> <i
									class="glyphicon glyphicon-home"></i> Overview
							</a></li>
							<li><a href="#"> <i class="glyphicon glyphicon-user"></i>
									Account Settings
							</a></li>
							<li><a href="#" target="_blank"> <i
									class="glyphicon glyphicon-ok"></i> Tasks
							</a></li>
							<li><a href="#"> <i class="glyphicon glyphicon-flag"></i>
									Help
							</a></li>
						</ul>
					</div>
					<!-- END MENU -->
				</div>
			</div>
			<br>
			<br>
		<div class="col-md-7">
				<div class="profile-content">
					<form class="form-horizontal">
						<div class="form-group" class="ronly">
							<label class="control-label col-sm-2" for="fname">First
								Name:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control non-editable" id="fname"
									placeholder="Enter first name" readonly>
								<input type="text" class="form-control non-editable" id="fname1"
									placeholder="Enter first name" style="display:none">
							</div>
						</div>
					
						<div class="form-group" class="ronly">
							<label class="control-label col-sm-2" for="email">Email </label>
							<div class="col-sm-10">
								<input type="email" class="form-control non-editable" id="email"
									placeholder="Enter Last name" readonly>
								<input type="email" class="form-control non-editable" id="email1"
									placeholder="Enter Last name" style="display:none">
							</div>
						</div>

						<div class="form-group" class="ronly">
							<label class="control-label col-sm-2" for="email">Phone
								Number: </label>
							<div class="col-sm-10">
								<input type="text" class="form-control input-medium bfh-phone non-editable"
									data-country="US" id="phone_number"
									placeholder="Enter phone number"
									data-format="+1 (ddd) ddd-dddd" readonly>
								<input type="text" class="form-control input-medium bfh-phone non-editable"
									data-country="US" id="phone_number1"
									placeholder="Enter phone number"
									data-format="+1 (ddd) ddd-dddd"  style="display:none">

							</div>
						</div>

						<div class="form-group" class="ronly">
							<label class="control-label col-sm-2" for="email">State: </label>
							<div class="col-sm-10">
								<input type="text" class="form-control input-medium bfh-phone non-editable"
								    id="state"
									placeholder="Enter State" readonly>
								<input type="text" class="form-control non-editable"
								    id="state1"
									placeholder="Enter State" style="display:none">
							</div>
						</div>

						<div class="form-group" class="ronly">
							<label class="control-label col-sm-2" for="email">City: </label>
							<div class="col-sm-10">
								<input type="text" class="form-control input-medium bfh-phone non-editable"
								    id="city"
									placeholder="Enter City" readonly>
								<input type="text" class="form-control non-editable"
								    id="city1"
									placeholder="Enter City" style="display:none">
							</div>
						</div>

						<div class="form-group" class="ronly">
							<label class="control-label col-sm-2" for="email">Zip: </label>
							<div class="col-sm-10">
								<input type="text" class="form-control input-medium bfh-phone non-editable"
								    id="zip"
									placeholder="Enter Zip" readonly>
								<input type="text" class="form-control non-editable"
								    id="zip1"
									placeholder="Enter Zip" style="display:none">
							</div>
						</div>
						
						<div class="form-group" class="ronly">
							<label class="control-label col-sm-2" for="email">Address: </label>
							<div class="col-sm-10">
								<input type="text" class="form-control input-medium bfh-phone non-editable"
								    id="address"
									placeholder="Enter Address" readonly>
								<input type="text" class="form-control non-editable"
								    id="address1"
									placeholder="Enter Address" style="display:none">
							</div>
						</div>
			
						<div class="form-group" id="sbt1" style="display:none">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="button" id="sbmt" class="btn btn-default" value="Submit">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="button" id="edit1" value="Edit" class="btn btn-default" onclick="edit();">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
<%@ include file="/Views/template/footer.jsp" %>
<script src="Resources/js/EditProfile.js"></script>
</body>
</html>