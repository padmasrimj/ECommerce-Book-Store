package com.java.Dao;
import com.java.Bean.*;


public interface CartItemDAO {

    void addCartItem(CartItemBean cartItem);

    void removeCartItem(int cartItemId);
    
    void updateCartItem(int cartItemId, int quantity);

    void removeAllCartItems(CartBean cart);

    CartItemBean getCartItemByProductId(int productId);
}

