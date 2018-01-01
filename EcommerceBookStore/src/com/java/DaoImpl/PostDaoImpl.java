package com.java.DaoImpl;

import java.util.List;

import org.hibernate.Session;

import com.java.Bean.PostBean;
import com.java.Dao.*;
import com.java.Pojo.SearchParameters;
import com.java.ServiceImpl.PostServiceImpl;

public class PostDaoImpl implements PostDao {
	public void addPost(PostBean productBean) {
		PostServiceImpl post = new PostServiceImpl();
		post.createAndStorePost(productBean);
	}

	@SuppressWarnings("unchecked")
	public List<PostBean> searchPosts(SearchParameters searchParameters) {
		Session session = SessionUtilHibernate.getSession();
		session.getTransaction().begin();
		List<PostBean> list = null;

		if ((searchParameters.getBookname() == null || searchParameters.getBookname().equalsIgnoreCase("null"))
				&& (searchParameters.getCategory() == null
						|| searchParameters.getCategory().equalsIgnoreCase("null"))) {
			list = session.createQuery("from PostBean").getResultList();
		} else if (searchParameters.getBookname() == null || searchParameters.getBookname().equalsIgnoreCase("null")) {
			list = session.createQuery("from PostBean where category='" + searchParameters.getCategory() + "'")
					.getResultList();
		} else if (searchParameters.getCategory() == null || searchParameters.getCategory().equalsIgnoreCase("null")) {
			list = session.createQuery("from PostBean where bookname='" + searchParameters.getBookname() + "'")
					.getResultList();
		} else {
			list = session.createQuery("from PostBean where bookname='" + searchParameters.getBookname()
					+ "' and category='" + searchParameters.getCategory() + "'").getResultList();
		}
		session.getTransaction().commit();
		return list;
	}

	public List<PostBean> viewMyPosts(String username) {
		Session session = SessionUtilHibernate.getSession();
		session.getTransaction().begin();
		List<PostBean> list = session.createQuery("from PostBean where username='" + username + "'").getResultList();
		session.getTransaction().commit();
		return list;
	}

	public void deletePost(int postid) {
		Session session = SessionUtilHibernate.getSession();
		session.getTransaction().begin();
		int n = session.createQuery("delete from PostBean where postid='" + postid + "'").executeUpdate();
		System.out.println(n + "rows effected");
		session.getTransaction().commit();

	}
}
