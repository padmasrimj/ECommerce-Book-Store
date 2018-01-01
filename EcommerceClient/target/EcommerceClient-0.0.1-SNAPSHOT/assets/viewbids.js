$(document)
		.ready(
				function() {

					var JSONRequestParametersObject = {};
					JSONRequestParametersObject["postid"] = localStorage
							.getItem("postid");

					$
							.ajax({

								type : 'POST',
								url : 'http://localhost:8080/EcommerceBookStore/rest/postServices/viewbids',
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
									var abc = localStorage.getItem("addToCart");
									alert(abc);

									if (data.errorMessage != null) {
										alert(data.errorMessage);
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
														+ "</p></div><div class='col-xs-12 col-md-6'><a class='btn btn-success' href='#'>Add to cart</a></div></div></div></div></div>";

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
									alert('Error!  Status asdf= ' + xhr.status
											+ " Message = " + xhr.statusText);

								}
							});

				});