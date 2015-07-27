package com.jdbc.test;




import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.jdbc.entity.Article;

public class JdbcTem {
	
	public static void main(String[] args) {
		
		
		/*
		 * By this we can load the beans
		 * 
		 */
		ApplicationContext appctxt 
			= new ClassPathXmlApplicationContext("spring-beans.xml");
		
		String sql = "SELECT * FROM article";
		
		JdbcTemplate template = (JdbcTemplate) appctxt.getBean("jdbcTemplate");
		
		Article  article
			= (Article) template.queryForObject(sql, new ArticleRepo());
		

			System.out.println(article.getTitle());

		
	}
	private static final class ArticleRepo implements RowMapper<Article>{

		public Article mapRow(ResultSet rs, int rowNum) throws SQLException {

			return new Article(
						rs.getInt("id"),
						rs.getString("title")
					);
		}
		
		
		
	}
	

}
