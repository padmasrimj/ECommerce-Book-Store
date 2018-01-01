$(document).ready(function(){
					alert("loading");
					var jsonobject = {};
					jsonobject["username"] = localStorage.getItem("username");
					$
							.ajax({
								type : "POST",
								url : "https://localhost:8453/EcommerceBookStore/rest/logoutservices/logout",
								data : JSON.stringify(jsonobject),
								async : false,
								dataType : "json",
								contentType : "application/json",
								cache : false,
								headers : {
									Accept : 'application/json'
								},
								success : function(data) {
									alert("success");
								}
							});
});