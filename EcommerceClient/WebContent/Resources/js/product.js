/*$(document).ready(function(){
	displayProduct();
});

function displayProduct(){
	var id = $("#product").text(); //This id will be used with the REST back-end.

	$.get("http://localhost:8080/EcommerceBookStore/rest/hello", { } ,
	    function(product) {
			console.log("hfjshjfsj");
	        $("#p1").replaceWith("product: <b>" + product.productName + " " + product.productPrice + "</b><br/>" )
	    }, 
	    "text/html");
}*/
$(document).ready(function(){
	displayProduct();
});
function displayProduct()
                {
                    $.ajax(
                    {
                        dataType: 'text',
                        type:'GET',
                        url:'rest/product/hello',
                        success: function(data)
                        {
                        	console.log(data);
                        	alert(data);
                        	//jQuery.each(data, function(name, price) {
                        	//var ret= jQuery.parseJSON(data);
                        		//document.getElementById("#p1").innerHTML =data;
                        		//("#price").load(data.price)
                        		
                       // });
                    },
                        error: function(jqXHR, exception)
                        {
                        	var msg = '';
                            if (jqXHR.status == 0) {
                                msg = 'Not connect.\n Verify Network.';
                            } else if (jqXHR.status == 404) {
                                msg = 'Requested page not found. [404]';
                            } else if (jqXHR.status == 500) {
                                msg = 'Internal Server Error [500].';
                            } else if (exception === 'parsererror') {
                                msg = 'Requested JSON parse failed.';
                            } else if (exception === 'timeout') {
                                msg = 'Time out error.';
                            } else if (exception === 'abort') {
                                msg = 'Ajax request aborted.';
                            } else {
                                msg = 'Uncaught Error.\n' + jqXHR.responseText;
                            }
                           //alert("msg");
                            $("#p1").html(msg);
                        }
                    });
                }