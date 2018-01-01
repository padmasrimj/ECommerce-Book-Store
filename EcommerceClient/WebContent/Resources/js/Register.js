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
									url : "https://localhost:8453/EcommerceBookStore/rest/registrationServices/register",
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
										if(data.validate == "true") {
										alert("Registration Successful");
										window.location = "login.jsp";
										} 
										if(data.validate == "false") {
											alert("Username already exists.Please try with a different one");
										}

									},
									error : function(xhr) {

										console.log('Error!  Status asdf= '
												+ xhr.status + " Message = "
												+ xhr.statusText);
										window.location = "404error.html";
									}

								});

					} else {
						alert("All fields are mandatory");
					}
				});

