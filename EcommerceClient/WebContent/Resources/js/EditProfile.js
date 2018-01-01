$(window)
		.bind(
				"load",
				function() {
					var jsonobject = {};
					jsonobject["username"] = localStorage.getItem("username");
					$
							.ajax({
								type : "POST",
								url : "https://localhost:8453/EcommerceBookStore/rest/editServices/retreive",
								data : JSON.stringify(jsonobject),
								async : false,
								dataType : "json",
								contentType : "application/json",
								cache : false,
								headers : {
									Accept : 'application/json'
								},
								success : function(data) {
									console.log(data);
									console.log(data[0]);
									$("#fname").val(data[0].name);
									$("#email").val(data[0].email);
									$("#phone_number").val(data[0].phoneNumber);
									$("#city").val(data[0].city);
									$("#address").val(data[0].address);
									$("#state").val(data[0].state);
									$("#zip").val(data[0].zip);
									$("#fname1").val(data[0].name);
									$("#email1").val(data[0].email);
									$("#phone_number1")
											.val(data[0].phoneNumber);
									$("#city1").val(data[0].city);
									$("#address1").val(data[0].address);
									$("#state1").val(data[0].state);
									$("#zip1").val(data[0].zip);
									$("#profilename").text(data[0].name);
									$("#username").text(localStorage.getItem("username"));
									var logoutTime = localStorage.getItem("logoutTime");
									var logoutDate = localStorage.getItem("logoutDate");
									var logoutLocation = localStorage.getItem("logoutLocation");
									if(logoutTime == null || logoutTime == "undefined" || logoutDate == null || logoutDate == "undefined" || logoutLocation == null || logoutLocation == "undefined") {
										$("#logoutTime").text("Welcome new user");
										
									} else {
										$("#logoutTime").text("Your last login was at "+logoutTime+" on "+logoutDate+" from "+logoutLocation);
									}
								}
							});
				});
$("#sbmt")
		.click(
				function() {
					var name = $("#fname1").val();
					var email = $("#email1").val();
					var address = $("#address1").val();
					var city = $("#city1").val();
					var zip = $("#zip1").val();
					var state = $("#state1").val();
					var phoneNumber = $("#phone_number1").val();
					var JSONRequestParametersObject = {};
					JSONRequestParametersObject["name"] = name;
					JSONRequestParametersObject["address"] = address;
					JSONRequestParametersObject["city"] = city;
					JSONRequestParametersObject["zip"] = zip;
					JSONRequestParametersObject["state"] = state;
					JSONRequestParametersObject["email"] = email;
					JSONRequestParametersObject["phoneNumber"] = phoneNumber;
					JSONRequestParametersObject["username"] = localStorage
							.getItem("username");
					$
							.ajax({
								url : "https://localhost:8453/EcommerceBookStore/rest/editServices/edit",
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
									alert("Editing Successful");

								},
								error : function(xhr) {

									console.log('Error!  Status asdf= '
											+ xhr.status + " Message = "
											+ xhr.statusText);
									window.location = "404error.html";
								}

							});

				});
