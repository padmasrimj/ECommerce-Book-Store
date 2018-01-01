package com.java.ServiceImpl;
import com.java.Dao.*;
import com.java.DaoImpl.CartItemDAOImpl;
import com.java.Bean.*;

import com.java.Service.CartItemService;

public class CartItemServiceImpl implements CartItemService{

    private CartItemDAO cartItemDao = new CartItemDAOImpl();

    public void addCartItem(CartItemBean cartItem){
        cartItemDao.addCartItem(cartItem);
    }

    public void removeCartItem(int cartItemId){
        cartItemDao.removeCartItem(cartItemId);
    }

    public void removeAllCartItems(CartBean cart){
        cartItemDao.removeAllCartItems(cart);
    }

    public CartItemBean getCartItemByProductId(int productId){
        return cartItemDao.getCartItemByProductId(productId);
    }

	public void updateCartItem(int cartItemId, int quantity) {
		cartItemDao.updateCartItem(cartItemId,quantity);
	}

}
