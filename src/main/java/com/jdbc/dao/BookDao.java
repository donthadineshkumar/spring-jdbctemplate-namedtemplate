package com.jdbc.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterUtils;

import com.jdbc.entity.Book;

public class BookDao {
	
	JdbcTemplate jdbcTemplate;
	
	NamedParameterJdbcTemplate namedTemplate;

	public BookDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public BookDao(NamedParameterJdbcTemplate namedTemplate) {
		this.namedTemplate = namedTemplate;
	}
	
	/*
	 * While using mysql queries - becarful in writing the queries
	 * bz string values need - '' single quotes around the values
	 */

	public List<Book> getBooks(){
		return jdbcTemplate.query("SELECT * FROM BOOK",
				new ResultSetExtractor<List<Book>>(){

					public List<Book> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						List<Book> listBooks = new ArrayList<Book>();
						
						while(rs.next()){
							Book book = new Book();
							
							book.setId(rs.getInt("id"));
							book.setAuthor(rs.getString("author"));
							book.setDescription(rs.getString("description"));
							book.setIsbn(rs.getString("isbn"));
							book.setTitle(rs.getString("title"));
							book.setPrice(rs.getFloat("price"));
							
							listBooks.add(book);
						}
						return listBooks;
					}
			
		});
	}


	public int saveBook(Book b){
		String insertQuery = "INSERT INTO BOOK(id, author, description, "
				+ "			isbn, title, price) VALUES ("
				+ b.getId() +",'"+b.getAuthor()+"','"+
				b.getDescription()+"','"+b.getIsbn()+"','"+
				b.getTitle() +"',"+b.getPrice() +")";
		
		return jdbcTemplate.update(insertQuery);
	}
	
	public int updateBook(Integer id,Float price){
		String updateQuery="UPDATE BOOK SET "
				+ "	price = "+price+" WHERE id="+id;
		return jdbcTemplate.update(updateQuery);
	}

	public int deleteBook(Integer id){
		String deleteQuery = "DELETE FROM BOOK WHERE id=:id";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		return namedTemplate.update(deleteQuery	, params);
		
	}
	
}
