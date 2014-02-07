package it.scompo.scompohibernatedemo.dao.implemented;

import org.springframework.stereotype.Repository;
import it.scompo.scompohibernatedemo.dao.IBookDao;
import it.scompo.scompohibernatedemo.dao.common.AbstractHibernateDao;
import it.scompo.scompohibernatedemo.model.Book;

@Repository
public class BookDao extends AbstractHibernateDao<Book> implements IBookDao {

	public BookDao(){
		super();
		setClasss(Book.class);
	}
}
