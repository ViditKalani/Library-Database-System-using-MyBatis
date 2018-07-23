package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.domain.Book;
import com.util.ConnectionFactory;

public class Library_DAO {

	public Library_DAO() {
	}

	public List<Book> getbookList() {
		List<Book> bookList = new ArrayList<Book>();

		SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession();

		try {
			bookList = session.selectList("com.mapper.Library_Mapper.selectAll");
		} finally {
			session.close();
		}
		return bookList;

	}
	
	public List<Book> getRatingList() {
		List<Book> bookList = new ArrayList<Book>();

		SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession();

		try {
			bookList = session.selectList("com.mapper.Library_Mapper.selectAvg");
		} finally {
			session.close();
		}
		return bookList;

	}

}
