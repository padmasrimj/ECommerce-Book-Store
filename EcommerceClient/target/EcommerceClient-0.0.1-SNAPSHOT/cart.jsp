<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/Views/template/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart Details</title>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="<c:url value="/Resources/js/controller.js" /> "></script>

</head>
<body>
<div class="container">
            <div class="jumbotron">
                <div class="container">
                    <h1>Cart</h1>
                    <p>All the selected products in your shopping cart</p>
                </div>
            </div>
        <section class="container" ng-app="cartApp">
			<div ng-controller = "cartCtrl" ng-init="initCartId()">
          	    <div>
                    <a class="btn btn-danger pull-left" ng-click = "clearCart()"><span class="glyphicon glyphicon-remove-sign"></span> Clear Cart</a>
<%--                <a href="<c:url value="/order/${cartId}" />" class="btn btn-success pull-right"><span class="glyphicon glyphicon-shopping-cart"></span> Check out</a>--%> 
               		<a href="/EcommerceBookStore/Payment.jsp" class="btn btn-success pull-right"><span class="glyphicon glyphicon-shopping-cart"></span> Check out</a>
               </div>

                <br/><br/><br/>

                <table class="table table-hover">
                    <tr>
                        <th>Product</th>
                        <th>Unit Price</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                    <tr ng-repeat = "item in cart.cartItems">
                        <td class="col-sm-1 col-md-1 text-center">{{item.biddingDetails.title}}</td>
                        <td class="col-sm-1 col-md-1 text-center">{{item.biddingDetails.price}}</td>
                        <td><input type="number" ng-model="quantity" id="quantity" name="input"  value={{item.quantity}}></td>
                       <!--  <td class="col-sm-1 col-md-1 text-center">{{item.quantity}}</td> -->
                        <td class="col-sm-1 col-md-1 text-center">{{item.totalPrice}}</td> 
                        
                                               
                        <td class="col-sm-1 col-md-1 text-center"><a href="#" class="label label-danger" ng-click="removeFromCart(item.cartItemId)"><span class="glyphicon glyphicon-remove"></span>remove</a></td>
                        <td class="col-sm-1 col-md-1 text-center"><a href="#" class="label label-success" ng-click="updateCart(item.cartItemId,quantity)"><span class="glyphicon glyphicon-update"></span>update</a></td>
                    </tr>
                    <tr>
                        <th></th>
                        <th></th>
                       	<th>Grand Total</th>
                        <th>{{calGrandTotal()}}</th>
                        <th></th>
                    </tr>
                </table>

                <a href="<c:url value="/productList" />" class="btn btn-default">Continue Shopping</a>
            </div>
        </section>
        
<%@ include file="/Views/template/footer.jsp" %>
        
</div>
</body>
</html>
