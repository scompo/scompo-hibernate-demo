package it.scompo.scompohibernatedemo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import it.scompo.scompohibernatedemo.dto.IAuthorDto;
import it.scompo.scompohibernatedemo.dto.IBookDto;
import it.scompo.scompohibernatedemo.dto.Result;
import it.scompo.scompohibernatedemo.model.Author;
import it.scompo.scompohibernatedemo.model.Book;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthorController {

	private static final Logger logger = LogManager
			.getLogger(AuthorController.class);
	
	@Autowired
	IAuthorDto authorDto;
	@Autowired
	IBookDto bookDto;
	
	@RequestMapping(value="/author",
					method=RequestMethod.GET,
					produces="application/json")
	public @ResponseBody Author getAuthor(@RequestParam Integer id){
		logger.debug("/author called with GET");
		logger.debug("got = " + id.getClass().getName() + id);
		return authorDto.findOne(id);
	}
	
	@RequestMapping(value="/author",
			method=RequestMethod.POST,
			produces="application/json",
			consumes="application/json")
	public @ResponseBody Result createAuthor(@RequestParam Author author){
	logger.debug("/author called with GET");
	logger.debug("got = " + author.getClass().getName() + author);
	authorDto.create(author); 
	return new Result(Result.OK);
	}
	
	@RequestMapping(value="/author",
					method=RequestMethod.PUT,
					produces="application/json",
					consumes="application/json")
	public @ResponseBody Result updateAuthor(@RequestParam Author author){
		logger.debug("/author called with GET");
		logger.debug("got = " + author.getClass().getName() + author);
		Author resultAuthor = authorDto.update(author);
		Result res = new Result(Result.OK, resultAuthor);
		logger.debug(res);
		return res ;
	}
	
	@RequestMapping(value="/authors",
					method=RequestMethod.GET,
					produces="application/json")
	public @ResponseBody List<Author> getAllAuthors(){
		logger.debug("/authors called with GET");
		List<Author> res = authorDto.findAll();
		return res ;
	}
	
	@RequestMapping(value="/authortest",
			method=RequestMethod.GET,
			produces="application/json")
	public @ResponseBody Author getTestAuthors(){
	logger.debug("/authortest called with GET");
	Author author1 = new Author("Mauro", "Scomparin", 28);
	authorDto.create(author1);
	Collection<Author> authors  = authorDto.findAll();
	logger.debug(authors);
	Book book1 = new Book("123123123", "testing spring");
	book1.setAuthors(authors);
	bookDto.create(book1);
	logger.debug(book1);
	Book book2 = new Book("456456456", "testing spring2");
	book2.setAuthors(authors);
	bookDto.create(book2);
	logger.debug(book2);
	Collection<Book> books = bookDto.findAll();
	logger.debug(books);
	author1.setBooks(books);
	logger.debug(author1);
	authorDto.update(author1);
	Author res = authorDto.findAll().get(0);
	logger.debug(res);
	return res;
	}
	
	
}
