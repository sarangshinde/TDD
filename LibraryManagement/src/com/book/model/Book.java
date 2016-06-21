package com.book.model;

public class Book {
	
	public Book(String bookName, String bookAutherName, float bookPrise,BookType bookType) {
		super(); 
		this.bookName = bookName;
		this.bookAutherName = bookAutherName;
		this.bookPrise = bookPrise;
		this.bookType = bookType;
	
	}
	private String bookName;
	private String bookAutherName;
	private float bookPrise;
	private int numberOfCopies;
	 public enum BookType {
	    TECHNICAL,
	    NONTECHNICAL
	};
	private BookType bookType;
	public BookType getBookType() {
		return bookType;
	}
	

}
