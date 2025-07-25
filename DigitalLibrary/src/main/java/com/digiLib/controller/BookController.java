package com.digiLib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.digiLib.DTO.BookDTO;
import com.digiLib.entities.Book;
import com.digiLib.exception.BookAlreadyExistsException;
import com.digiLib.exception.ErrorResponse;
import com.digiLib.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
	@Autowired 
	BookService bookService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Book>>getAllBooks(){
		return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Book> addBook(@RequestBody @Valid BookDTO bookDTO) {
		return new ResponseEntity<>(bookService.addBook(bookDTO), HttpStatus.OK);
	}
	
	@ExceptionHandler(value=BookAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErrorResponse handleBookAlreadyException(BookAlreadyExistsException e) {
		return new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage());
	}
	
	
//	@PostMapping("/{id}")
//	public ResponseEntity<String> deleteBook(@PathVariable int id) {
//		bookService.deleteBook(id);
		//return new ResponseEntity<>("book deleted", HttpStatus.OK);
		
//		return new ResponseEntity<>(bookService.deleteBook(id), HttpStatus.OK);
//	}
	
//	@GetMapping("/search")
//	public List<Book> searchBooks(
//			@RequestParam(required=false) String title, 
//			@RequestParam(required=false) String author,
//			@RequestParam(required=false) String isbn,
//			@RequestParam(required=false) String category
//			){
//		return bookService.serachBooks(title, author, isbn, category);
//	}
//	
	
}
