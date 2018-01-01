$(document)
		.ready(
				function() {

					var JSONRequestParametersObject = {};
					JSONRequestParametersObject["username"] = localStorage
							.getItem("username");

					$
							.ajax({

								type : 'POST',
								url : 'https://localhost:8453/EcommerceBookStore/rest/postServices/viewmybids',
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
													+ serialno
													+ "</td><td class='text-left'><p>"
													+ data[i].bookname
													+ ","
													+ data[i].edition
													+ " edition</p><p>"
													+ data[i].author
													+ "</p><p>"
													+ data[i].postComments
													+ "</p></td><td class='text-left'><p>"
													+ data[i].title
													+ "</p><p>"
													+ data[i].comments
													+ "</p><h2><p>$"
													+ data[i].price
													+ "</p></h2></td></tr>"
											$("#bidDetails").append(
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

					$("#postDetails").on('click', '.bidthisitem', function() {
						var postId = this.id;
						localStorage.setItem("postid", postId);
						window.location = "bid.jsp";
					});
					$("#postDetails").on('click', '.viewbids', function() {
						var postId = this.id;
						localStorage.removeItem("addToCart");
						localStorage.setItem("postid", postId);
						localStorage.setItem("addToCart", "false");
						window.location = "viewBids.jsp";
					});

					$("#search").click(function() {

						var bookname = $("#bookname").val();
						var category = $("#category").val();
						if (bookname.length != 0) {
							localStorage.setItem("bookname", bookname);
						}
						if (category.length != 0) {
							localStorage.setItem("category", category);
						}
						location.reload();

					});

					$("#remove").click(function() {
						localStorage.removeItem("bookname");
						localStorage.removeItem("category");
						location.reload();

					});

				});