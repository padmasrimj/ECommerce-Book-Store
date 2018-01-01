package com.java.Pojo;

public class Bid {
	private String title;
	private String comments;
	private String price;
	private String postId;
	private String userName;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getUserName() {
		return userName;
	}

	@Override
	public String toString() {
		return "Bid [title=" + title + ", comments=" + comments + ", price=" + price + ", postId=" + postId
				+ ", userName=" + userName + ", getTitle()=" + getTitle() + ", getComments()=" + getComments()
				+ ", getPrice()=" + getPrice() + ", getPostId()=" + getPostId() + ", getUserName()=" + getUserName()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
