package com.cg.jpa.lab.services;

import java.util.List;

import com.cg.jpa.lab.bean.Book;

public interface BookService {

	public List<Book> getBooks();
	
	public List<Book> getBooksByAuthorName(String name);
	
	public List<Book> getBooksBetweenPrice(double minPrice, double maxPrice);
	
	public List<String> getAuthorNameByBookISBN(int isbn);
	
}
