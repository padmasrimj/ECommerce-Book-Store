package com.java.Dao;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.java.Bean.*;


public class ProductDAO {
	public void addProduct(ProductBean bean){
		Transaction tx = null;
		Session session = SessionUtilHibernate.getSession();
        try {		        
			tx = session.beginTransaction();
			addProduct(session,bean);        
			tx.commit();
			
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
            System.out.println(e.getMessage());
            System.out.println("error");
        }finally {
        	//session.close();
		}
 
    }
	
	private void addProduct(Session session, ProductBean bean){
        ProductBean product = new ProductBean();
        
        try {
			product.setProductId(bean.getProductId());
			product.setProductName(bean.getProductName());
			product.setProductPrice(bean.getProductPrice());
			product.setProductCategory(bean.getProductCategory());
			product.setProductDescription(bean.getProductDescription());
			System.out.println("Details Added");
			session.save(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public List<ProductBean> getProducts(){
			Session session = SessionUtilHibernate.getSession();    
			List<ProductBean> products = session.createQuery("from product").getResultList();
			for(int i = 0; i < products.size(); i++){
				System.out.println("@@@@@@@@@"+products.get(i).getProductName());
			}
			session.close(); 
			System.out.println("product list displayed");
	        return products;
    }
	
	public ProductBean getProductByID(int id){
		Session session = SessionUtilHibernate.getSession();
		Transaction tx = session.beginTransaction();
		ProductBean product = (ProductBean)session.get(ProductBean.class,id);
		tx.commit();
	    session.flush();
	    return product;
		
	}
	
	public int deleteProduct(int id) {
	    Session session = SessionUtilHibernate.getSession();
        Transaction tx = session.beginTransaction();
        String sql = "delete from product where Product_ID = :id";
        Query<ProductBean> query = session.createQuery(sql);
        query.setParameter("id",id);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();
        return rowCount;
	}
	
}
