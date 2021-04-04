package com.cg.jpa.lab.services;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import com.cg.jpa.lab.bean.Author;
import com.cg.jpa.lab.bean.Book;
import com.cg.jpa.lab.utility.JPAUtil;

public class BookServiceImpl implements BookService{

	@Override
	public List<Book> getBooks() {
		EntityManager emanager = JPAUtil.getEntityManagerFactory().createEntityManager();
		@SuppressWarnings("unchecked")
		List<Book> list = emanager.createQuery("from Book").getResultList();
		return list;
	}

	@Override
	public List<Book> getBooksByAuthorName(String name) {
		EntityManager emanager = JPAUtil.getEntityManagerFactory().createEntityManager();
		String query = "select a.books from Author a where a.name = "+name;
		@SuppressWarnings("unchecked")
		List<Book> list = emanager.createQuery(query).getResultList();
		return list;
	}

	public List<Book> getBooksBetweenPrice(double minPrice, double maxPrice) {
		EntityManager emanager = JPAUtil.getEntityManagerFactory().createEntityManager();
		String query = "from Book b where b.price bitween "+minPrice+" and "+maxPrice;
		@SuppressWarnings("unchecked")
		List<Book> list = emanager.createQuery(query).getResultList();
		return list;
	}

	@Override
	public List<String> getAuthorNameByBookISBN(int isbn) {
		EntityManager emanager = JPAUtil.getEntityManagerFactory().createEntityManager();
		String query = "select b.authors from Book b where b.isbn="+isbn;
		@SuppressWarnings("unchecked")
		List<Author> list = emanager.createQuery(query).getResultList();
		List<String> names = new ArrayList<>();
		for(Author a:list) {
			names.add(a.getName());
		}
		return names;
	}
}
