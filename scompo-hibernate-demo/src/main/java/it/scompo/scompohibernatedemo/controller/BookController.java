package it.scompo.scompohibernatedemo.controller;

import java.util.List;

import it.scompo.scompohibernatedemo.dto.IBookDto;
import it.scompo.scompohibernatedemo.model.Book;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Book controller.
 * 
 * @author mscomparin
 * @version 1.0
 */

@Controller
public class BookController {
	
	@Autowired
	IBookDto bookDto;

	private static final Logger logger = LogManager
			.getLogger(BookController.class);
	
	@RequestMapping(value="/book", 
					method= RequestMethod.GET,
					produces = "application/json")
	public @ResponseBody Book getBook(@RequestParam Integer id){
		logger.debug("/book called with GET");
		logger.debug("got = " + id.getClass().getName() + id);
		return bookDto.findOne(id);
	}
	
	@RequestMapping(value="/book", 
			method= RequestMethod.POST,
			produces="application/json",
			consumes="application/json")
	public @ResponseBody String saveBook(@RequestBody Book book) {
		logger.debug("/book called with POST");
		logger.debug("got = " + book.getClass().getName() + book);
		bookDto.create(book);
		logger.debug("book created");
		return "Created";
	}
	
	@RequestMapping(value="/book", 
			method= RequestMethod.PUT,
			produces="application/json",
			consumes="application/json")
	public @ResponseBody Book updateBook(@RequestBody Book book) {
		logger.debug("/book called with PUT");
		logger.debug("got = " + book.getClass().getName() + book);
		Book bookResult = bookDto.update(book);
		logger.debug("book updated: "+bookResult);
		return bookResult;
	}

	@RequestMapping(value="/book", 
			method= RequestMethod.DELETE,
			produces="application/json",
			consumes="application/json")
	public @ResponseBody String deleteBook(@RequestBody Book book) {
		logger.debug("/book called with DELETE");
		logger.debug("got = " + book.getClass().getName() + book);
		bookDto.delete(book);
		logger.debug("book deleted");
		return "ok?";
	}
	
	@RequestMapping(value="/books",
					method= RequestMethod.GET,
					produces="application/json")
	public @ResponseBody List<Book> getAllBooks() {
		logger.debug("/books called with GET");
		return bookDto.findAll();
		
	}
		
	@RequestMapping(value="/booktest",
			method= RequestMethod.GET,
			produces="application/json")
	public @ResponseBody Book getTestBook() {
	logger.debug("/booktest called with GET");
	Book res = new Book("123123123", "testing spring");
	return res;

}
}
