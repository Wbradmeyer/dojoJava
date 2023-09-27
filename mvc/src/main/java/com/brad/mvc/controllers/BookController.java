package com.brad.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.brad.mvc.models.Book;
import com.brad.mvc.services.BookService;

@Controller
public class BookController {
	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		
		return "index.jsp";
	}
	
	@GetMapping("/books/{bookId}")
	public String showOneBook(@PathVariable("bookId") Long bookId, Model model) {
		Book book = bookService.findBook(bookId);
		model.addAttribute("book", book);
		
		return "show.jsp";
	}
}
