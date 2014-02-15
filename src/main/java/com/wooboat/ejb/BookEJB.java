package com.wooboat.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.wooboat.entity.Book;

@Stateless
public class BookEJB {

	@PersistenceContext(unitName = "testAppPU")
	private EntityManager em;

	public List<Book> findBooks() {
		TypedQuery<Book> query = em.createNamedQuery("findAllBooks", Book.class);
		return query.getResultList();
	}
	
	public Book addNewBook(Book book){
		em.persist(book);
		return book;
	}

}
