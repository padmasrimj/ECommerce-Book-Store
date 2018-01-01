package com.java.Pojo;

public class Post {
	private String author;
	private String username;
	private String name;
	private String edition;
	private String comments;
	private String category;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Post [author=" + author + ", username=" + username + ", name=" + name + ", edition=" + edition
				+ ", comments=" + comments + ", category=" + category + ", getAuthor()=" + getAuthor()
				+ ", getUsername()=" + getUsername() + ", getName()=" + getName() + ", getEdition()=" + getEdition()
				+ ", getComments()=" + getComments() + ", getCategory()=" + getCategory() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
