$("#login")
		.click(
				function() {
					var uname = $("#username").val();
					var pass = $("#password").val();
					if (uname == "") {
						$("#msgd").css("display", "block");
						$("#msgd").html("Enter Username");
						return;
					} else if (pass == "") {
						$("#msgd").css("display", "block");
						$("#msgd").html("Enter Password");
					} else {
						$("#msgd").html("Validating...");
						var JSONRequestParametersObject = {};
						JSONRequestParametersObject["username"] = uname;
						JSONRequestParametersObject["password"] = pass;
						$
								.ajax({
									url : "https://localhost:8453/EcommerceBookStore/rest/loginservices/test",
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
										console.log(data);
										if (data.validate == "true") {
											console.log(data);
											var username = data.username;
											localStorage.setItem("username",
													username);
											localStorage.setItem("logoutTime",data.logoutTime);
											localStorage.setItem("logoutDate",data.logoutDate);
											localStorage.setItem("logoutLocation",data.logoutLocation);
											window.location = "profile.jsp";
										} else {
											$("#msgd")
													.html(
															"Invalid Username/Password");
										}

									},

									error : function(jqXHR, exception) {
										var msg = '';
										if (jqXHR.status == 0) {
											msg = 'Not connect.\n Verify Network.';
										} else if (jqXHR.status == 404) {
											msg = 'Requested page not found. [404]';
										} else if (jqXHR.status == 500) {
											msg = 'Internal Server Error [500].';
										} else if (exception === 'parsererror') {
											msg = 'Requested JSON parse failed.';
										} else if (exception === 'timeout') {
											msg = 'Time out error.';
										} else if (exception === 'abort') {
											msg = 'Ajax request aborted.';
										} else {
											msg = 'Uncaught Error.\n'
													+ jqXHR.responseText;
										}
										console.log(msg);
										
									}

								});

					}
				});