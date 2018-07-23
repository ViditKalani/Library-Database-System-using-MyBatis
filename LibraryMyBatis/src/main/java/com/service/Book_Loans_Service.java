package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.Library_DAO;
import com.domain.Book;

public class Book_Loans_Service {

	public void Book_LoansService() {

	}

	public  List<Book> getbookList() {
		List<Book> bookList = new ArrayList<Book>();
		Library_DAO libDAO = new Library_DAO();
		bookList = libDAO.getbookList();
		return bookList;

	}

	public  List<Book> getRatingList() {
		List<Book> bookList = new ArrayList<Book>();
		Library_DAO libDAO = new Library_DAO();
		bookList = libDAO.getRatingList();
		return bookList;

	}

	
}
