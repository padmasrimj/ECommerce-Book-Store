package com.java.Pojo;

public class SearchParameters {
	private String category;
	private String bookname;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	@Override
	public String toString() {
		return "SearchParameters [category=" + category + ", bookname=" + bookname + ", getCategory()=" + getCategory()
				+ ", getBookname()=" + getBookname() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
