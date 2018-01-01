package com.java.ServiceImpl;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;
import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;
import com.java.Bean.PostBean;
import com.java.DaoImpl.PostDaoImpl;
import com.java.Pojo.Username;
import com.java.Pojo.BidsPost;
import com.java.Pojo.SearchParameters;
import com.java.Service.PostService;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;

import com.java.Dao.*;

public class PostServiceImpl implements PostService {
	private MemcachedClient m_Client;
	public void createAndStorePost(PostBean postBean) {
		Session session = SessionUtilHibernate.getSession();
		session.beginTransaction();
		session.save(postBean);
		session.getTransaction().commit();
	}

	public JSONArray searchPosts(SearchParameters searchParameters) {
		PostDaoImpl postDao = new PostDaoImpl();
		List<PostBean> postBean = postDao.searchPosts(searchParameters);
		/*
		 * JSONArray jsonArray = new JSONArray(); Iterator<PostBean> i =
		 * postBean.iterator(); while (i.hasNext()) { PostBean bean = (PostBean)
		 * i.next(); JSONObject jsonObject = new JSONObject();
		 * jsonObject.put("author", bean.getAuthor()); jsonObject.put("edition",
		 * bean.getEdition()); jsonObject.put("bookname", bean.getBookname());
		 * jsonObject.put("category", bean.getCategory());
		 * jsonArray.put(jsonObject); } return jsonArray;
		 */
		return PostServiceImpl.loadPostData(postBean);

	}

	public JSONArray myPosts(Username name) {
		try {
			this.m_Client = new MemcachedClient(AddrUtil.getAddresses("127.0.0.1:11211"));
			PostDaoImpl postDao = new PostDaoImpl();
			String username = name.getUsername();
			List<PostBean> postBean = postDao.viewMyPosts(username);
			/*
			 * JSONArray jsonArray = new JSONArray(); Iterator<PostBean> i =
			 * postBean.iterator(); while (i.hasNext()) { PostBean bean =
			 * (PostBean) i.next(); JSONObject jsonObject = new JSONObject();
			 * jsonObject.put("author", bean.getAuthor());
			 * jsonObject.put("edition", bean.getEdition());
			 * jsonObject.put("bookname", bean.getBookname());
			 * jsonObject.put("category", bean.getCategory());
			 * jsonArray.put(jsonObject); }
			 */
			return PostServiceImpl.loadPostData(postBean);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.m_Client.shutdown();
		}
	}							
					

	private static JSONArray loadPostData(List<PostBean> postBean) {
		JSONArray jsonArray = new JSONArray();
		Iterator<PostBean> i = postBean.iterator();
		while (i.hasNext()) {
			PostBean bean = (PostBean) i.next();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("author", bean.getAuthor());
			jsonObject.put("edition", bean.getEdition());
			jsonObject.put("bookname", bean.getBookname());
			jsonObject.put("category", bean.getCategory());
			jsonObject.put("comments", bean.getComments());
			jsonObject.put("postId", bean.getPostid());
			jsonArray.put(jsonObject);
		}
		return jsonArray;

	}

	public void deletePost(BidsPost bidpost) {
		int postId = Integer.parseInt(bidpost.getPostid());

		PostDaoImpl pdo = new PostDaoImpl();
		pdo.deletePost(postId);

	}

}
