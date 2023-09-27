package com.brad.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brad.mvc.models.Book;
import com.brad.mvc.repositories.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
//	create a book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
//	read about a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
//	updates a book
	public Book updateBook(Book b) {
		return bookRepository.save(b);
	}
	
	public List<Book> booksContaining(String search) {
		return bookRepository.findByDescriptionContaining(search);
	}
	
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
}
