$(document).ready(function(){
	$("#logout").click(function(){
		localStorage.removeItem("username");
		window.location= "index.html";
	});
});