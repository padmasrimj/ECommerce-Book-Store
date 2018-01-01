var cartApp = angular.module ("cartApp", []);

cartApp.controller("cartCtrl", function($scope, $http){

    $scope.refreshCart = function(){
    	   console.log("in refresh cart");
    	   $http.get($scope.url+'rest/cart/' + $scope.cartId ).success(function (data){
    	   console.log("Data Recieved:"+data);
    	   //console.log(data.cartItems[0].cartItemId);
           $scope.cart = data; //cart : 
       });
    };

    $scope.getcartId = function(){
    	console.log("Inside getcartId function");
    	$http.get($scope.url+ 'rest/customer/getcartId/'+$scope.username).success(function (data){
     	   console.log("Data Recieved:"+data);
     	   $scope.cartId = data; //cart :
     	   $scope.refreshCart();
        });
    };
    
    $scope.clearCart = function(){
    	console.log("Inside Clear cart");
        $http.delete($scope.url+'rest/cart/' + $scope.cartId).success(function(data){
            console.log("Inside clear cart success: " + $scope.cartId);
            $scope.refreshCart();
         });
    };

    $scope.initCartId = function(){
    	$scope.url = "https://localhost:8453/EcommerceBookStore/";
    	$scope.username = localStorage.getItem("username");
    	console.log("Inside initCartId"+$scope.username);
        $scope.cartId = $scope.getcartId();
        console.log("CartId"+$scope.cartId);
        if ($scope.cartId >= 0) {
        	
        	$scope.refreshCart();
        }
    };

    $scope.addToCart = function(bidId){
        $http.put($scope.url+'rest/cart/add/' + $scope.cartId+ +"/"+bidId).success(function (){
            alert('Product successfully added to the cart!');
        });
    };

    $scope.removeFromCart = function(cartItemId){
        $http.put($scope.url+'rest/cart/remove/' + cartItemId).success(function(data){
           console.log("Inside removeFromCart for cartid: " + cartItemId);
           $scope.refreshCart();
        });
    };
    
    $scope.updateCart = function(cartItemId,quantity){ 
    	var quant = $scope.quantity;
    	console.log("Inside updateCart: "+ cartItemId +" quantity:"+ quantity);
        $http.put($scope.url+'rest/cart/update/' + cartItemId + "/"+quantity).success(function(data){
        	console.log("Inside update for cartid: " + cartItemId + $scope.quantity);
           $scope.refreshCart();
        });
    };

    $scope.calGrandTotal = function(){
    	console.log("Inside calGrandTotal");
	    
        var grandTotal = 0;
        	
        if($scope.cart.cartItems.length == 0){
        	grandTotal = 0;
        } else{
	        for (var i = 0; i < $scope.cart.cartItems.length; i++){
	        	console.log("Inside for loop");
	            grandTotal += $scope.cart.cartItems[i].totalPrice;
	        }
        }
        
        return grandTotal;
    }
});