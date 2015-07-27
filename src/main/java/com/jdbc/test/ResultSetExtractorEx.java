package com.jdbc.test;

import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbc.dao.BookDao;
import com.jdbc.entity.Book;

public class ResultSetExtractorEx {

public static void main(String[] args) {
	
	ApplicationContext appCtxt = new ClassPathXmlApplicationContext("spring-beans.xml");
	
	BookDao bookDao = (BookDao) appCtxt.getBean("bookDao");
	
	
	List<Book> listBooks = bookDao.getBooks();
	
	for (Book book : listBooks) {
		System.out.println(book.getTitle());
	}
	
}
	
	
	
}
