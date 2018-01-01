package com.java.Dao;
import java.io.IOException;
import com.java.Bean.*;


public interface CartDAO {

    CartBean getCartById(int cartId);

    CartBean validate(int cartId) throws IOException;

    void update(CartBean cart);
}
