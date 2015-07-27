package com.jdbc.entity;


public class Book {

	private Integer id;
	private String author;
	private String description;
	private String isbn;
	private String title;
	private Float price;
	

	
	public Book() {
	}


	public Book(Integer id, String author, String description, String isbn,
			String title, Float price) {
		this.id = id;
		this.author = author;
		this.description = description;
		this.isbn = isbn;
		this.title = title;
		this.price = price;
	}
	

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
}
