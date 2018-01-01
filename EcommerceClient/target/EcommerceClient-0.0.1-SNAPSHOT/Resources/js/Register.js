$("#register")
		.click(
				function() {
					var username = $("#username").val();
					var name = $("#name").val();
					var email = $("#email").val();
					var password = $("#password").val();
					var address = $("#address").val();
					var city = $("#city").val();
					var zip = $("#zip").val();
					var state = $("#state").val();
					var phoneNumber = $("#phoneNumber").val();
					if (username != "" && name != "" && email != ""
							&& password != "" && address != "" && city != ""
							&& zip != "" && state != "" && phoneNumber != "") {
						var JSONRequestParametersObject = {};
						JSONRequestParametersObject["username"] = username;
						JSONRequestParametersObject["name"] = name;
						JSONRequestParametersObject["address"] = address;
						JSONRequestParametersObject["city"] = city;
						JSONRequestParametersObject["zip"] = zip;
						JSONRequestParametersObject["state"] = state;
						JSONRequestParametersObject["email"] = email;
						JSONRequestParametersObject["phoneNumber"] = phoneNumber;
						JSONRequestParametersObject["password"] = password;
						$
								.ajax({
									url : "http://localhost:8080/EcommerceBookStore/rest/registrationServices/register",
									type : "POST",
									async : true,
									data : JSON
											.stringify(JSONRequestParametersObject),
									contentType : "application/json; charset=utf-8",
									dataType : "json",
									cache : false,
									headers : {
										Accept : 'application/json'
									},
									success : function(data) {
										alert("Registration Successful");
										window.location = "login.jsp";

									},
									error : function(xhr) {

										console.log('Error!  Status asdf= '
												+ xhr.status + " Message = "
												+ xhr.statusText);
										alert('Error!  Status asdf= '
												+ xhr.status + " Message = "
												+ xhr.statusText);
										alert("hello");
									}

								});

					} else {
						alert("All fields are mandatory");
					}
				});

