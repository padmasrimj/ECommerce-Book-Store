$(document)
		.ready(
				function($) {

					$("#bidItem")
							.click(
									function() {

										// ajaxCall();
										console.log('bid initiated');
										var JSONRequestParametersObject = {};
										JSONRequestParametersObject["title"] = $(
												"#title").val();
										JSONRequestParametersObject["comments"] = $(
												"#comments").val();
										JSONRequestParametersObject["price"] = $(
												"#price").val();
										JSONRequestParametersObject["postId"] = localStorage
												.getItem("postid");
										JSONRequestParametersObject["userName"] = localStorage.getItem("username");
										$
												.ajax({

													type : 'POST',
													url : 'http://localhost:8080/EcommerceBookStore/rest/postServices/bidItem',
													data : JSON
															.stringify(JSONRequestParametersObject),
													async : false,
													contentType : "application/json; charset=utf-8",
													dataType : "json",
													cache : false,
													headers : {
														Accept : 'application/json'
													},
													success : function(data) {

														console.log(data);

														if (data.errorMessage != null) {
															alert(data.errorMessage);
														} else {
															alert("Successfully Posted your Request");
															window.location = "viewAllPosts.js";
														}

													},
													error : function(xhr) {

														console
																.log('Error!  Status asdf= '
																		+ xhr.status
																		+ " Message = "
																		+ xhr.statusText);
														alert('Error!  Status asdf= '
																+ xhr.status
																+ " Message = "
																+ xhr.statusText);
													}
												});

									});

				});
