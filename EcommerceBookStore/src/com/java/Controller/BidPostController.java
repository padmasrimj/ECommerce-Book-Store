package com.java.Controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;

import com.java.Bean.BidingDetailsBean;
import com.java.Bean.PostBean;
import com.java.DaoImpl.BidDaoImpl;
import com.java.DaoImpl.PostDaoImpl;
import com.java.Pojo.Bid;
import com.java.Pojo.BidsPost;
import com.java.Pojo.Post;
import com.java.Pojo.SearchParameters;
import com.java.Pojo.Username;
import com.java.ServiceImpl.BidServiceImpl;
import com.java.ServiceImpl.PostServiceImpl;

@Path("/postServices")
public class BidPostController {

	@Path("/postItem")
	@POST
	@Consumes("application/json")
	public Response postItem(Post post) {
		System.out.println("inside postItem");
		boolean response = false;
		PostBean postBean = new PostBean();
		postBean.setAuthor(post.getAuthor());
		postBean.setUsername(post.getUsername());
		postBean.setBookname(post.getName());
		postBean.setEdition(post.getEdition());
		postBean.setComments(post.getComments());
		postBean.setCategory(post.getCategory());
		PostDaoImpl dao = new PostDaoImpl();
		dao.addPost(postBean);
		response = true;
		return Response.ok().entity(String.valueOf(response)).build();
	}

	@Path("/bidItem")
	@POST
	@Consumes("application/json")
	public Response bidItem(Bid bid) {
		boolean response = false;
		BidingDetailsBean bidBean = new BidingDetailsBean();
		bidBean.setComments(bid.getComments());
		bidBean.setPostId(Integer.parseInt(bid.getPostId()));
		bidBean.setPrice(Double.parseDouble(bid.getPrice()));
		bidBean.setTitle(bid.getTitle());
		bidBean.setUsername(bid.getUserName());
		BidDaoImpl dao = new BidDaoImpl();
		dao.addBid(bidBean);
		response = true;
		return Response.ok().entity(String.valueOf(response)).build();
	}

	@Path("/searchPosts")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response searchPosts(SearchParameters searchParameters) {

		PostServiceImpl impl = new PostServiceImpl();
		JSONArray searchResults = impl.searchPosts(searchParameters);
		return Response.ok().entity(searchResults.toString()).build();
	}

	@Path("/viewbids")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response viewBids(BidsPost bidpost) {

		BidServiceImpl impl = new BidServiceImpl();
		JSONArray bids = impl.viewBids(bidpost);
		return Response.ok().entity(bids.toString()).build();
	}

	@Path("/viewmybids")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response viewMyBids(Username mybids) {

		BidServiceImpl impl = new BidServiceImpl();
		JSONArray myBids = impl.viewMyBids(mybids);
		return Response.ok().entity(myBids.toString()).build();
	}

	@Path("/viewmyposts")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response viewMyPosts(Username myposts) {
		System.out.println("inside");
		PostServiceImpl impl = new PostServiceImpl();
		JSONArray myPosts = impl.myPosts(myposts);
		System.out.println(myPosts.toString());
		return Response.ok().entity(myPosts.toString()).build();
	}

	@Path("/deletePost")
	@POST
	@Consumes("application/json")
	public Response deletePost(BidsPost bidpost) {

		PostServiceImpl impl = new PostServiceImpl();
		impl.deletePost(bidpost);
		return Response.ok().entity(true).build();
	}
}
