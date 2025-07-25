package com.digiLib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digiLib.service.BorrowService;

@RestController 
@RequestMapping("api/v1/borrow")
public class BorrowController {
	
	@Autowired 
	private BorrowService borrowService;
	
	@PostMapping("/{booId}/user/{userId}")
	public void borrowBook(@PathVariable(name="booId") int bookId, @PathVariable(name="userId") int userId) {
		// if name does not match then you can map 
		borrowService.borrowBook(bookId, userId);
	}
	
	@PostMapping("/return/{bookId}/user/{userId}")
	public void returnBook(@PathVariable(name="bookId") int bookId, @PathVariable(name="userId") int userId) {
		// if name does not match then you can map 
		borrowService.returnBook(bookId, userId);
	}
	
	@GetMapping("/history/{userId}")
	public void getBorrowHistory(@PathVariable(name="userId") int userId) {
		
	}
	
	
}
