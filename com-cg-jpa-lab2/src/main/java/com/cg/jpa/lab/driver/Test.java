package com.cg.jpa.lab.driver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.jpa.lab.bean.Author;
import com.cg.jpa.lab.bean.Book;

public class Test {

	public static void main(String[] args) {
		EntityManagerFactory emp = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emp.createEntityManager();
		EntityTransaction et = em.getTransaction();
		//et.begin();
		@SuppressWarnings("unchecked")
		//List<Book> list=em.createQuery("select a.books from Author a where a.name = 'James'").getResultList();
		List<Book> list = em.createQuery("from Book b where b.price between 800 and 1200").getResultList();
		list.forEach(f-> System.out.println(f));
		
		/*
		 * Book b1 = new Book(1, "Java Language", 1700); Book b2 = new Book(2, "Python",
		 * 1100); Book b3 = new Book(3, "Javascript", 999);
		 * 
		 * Author a1 = new Author(101, "James"); Author a2 = new Author(102, "Karl");
		 * 
		 * Set<Author> aset1 = new HashSet<Author>(); aset1.add(a1);
		 * 
		 * Set<Author> aset2 = new HashSet<Author>(); aset1.add(a2);
		 * 
		 * Set<Author> aset3 = new HashSet<Author>(); aset1.add(a1); aset1.add(a2);
		 * 
		 * b1.setAuthors(aset1); b2.setAuthors(aset2); b3.setAuthors(aset3);
		 * 
		 * Set<Book> bset1 = new HashSet<Book>(); bset1.add(b1);
		 * 
		 * Set<Book> bset2 = new HashSet<Book>(); bset2.add(b2); bset2.add(b3);
		 * 
		 * 
		 * em.persist(b1); em.persist(b2); em.persist(b3); em.persist(a1);
		 * em.persist(a2);
		 * 
		 * et.commit(); em.close();
		 */
	}
}
