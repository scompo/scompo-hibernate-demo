package it.scompo.scompohibernatedemo.dto.implemented;

import it.scompo.scompohibernatedemo.dao.IBookDao;
import it.scompo.scompohibernatedemo.dao.common.IOperations;
import it.scompo.scompohibernatedemo.dto.IBookDto;
import it.scompo.scompohibernatedemo.dto.common.AbstractDto;
import it.scompo.scompohibernatedemo.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookDto extends AbstractDto<Book> implements IBookDto{
	
	@Autowired
	private IBookDao dao;
	
	public BookDto(){
		super();
	}
	
	@Override
	protected IOperations<Book> getDao() {
		// TODO Auto-generated method stub
		return dao;
	}

}
