package com.java.DaoImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.java.Bean.*;
import com.java.Dao.*;
import java.io.IOException;
import java.util.List;


public class CartDAOImpl implements CartDAO {

    
    //private SessionFactory sessionFactory;
    //private CustomerOrderService customerOrderService;
    

    public CartBean getCartById(int cartId){
    	Session session = SessionUtilHibernate.getSession();
    	
		return (CartBean) session.get(CartBean.class, cartId);
    }

    public void update(CartBean cart){
    	System.out.println("In update method");
    }
     /*   int cartId = cart.getCartId();
        double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
        cart.setGrandTotal(grandTotal);

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
    }*/

    public CartBean validate(int cartId) throws IOException{
        CartBean cart = getCartById(cartId);
        if(cart == null || cart.getCartItems().size() == 0){
            throw new IOException(cartId + "");
        }

        update(cart);
        return cart;
    }
    
    

}
