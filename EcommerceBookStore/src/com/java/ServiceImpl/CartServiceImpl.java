package com.java.ServiceImpl;
import com.java.Bean.*;
import com.java.Dao.*;
import com.java.DaoImpl.CartDAOImpl;
import com.java.Service.CartService;

public class CartServiceImpl implements CartService{


	private CartDAO cartDao = new CartDAOImpl();
	
	public CartBean getCartById(int cartId){
	    return cartDao.getCartById(cartId);
	}
	
	public void update(CartBean cart){
	    cartDao.update(cart);
	}

}
