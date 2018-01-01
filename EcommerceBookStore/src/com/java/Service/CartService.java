package com.java.Service;
import com.java.Bean.*;

public interface CartService {

    CartBean getCartById(int cartId);

    void update(CartBean cart);
 
}
