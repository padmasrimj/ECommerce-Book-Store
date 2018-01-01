package com.java.DaoImpl;
import com.java.Dao.*;
import com.java.Bean.*;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class CartItemDAOImpl implements CartItemDAO{
	
    //private SessionFactory sessionFactory;
	//Session session = SessionUtilHibernate.getSession();
	
	@Override
	public void addCartItem(CartItemBean cartItem) {
		Session session = SessionUtilHibernate.getSession();
		Transaction tx = session.getTransaction();
		tx.begin();
        session.saveOrUpdate(cartItem);
        session.flush();
        tx.commit();
	}

/*	@Override
	public void removeCartItem(CartItemBean cartItem) {
		//Session session = sessionFactory.getCurrentSession();
		Session session = SessionUtilHibernate.getSession();
		Transaction tx = session.beginTransaction();
        session.delete(cartItem);
        tx.commit();
        session.close();
	}*/
	
	@Override
	public void removeCartItem(int cartItemId) {
		 Session session = SessionUtilHibernate.getSession();
	     Transaction tx = session.beginTransaction();
	     String sql = "delete from CartItemBean where CartItem_ID = :id";
	     Query<ProductBean> query = session.createQuery(sql);
	     System.out.println("Deleting cartItemid : "+cartItemId);
	     query.setParameter("id",cartItemId);
	     int rowCount = query.executeUpdate();
	     System.out.println("Rows affected: " + rowCount);
	     tx.commit();
	     session.close();
	}

	@Override
	public void removeAllCartItems(CartBean cart) {
		List<CartItemBean> cartItems = cart.getCartItems();
        for (CartItemBean item : cartItems){
            removeCartItem(item.getCartItemId());
        }
	}

	@Override
	public CartItemBean getCartItemByProductId(int productId) {
		Session session = SessionUtilHibernate.getSession();
		CartItemBean cartItem = (CartItemBean) session.get(CartItemBean.class, productId);
       /* Query<CartItemBean> query = session.createQuery(" from CartItem where Product_ID = ?");
        query.setParameter(0, productId);
        session.close();*/
        return cartItem;
	}

	@Override
	public void updateCartItem(int cartItemId, int cartItemQuantity) {
		Session session = SessionUtilHibernate.getSession();
	     Transaction tx = session.beginTransaction();
	     String sql = "update CartItemBean set CartItem_quantity = :quant where CartItem_ID = :id";
	     Query<ProductBean> query = session.createQuery(sql);
	     System.out.println("Deleting cartItemid : "+cartItemId);
	     query.setParameter("quant",cartItemQuantity).setParameter("id",cartItemId);
	     int rowCount = query.executeUpdate();
	     System.out.println("Rows affected: " + rowCount);
	     tx.commit();
	     session.close();
	}
		
}

