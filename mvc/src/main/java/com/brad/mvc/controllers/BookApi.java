package com.brad.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brad.mvc.models.Book;
import com.brad.mvc.services.BookService;

@RestController
public class BookApi {
	private final BookService bookService;
	public BookApi(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/api/books")
	public List<Book> index() {
		return bookService.allBooks();
	}
	
	@PostMapping(value="/api/books")
	public Book create(
				@RequestParam("title") String title,
				@RequestParam("description") String desc,
				@RequestParam("language") String lang,
				@RequestParam("pages") Integer numOfPages) {
		Book book = new Book(title, desc, lang, numOfPages);
		return bookService.createBook(book);
	}
	
	@RequestMapping(value="/api/books/{id}")
	public Book showBook(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		return book;
	}
	
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
	public Book update(
				@PathVariable("id") Long id,
				@RequestParam(value="title") String title,
				@RequestParam(value="description") String desc,
				@RequestParam(value="language") String lang,
				@RequestParam(value="pages") Integer numOfPages) {
		Book book = showBook(id);
		book.setTitle(title);
		book.setDescription(desc);
		book.setLanguage(lang);
		book.setNumberOfPages(numOfPages);
		bookService.updateBook(book);
		return book;
	}
	
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
	public void destroy(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}
}
