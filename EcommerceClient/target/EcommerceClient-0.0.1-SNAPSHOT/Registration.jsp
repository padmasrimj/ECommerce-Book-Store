<head>
<style>
tr.rows td {
    padding-top: 10px;
}
.astreik {
color:red;
}
</style>
</head>
<body>
<%@ include file="/Views/template/header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <div id="login-box">

 <form name="loginForm" action="<c:url value="/loginservices" />" method="post">

				<div class="form-group">
					<p align="center"><font size="8"><b>New User Registration</b></font></p>
				</div>
				<div class="form-group">
					<p>&nbsp;</p>
				</div>
                <!-- <div class="form-group">
                    <label for="username">User: </label>
                    <input type="text" id="username" name="username" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="password">Passwrod:</label>
                    <input type="password" id="password" name="password" class="form-control" />
                </div> -->
                <table align="center" class="form-group" style="width:70%">
                <tr>
                <th>Name<span class="astreik">*</span></th>
                <td><input type="text" id="name" name="name" class="form-control" placeholder="Enter Name"/></td>
                </tr>
                <tr class="rows">
                <th>User Name<span class="astreik">*</span></th>
                <td><input type="text" id="username" name="username" class="form-control" placeholder="Enter User Name"/></td>
                </tr>
                <tr class="rows">
                <th>Email<span class="astreik">*</span></th>
                <td><input type="email" id="email" name="eamil" class="form-control" placeholder="Enter Email"/></td>
                </tr>
                <tr class="rows">
                <th>Password<span class="astreik">*</span></th>
                <td><input type="password" id="password" name="passweord" class="form-control" placeholder="Enter Password"/></td>
                </tr>
                 <tr class="rows">
                <th>Phone Number<span class="astreik">*</span></th>
                <td><input type="text" id="phoneNumber" name="phoneNumber" class="form-control" placeholder="Enter Phone Number"/></td>
                </tr>
                 <tr class="rows">
                <th>Address<span class="astreik">*</span></th>
                <td><input type="text" id="address" name="address" class="form-control" placeholder="Enter Address"/></td>
                </tr>
                <tr class="rows">
                <th>City<span class="astreik">*</span></th>
                <td><input type="text" id="city" name="city" class="form-control" placeholder="Enter City"/></td>
                </tr>
                <tr class="rows">
                <th>Zip<span class="astreik">*</span></th>
                <td><input type="text" id="zip" name="zip" class="form-control" placeholder="Enter Zip"/></td>
                </tr>
                <tr class="rows">
                <th>State<span class="astreik">*</span></th>
                <td><input type="text" id="state" name="state" class="form-control" placeholder="Enter State"/></td>
                </tr>
                <tr class="rows">
                <td>
                <p><span class="astreik">*</span>Feilds are mandatory</p>
                </td>
                </tr>
                <tr class="rows">
                <td colspan="3" align="center" >
                <input type="button" value="Register" id="register" class="btn btn-default">
                </td>
                </tr>
                </table>
                

   </form>
</div>
</div>
</div>
<%@ include file="/Views/template/footer.jsp" %>
<script src="Resources/js/Register.js"></script>
</body>