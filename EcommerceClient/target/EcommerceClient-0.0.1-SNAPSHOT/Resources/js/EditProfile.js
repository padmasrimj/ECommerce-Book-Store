$(window)
		.bind(
				"load",
				function() {
					alert("loading");
					var jsonobject = {};
					jsonobject["username"] = localStorage.getItem("username");
					$
							.ajax({
								type : "POST",
								url : "http://127.0.0.1:8080/EcommerceBookStore/rest/editServices/retreive",
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
									alert("data[0]" + data[0]);
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
					var phoneNumber = $("#phone_Number1").val();
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
								url : "http://localhost:8080/EcommerceBookStore/rest/editServices/edit",
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
									alert('Error!  Status asdf= ' + xhr.status
											+ " Message = " + xhr.statusText);
									alert("hello");
								}

							});

				});
