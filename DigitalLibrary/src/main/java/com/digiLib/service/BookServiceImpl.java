package com.digiLib.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.digiLib.DTO.BookDTO;
import com.digiLib.entities.Book;
import com.digiLib.exception.BookAlreadyExistsException;
import com.digiLib.exception.BookNotFoundException;
import com.digiLib.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookRepository bookRepo;

	@Override
	@Cacheable("books")
//	@Cacheable(value="books", key="#id")
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}

	@Override
	public Book addBook(BookDTO bookDTO) {
		Optional<Book> existingBook = bookRepo.findByIsbn(bookDTO.getIsbn());
		if(existingBook.isPresent()) {
			throw new BookAlreadyExistsException("Book already present");
		}
		Book b = new Book().builder()
				.title(bookDTO.getTitle())
				.author(bookDTO.getAuthor())
				.isbn(bookDTO.getIsbn())
				.category(bookDTO.getCategory())
				.build();
		// create instance of book from bookDTO
		return bookRepo.save(b);
	}

	@Override
	public String deleteBook(int id) {
		// add a log  message
		String result = "book not found with id "+id;
//		try {
			// deleteById() does not throws exceptions
		if(bookRepo.findById(id).isPresent()) {
			bookRepo.deleteById(id);
			result = "book deleted with id "+id;
			return result;
		}
		else {
			throw new BookNotFoundException(result);
		}

	}
//
	@Override
	public Book updateBook(int id, BookDTO book) {
		Optional<Book> result = bookRepo.findById(id);
		
		if(result.isPresent()) {
			result.get().setTitle(book.getTitle());
			result.get().setAuthor(book.getAuthor());
			result.get().setAvailable(true);
			result.get().setCategory(book.getCategory());
			result.get().setIsbn(book.getIsbn());
			return bookRepo.save(result.get());
			//result = bookRepo.save(result.get().getTitle(book.getTitle()).geauthor(book.getAuthor()).available(true).category(book.getCategory()).isbn(book.getIsbn()).build());
		}
		return result.get();
//		if(bookRepo.findById(id).isPresent()) {
//			bookRepo.deleteById(id);
//		}
//		// create a new book & add to it. 
//		return new Book();
	}
	
//	@Override 
//	public List<Book> searchBooks(String title, String author, String isbn, String category){
//		if(isbn!=null && !isbn.isEmpty()) {
//			return bookRepo.findByIsbn(isbn).map(List::of).orElse(Collections.emptyList()); //??
//			
//		}
//		if(title!=null && !title.isEmpty()) {
//			return bookRepo.findByTitleContainingIgnoreCase(title);
//		}
//		if(author!=null && !author.isEmpty()) {
//			return bookRepo.findByAuthoIgnoreCase(author);
//		}
//		if(title!=category && !category.isEmpty()) {
//			return bookRepo.findByCategoryIgnoreCase(category);
//		}
//		return Collections.emptyList();
//		
//		
//	}

}
