package com.java.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "post", uniqueConstraints = { @UniqueConstraint(columnNames = "POSTID") })
public class PostBean {

	private int postid;
	private String username;
	private String bookname;
	private String author;
	private String edition;
	private String comments;
	private String category;

	public PostBean() {

	}

	@Column(name = "USERNAME", nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "BOOKNAME")
	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	@Column(name = "AUTHOR")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "EDITION")
	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	@Column(name = "COMMENTS")
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name = "CATEGORY")
	public String getCategory() {
		return category;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "POSTID")
	public int getPostid() {
		return postid;
	}

	public void setPostid(int postid) {
		this.postid = postid;
	}
}
