package it.scompo.scompohibernatedemo.dao.implemented;

import it.scompo.scompohibernatedemo.dao.IAuthorDao;
import it.scompo.scompohibernatedemo.dao.common.AbstractHibernateDao;
import it.scompo.scompohibernatedemo.model.Author;

import org.springframework.stereotype.Repository;

@Repository
public class AuthorDao extends AbstractHibernateDao<Author> implements IAuthorDao{

	public AuthorDao(){
		super();
		setClasss(Author.class);
	}
}
