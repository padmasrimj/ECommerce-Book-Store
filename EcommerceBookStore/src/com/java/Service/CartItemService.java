package com.java.Service;
import com.java.Bean.*;

public interface CartItemService {

    void addCartItem(CartItemBean cartItem);

    void removeCartItem(int cartItemId);
    
    void updateCartItem(int cartItemId, int quantity);

    void removeAllCartItems(CartBean cart);

    CartItemBean getCartItemByProductId(int productId);
}
