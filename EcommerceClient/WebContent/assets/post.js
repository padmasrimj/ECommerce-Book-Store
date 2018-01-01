$(document)
		.ready(
				function($) {

					$("#post_item")
							.click(
									function() {

										// ajaxCall();
										var JSONRequestParametersObject = {};
										JSONRequestParametersObject["author"] = $(
												"#author").val();
										JSONRequestParametersObject["edition"] = $(
												"#edition").val();
										JSONRequestParametersObject["name"] = $(
												"#bookname").val();
										JSONRequestParametersObject["category"] = $(
												"#category").val();
										JSONRequestParametersObject["comments"] = $(
												"#comments").val();
										JSONRequestParametersObject["username"] = localStorage.getItem("username");
										$
												.ajax({

													type : 'POST',
													url : 'https://localhost:8453/EcommerceBookStore/rest/postServices/postItem',
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
															window.location = "viewMyPosts.jsp";
														}

													},
													error : function(xhr) {

														console
																.log('Error!  Status asdf= '
																		+ xhr.status
																		+ " Message = "
																		+ xhr.statusText);
														alert("Sorry some problem with posting your data. Please try again after some time");
														window.location = "404error.html";
													}
												});

									});
					$("#back").click(function(){
						window.location="profile.jsp";
					});

				});
