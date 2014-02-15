package com.wooboat.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@NamedQuery(name = "findAllBooks", query = "SELECT b FROM Book b")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull(message = "{com.wooboat.entity.Book.title.message}")
	@Size(min = 1, max = 200, message = "{com.wooboat.entity.Book.title.message}")
	private String title;
	private Float price;
	@Size(min = 10, max = 2000, message = "{com.wooboat.entity.Book.description.message}")
	private String description;
	@Size(min = 13, max = 13, message = "{com.wooboat.entity.Book.isbn.null.message}")
	@Pattern(regexp = "^S-\\d{11}", message = "{com.wooboat.entity.Book.isbn.pattern.message}")
	private String isbn;

	public Book() {
	}

	public Book(final String title, final Float price,
			final String description, final String isbn) {
		super();
		this.title = title;
		this.price = price;
		this.description = description;
		this.isbn = isbn;
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(final String isbn) {
		this.isbn = isbn;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(final Float price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Book other = (Book) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", price=" + price
				+ ", isbn=" + isbn + "]";
	}

}
