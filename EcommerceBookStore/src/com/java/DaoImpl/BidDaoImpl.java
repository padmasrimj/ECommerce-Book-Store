package com.java.DaoImpl;

import java.util.List;

import org.hibernate.Session;

import com.java.Bean.BidingDetailsBean;
import com.java.Dao.*;
import com.java.ServiceImpl.BidServiceImpl;

@SuppressWarnings("unchecked")
public class BidDaoImpl implements BidDao {
	public void addBid(BidingDetailsBean bidBean) {
		BidServiceImpl bid = new BidServiceImpl();
		bid.createAndStoreBids(bidBean);
	}

	
	public List<BidingDetailsBean> viewBids(int postId) {
		Session session = SessionUtilHibernate.getSession();
		session.getTransaction().begin();
		List<BidingDetailsBean> list = session.createQuery("from BidingDetailsBean where postId=" + postId)
				.getResultList();
		session.getTransaction().commit();
		return list;
	}
	
	public List<Object[]> viewMyBids(String username) {
		Session session = SessionUtilHibernate.getSession();
		session.getTransaction().begin();
		List<Object[]> list = session.createQuery("from BidingDetailsBean b,PostBean p where p.postid=b.postId and b.username='"+username+"'").getResultList();
		session.getTransaction().commit();
		return list;
	}


	@Override
	public BidingDetailsBean getBidDetailsById(int bidId) {
		Session session = SessionUtilHibernate.getSession();
		session.getTransaction().begin();
		List<BidingDetailsBean> list = session.createQuery("from BidingDetailsBean where bidid=" + bidId)
				.getResultList();
		session.getTransaction().commit();
		return list.get(0);
	
	}

}
