$("#pay").click(function(){
	
	var cardtype = $("#cardtype").val();
	var card = $("#card").val();
	var cvv = $("#cvv").val();
	var date = $("#date").val();
	var cname = $("#cname").val();
	
	if (cardtype != "" && card != "" && cvv != "" && date != "" && cname != "" ) {
		window.location="thankCustomer.jsp";
		murl = "https://localhost:8453/EcommerceBookStore/rest/email/send/" + localStorage.getItem("username");
		console.log("Inside pay"+murl);
		$.ajax({
			url:murl,
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
	}else{
		alert("All fields are required");
	}
});