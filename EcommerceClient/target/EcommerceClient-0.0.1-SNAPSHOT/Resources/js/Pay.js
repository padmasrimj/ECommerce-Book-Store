$("#pay").click(function(){
	window.location="http://localhost:8080/EcommerceBookStore/thankCustomer.jsp";
	$.ajax({
		url:"http://localhost:8080/EcommerceBookStore/rest/email/send",
		type:"GET",
		async:true,
		cache : false,
		headers : {
			Accept : 'application/json'
		},
		success:function(data){
				alert("email sent Successful");					
			
		}
		
	});
});