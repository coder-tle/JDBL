package com.digiLib.service;

import java.util.List;

import com.digiLib.DTO.BookDTO;
import com.digiLib.entities.Book;

public interface BookService {
	List<Book> getAllBooks();
	Book addBook(BookDTO bookDTO);
	String deleteBook(int id);
	Book updateBook(int id, BookDTO bookDTO);
	List<Book> searchBooks(String title, String author, String isbn, String category);
}
