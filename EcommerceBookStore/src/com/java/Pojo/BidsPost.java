package com.java.Pojo;

public class BidsPost {
	private String postid;

	public String getPostid() {
		return postid;
	}

	public void setPostid(String postid) {
		this.postid = postid;
	}

	@Override
	public String toString() {
		return "BidsPost [postid=" + postid + ", getPostid()=" + getPostid() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
