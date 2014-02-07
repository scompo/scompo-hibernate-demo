package it.scompo.scompohibernatedemo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Implements the book object.
 * Uses annotation for hybernate.
 * 
 * @author mscomparin
 * @version 1.0
 */
@Entity
@Table(name= "Book")
public class Book implements Serializable{
	
	/**
	 * serialVersionUID 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Isbn of the book.
	 */
	@Id
	@Column(name="isbn")
	private String isbn;
	
	/**
	 * Author of the book.
	 */
	@Column(name="author")
	private String author;
	
	/**
	 * The title.
	 */
	@Column(name="title")
	private String title;

	public Book() {
		super();
	}
	
	/**
	 * @param isbn
	 * @param author
	 * @param title
	 */
	public Book(String isbn, String author, String title) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.title = title;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Hash code for Book.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/**
	 * Equals method.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	/**
	 * Writes the content of the Book as a string like this.
	 * [isbn=%s, author=%s, title=%s]
	 */
	@Override
	public String toString() {
		return String.format("Book [isbn=%s, author=%s, title=%s]", 
				isbn, author, title);
	}
	
	
	
}
