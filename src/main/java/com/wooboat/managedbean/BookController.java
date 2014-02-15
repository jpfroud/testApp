package com.wooboat.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.wooboat.ejb.BookEJB;
import com.wooboat.entity.Book;

@Named(value = "bookController")
@RequestScoped
public class BookController {
	
	private static final String BOOK_LIST = "listBook";
	@EJB
	private BookEJB bookEJB;
	private Book book = new Book();
	private List<Book> bookList = new ArrayList<>();
	
	public List<Book> getBookList(){
		bookList = bookEJB.findBooks();
		return bookList;
	}
	
	public String viewBook(){
		return BOOK_LIST;
	}
	
	public String addNewBook(){
		book = bookEJB.addNewBook(book);
		bookList = bookEJB.findBooks();
		return BOOK_LIST;
	}
	
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
}
