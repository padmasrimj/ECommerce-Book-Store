$(document)
		.ready(
				function() {

					var JSONRequestParametersObject = {};
					JSONRequestParametersObject["username"] = localStorage.getItem("username");

					$
							.ajax({

								type : 'POST',
								url : 'https://localhost:8453/EcommerceBookStore/rest/postServices/viewmyposts',
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
										console.log(data.errorMessage);
									} else {
										for (var i = 0; i < data.length; i++) {
											var serialno = i + 1;
											var newRowContent = "<tr><td class='text-left'>"
													+ data[i].bookname
													+ "</td><td class='text-left'>"
													+ data[i].author
													+ "</td><td class='text-left'>"
													+ data[i].edition
													+ "</td><td class='text-left'>"
													+ data[i].category
													+ "</td><td class='text-left'>"
													+ data[i].comments
													+ "</td><td class='text--left'><input type='button' class='btn btn-primary viewbids' id='"
													+ data[i].postId
													+ "' value='View Bids' /></td><td class='text--left'><input type='button' class='btn btn-danger deleteitem' id='"
													+ data[i].postId
													+ "' value='Delete Post' /></td></tr>"
											$("#postDetails").append(
													newRowContent);
										}

									}

								},
								error : function(xhr) {

									console.log('Error!  Status asdf= '
											+ xhr.status + " Message = "
											+ xhr.statusText);
									window.location = "404error.html";

								}
							});

					$("#postDetails").on('click', '.deleteitem', function() {
						var postId = this.id;
						var JSONRequestParametersObject = {};
						JSONRequestParametersObject["postid"] = postId
						
						$.ajax({
							type : 'POST',
							url : 'https://localhost:8453/EcommerceBookStore/rest/postServices/deletePost',
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
								if(!data.error) location.reload(true);
							},
							error : function(xhr) {

								console.log('Error!  Status asdf= '
										+ xhr.status + " Message = "
										+ xhr.statusText);
								window.location = "404error.html";
							}
						});
					});
					
					
					$("#postDetails").on('click', '.viewbids', function() {
						var postId = this.id;
						localStorage.removeItem("addToCart");
						localStorage.setItem("postid", postId);
						localStorage.setItem("addToCart", "true");
						window.location = "viewBids.jsp";
					});


				});