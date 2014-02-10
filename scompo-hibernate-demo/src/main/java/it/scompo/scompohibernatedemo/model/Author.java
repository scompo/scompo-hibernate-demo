package it.scompo.scompohibernatedemo.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Implements the Author Model.
 * 
 * @author mscomparin
 * @version 1.0
 */
@Entity
public class Author implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String surname;
	
	private Integer age;
	
	@ManyToMany
	private Collection<Book> books;
	
	
	public Author(){
		super();
	}
	
	/**
	 * @param id
	 * @param name
	 * @param surname
	 * @param age
	 */
	public Author(/*Integer id,*/ String name, String surname, Integer age) {
		super();
		//this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
	/**
	 * @return the books
	 */
	@ManyToMany
	public Collection<Book> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(Collection<Book> books) {
		this.books = books;
	}

	/**
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	*/
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Author other = (Author) obj;
		if (age == null) {
			if (other.age != null) {
				return false;
			}
		} else if (!age.equals(other.age)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (surname == null) {
			if (other.surname != null) {
				return false;
			}
		} else if (!surname.equals(other.surname)) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return String.format("Author [id=%s, name=%s, surname=%s, age=%s]", id,
				name, surname, age);
	}
	
}
