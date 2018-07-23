package com.domain;

import java.math.BigDecimal;

public class Book {
	private BigDecimal BookId;
	private String Title;
	private BigDecimal Rating;

	public Book(BigDecimal BookId, String Title, BigDecimal Rating) {
		super();
		this.BookId = BookId;
		this.Title = Title;
		this.Rating = Rating;
	}

	public BigDecimal getBookId() {
		return BookId;
	}

	public void setBookId(BigDecimal BookId) {
		this.BookId = BookId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}

	public BigDecimal getRating() {
		return Rating;
	}

	public void setRating(BigDecimal Rating) {
		this.Rating = Rating;
	}
	

}
