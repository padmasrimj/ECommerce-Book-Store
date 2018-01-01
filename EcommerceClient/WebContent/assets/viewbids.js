$(document)
		.ready(
				function() {

					var JSONRequestParametersObject = {};
					JSONRequestParametersObject["postid"] = localStorage
							.getItem("postid");

					$
							.ajax({

								type : 'POST',
								url : 'https://localhost:8453/EcommerceBookStore/rest/postServices/viewbids',
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

									if (data.errorMessage != null) {
//										alert(data.errorMessage);
									} else {
										var addToCart = localStorage
												.getItem("addToCart");
										if (addToCart == "true") {
											for (var i = 0; i < data.length; i++) {

												var newRowContent = "<div class='item  col-xs-4 col-lg-4'><div class='thumbnail'><div class='caption'><h4 class='group inner list-group-item-heading'>"
														+ data[i].title
														+ "</h4><p class='group inner list-group-item-text'>"
														+ data[i].comments
														+ "</p><div class='row'><div class='col-xs-12 col-md-6'><p class='lead'>$"
														+ data[i].price
														+ "</p></div><div class='col-xs-12 col-md-6'><a class='btn btn-success addtocart' id='"
														+ data[i].bidid
														+ "' href='#'>Add to cart</a></div></div></div></div></div>";

												$("#products").append(
														newRowContent);
											}

										} else {
											for (var i = 0; i < data.length; i++) {

												var newRowContent = "<div class='item  col-xs-4 col-lg-4'><div class='thumbnail'><div class='caption'><h4 class='group inner list-group-item-heading'>"
														+ data[i].title
														+ "</h4><p class='group inner list-group-item-text'>"
														+ data[i].comments
														+ "</p><div class='row'><div class='col-xs-12 col-md-6'><p class='lead'>$"
														+ data[i].price
														+ "</p></div><div class='col-xs-12 col-md-6'></div></div></div></div></div>";

												$("#products").append(
														newRowContent);
											}

										}
										console.log(data);
									}

								},
								error : function(xhr) {

									console.log('Error!  Status asdf= '
											+ xhr.status + " Message = "
											+ xhr.statusText);
									window.location = "404error.html";

								}
							});
					$("#backtoPosts").click(function() {
						var addToCart = localStorage.getItem("addToCart");
						if (addToCart == "true") {
							window.location = "viewMyPosts.jsp";
						} else {
							window.location = "viewAllPosts.jsp";
						}
					});

					$("#products")
							.on(
									'click',
									'.addtocart',
									function() {
										console.log("cart");
										var bidId = this.id;
										var userName = localStorage
												.getItem("username");
										// var JSONRequestParametersObject = {};
										// JSONRequestParametersObject["userName"]
										// = localStorage
										// .getItem("username");
										// console.log(JSONRequestParametersObject);

										var cartId;
										$
												.ajax({
													type : 'GET',
													url : 'https://localhost:8453/EcommerceBookStore/rest/customer/getcartId/'
															+ userName,
													cache : true,
													headers : {
														Accept : 'text/plain'
													},
													success : function(data) {
														console.log("******"
																+ data[0]);
														console.log(data);
														if (!data.error)
															location
																	.reload(true);
														cartId = data[0];
														console
																.log("cart id : "
																		+ cartId);
														$
																.ajax({
																	type : 'PUT',
																	url : 'https://localhost:8453/EcommerceBookStore/rest/cart/add/'
																			+ cartId
																			+ '/'
																			+ bidId,
																	dataType : "text/plain",
																	cache : false,
																	success : function(
																			data) {
																		console
																				.log("cartId for usernamer :"
																						+ data);
																		
																		if (!data.error)
																			location
																					.reload(true);
																	},
																	error : function(
																			xhr) {

																		console
																				.log('Error!  Status asdf= '
																						+ xhr.status
																						+ " Message = "
																						+ xhr.statusText);
																		window.location = "404error.html";

																	}
																});
													},
													error : function(xhr) {
														console
																.log('Error!  Status asdf= '
																		+ xhr.status
																		+ " Message = "
																		+ xhr.statusText);
														window.location = "404error.html";

													}
												});
										console.log("cart id : " + cartId);

									});

				});
