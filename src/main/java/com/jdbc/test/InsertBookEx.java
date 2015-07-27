package com.jdbc.test;

import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbc.dao.BookDao;
import com.jdbc.entity.Book;

public class InsertBookEx {

	public static void main(String[] args) {
		
		ApplicationContext appCtxt = new ClassPathXmlApplicationContext("spring-beans.xml");
		
		BookDao bookDao = (BookDao) appCtxt.getBean("bookDao");
		
		BookDao bookDaoNamed = (BookDao) appCtxt.getBean("bookDaoNamed");
		
		int insertStatus =bookDao.saveBook(new Book(6,"Avatar","A Older Community Story","9000","Avatar-2",100.0F));
		
		int updateStatus =bookDao.updateBook(4, 200F);
		
		int deleteStatus =bookDaoNamed.deleteBook(2);
		
		System.out.println("insert status "+insertStatus);
		
		System.out.println("update status "+updateStatus);
		
		System.out.println("delete status "+deleteStatus);
		
		
		
	}
	
}
