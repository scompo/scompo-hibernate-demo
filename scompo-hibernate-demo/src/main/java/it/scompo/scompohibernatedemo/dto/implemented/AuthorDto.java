package it.scompo.scompohibernatedemo.dto.implemented;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.scompo.scompohibernatedemo.dao.IAuthorDao;
import it.scompo.scompohibernatedemo.dao.common.IOperations;
import it.scompo.scompohibernatedemo.dto.IAuthorDto;
import it.scompo.scompohibernatedemo.dto.common.AbstractDto;
import it.scompo.scompohibernatedemo.model.Author;

@Service
public class AuthorDto extends AbstractDto<Author> implements IAuthorDto {
	
	@Autowired
	private IAuthorDao dao;
	
	public AuthorDto(){
		super();
	}
	
	@Override
	protected IOperations<Author> getDao() {
		return dao;
	}

}
