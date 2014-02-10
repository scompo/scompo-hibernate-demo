package it.scompo.scompohibernatedemo.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Implements the book object.
 * Uses annotation for hibernate.
 * 
 * @author mscomparin
 * @version 1.0
 */
@Entity
public class Book implements Serializable{
	
	/**
	 * serialVersionUID 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Isbn of the book.
	 */
	@Id
	@GeneratedValue
	private Integer id;
	
	private String isbn;
	
	/**
	 * The title.
	 */
	private String title;
	
	/**
	 * A Collection of books.
	 */
	@ManyToMany(mappedBy="books")
	private Collection<Author> authors;

	public Book() {
		super();
	}
	
	/**
	 * @param isbn
	 * @param title
	 */
	public Book(String isbn, String title) {
		super();
		this.isbn = isbn;
		this.title = title;
	}

	/**
	 * @return the authors
	 */
	public Collection<Author> getAuthors() {
		return authors;
	}

	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(Collection<Author> authors) {
		this.authors = authors;
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
		return String.format("Book [isbn=%s, title=%s]", isbn, title);
	}
	
	
	
}
