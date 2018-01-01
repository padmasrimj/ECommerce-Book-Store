package com.java.Controller;
import com.java.Bean.*;
import com.java.Service.*;
import com.java.ServiceImpl.BidServiceImpl;
import com.java.ServiceImpl.CartItemServiceImpl;
import com.java.ServiceImpl.CartServiceImpl;
import com.java.ServiceImpl.RegistrationServiceImpl;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.ResponseWrapper;
import java.security.Principal;
import javax.ws.rs.core.SecurityContext;

 
@Path("/cart")
public class CartResourceController {


    private CartService cartService = new CartServiceImpl();
    private CartItemService cartItemService = new CartItemServiceImpl();
    //private CustomerService customerService;
    private ProductService productService;

    @Path("/{cartId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CartBean getCartById(@PathParam("cartId") int cartId){
    	CartBean cart;
    	System.out.println("Inside getCartById"+cartId);
    	cart = cartService.getCartById(cartId);
    	for (int i = 0; i < cart.getCartItems().size(); i++) {
			System.out.println("Caritem "+ i + " cartitem id "+ cart.getCartItems().get(i).getCartItemId());
			System.out.println("Product name "+ cart.getCartItems().get(i).getbiddingDetails().getTitle() + " Produce price "+ cart.getCartItems().get(i).getbiddingDetails().getPrice());
			
		}
        return cart;
    }

    @Path(value = "/add/{cartId}/{bidId}")
    @PUT
    @RolesAllowed("user")
    public void addItem (@Context HttpServletRequest request,@PathParam("cartId") int cartId,
    						@PathParam("bidId") int bidId){
        /*HttpSession session = request.getSession();
    	String uname = (String)session.getAttribute("username");
    	//FIXME:
        //String uname = "atishp04";
        RegistrationService rService = new RegistrationServiceImpl();
    	int cartId = rService.getCardIdByUsername(uname);*/
    	System.out.println("Inside addItem "+cartId+" "+bidId);
    	CartService cartService = new CartServiceImpl();
    	CartBean cart = cartService.getCartById(cartId);
    	BidService bService = new BidServiceImpl();
        //ProductBean product = productService.getProductById(productId);
    	BidingDetailsBean bidDetails = bService.getBidDetailsById(bidId);
        List<CartItemBean> cartItems = cart.getCartItems();

        for (int i=0; i < cartItems.size(); i++){
            if(bidDetails.getBidid() == cartItems.get(i).getbiddingDetails().getBidid()){
            	CartItemBean cartItem = cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                cartItem.setTotalPrice(bidDetails.getPrice()*cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);
                return;
            }
        }
        CartItemBean cartItem = new CartItemBean();
        cartItem.setbiddingDetails(bidDetails);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(bidDetails.getPrice()*cartItem.getQuantity());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
    }

    @PUT
    @Path("/remove/{cartItemId}")
    //@Consumes(MediaType.APPLICATION_JSON)
    public void removeItem(@PathParam("cartItemId") int cartItemId){
    	System.out.println("Inside removeItem");
    	//CartItemBean cartItem = cartItemService.getCartItemByProductId(productId);
        cartItemService.removeCartItem(cartItemId);
        return;
    }

    @DELETE
    @Path(value = "/{cartId}")
    public void clearCart(@PathParam("cartId") int cartId){
    	System.out.println("Inside clearCart");
        CartBean cart = cartService.getCartById(cartId);
        cartItemService.removeAllCartItems(cart);
    }
    
    @PUT
    @Path(value = "/update/{cartItemId}/{quantity}")
    public void updateItem(@PathParam("cartItemId") int cartItemId,@PathParam("quantity") int quantity){
    	System.out.println("Inside updateItem");
    	//CartItemBean cartItem = cartItemService.getCartItemByProductId(productId);
        cartItemService.updateCartItem(cartItemId,quantity);
        return;
    }

    /*@ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
    public void handleClientErrors (Exception ex){

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public void handleServerErrors (Exception ex){

    }
*/

}
