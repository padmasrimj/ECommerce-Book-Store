package com.java.ServiceImpl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;
import com.java.Dao.*;
import com.java.Bean.BidingDetailsBean;
import com.java.Bean.PostBean;
import com.java.DaoImpl.BidDaoImpl;
import com.java.Pojo.BidsPost;
import com.java.Pojo.Username;
import com.java.Service.BidService;

public class BidServiceImpl implements BidService {

	@Override
	public void createAndStoreBids(BidingDetailsBean bidBean) {
		Session session = SessionUtilHibernate.getSession();
		session.beginTransaction();

		session.save(bidBean);

		session.getTransaction().commit();

	}

	public JSONArray viewBids(BidsPost bidpost) {
		BidDaoImpl beanDao = new BidDaoImpl();
		int postId = Integer.parseInt(bidpost.getPostid());
		List<BidingDetailsBean> biddingDeatilsBean = beanDao.viewBids(postId);
		JSONArray jsonArray = new JSONArray();
		Iterator<BidingDetailsBean> i = biddingDeatilsBean.iterator();
		while (i.hasNext()) {
			BidingDetailsBean bean = (BidingDetailsBean) i.next();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("bidid", bean.getBidid());
			jsonObject.put("postid", bean.getPostId());
			jsonObject.put("price", bean.getPrice());
			jsonObject.put("title", bean.getTitle());
			jsonObject.put("comments", bean.getComments());
			jsonArray.put(jsonObject);
		}
		return jsonArray;
	}

	public JSONArray viewMyBids(Username mybids) {

		BidDaoImpl beanDao = new BidDaoImpl();
		String username = mybids.getUsername();
		List<Object[]> myBiddingDeatils = beanDao.viewMyBids(username);
		JSONArray jsonArray = new JSONArray();

		for (Object[] bidDetails : myBiddingDeatils) {
			BidingDetailsBean bidbean = (BidingDetailsBean) bidDetails[0];
			PostBean postbean = (PostBean) bidDetails[1];
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("bidid", bidbean.getBidid());
			jsonObject.put("postid", bidbean.getPostId());
			jsonObject.put("price", bidbean.getPrice());
			jsonObject.put("title", bidbean.getTitle());
			jsonObject.put("comments", bidbean.getComments());
			jsonObject.put("username", bidbean.getUsername());
			jsonObject.put("author", postbean.getAuthor());
			jsonObject.put("edition", postbean.getEdition());
			jsonObject.put("bookname", postbean.getBookname());
			jsonObject.put("category", postbean.getCategory());
			jsonArray.put(jsonObject);
		}

		return jsonArray;
	}

	@Override
	public BidingDetailsBean getBidDetailsById(int bidId) {
		// TODO Auto-generated method stub
		BidDaoImpl bidDao = new BidDaoImpl();
		return bidDao.getBidDetailsById(bidId);
	}

}
