$(document)
		.ready(
				function() {

					var JSONRequestParametersObject = {};
					JSONRequestParametersObject["bookname"] = localStorage
							.getItem("bookname");
					JSONRequestParametersObject["category"] = localStorage
							.getItem("category");
					/*
					 * bid = function(){ alert(this.id); }
					 */

					$
							.ajax({

								type : 'POST',
								url : 'http://localhost:8080/EcommerceBookStore/rest/postServices/searchPosts',
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
										alert(data.errorMessage);
									} else {
										for (var i = 0; i < data.length; i++) {

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
													+ "</td><td class='text--left'><input type='button' class='btn btn-primary bidthisitem' id='"
													+ data[i].postId
													+ "' value='Bid Item' /></td></tr>"
											$("#postDetails").append(
													newRowContent);
										}

										localStorage.removeItem("bookname");
										localStorage.removeItem("category");
									}

								},
								error : function(xhr) {

									console.log('Error!  Status asdf= '
											+ xhr.status + " Message = "
											+ xhr.statusText);
									alert('Error!  Status asdf= ' + xhr.status
											+ " Message = " + xhr.statusText);

								}
							});

					$("#postDetails").on('click', '.bidthisitem', function() {
						var postId = this.id;
						localStorage.setItem("postid", postId);
						window.location = "bid.jsp";
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