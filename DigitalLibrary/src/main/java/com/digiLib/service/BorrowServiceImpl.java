package com.digiLib.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digiLib.entities.Book;
import com.digiLib.entities.BorrowRecord;
import com.digiLib.entities.User;
import com.digiLib.repository.BookRepository;
import com.digiLib.repository.BorrowRecordRepository;
import com.digiLib.repository.UserRepository;
import com.digiLib.util.BookNotFoundException;

/*
 * 
 * @sarfaraza: this is the deps which helps to add the validation
 * 		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
 */


@Service
public class BorrowServiceImpl implements BorrowService {
	
//	@Autowired 
//	private BorrowRecordRepository borrowRecordRepo;
//	
//	@Autowired
//	private BookRepository bookRepo;
//	
//	@Autowired 
//	private UserRepository userRepo;
//	
//	
//	// user should be registered to boorw book 
//	// book should be present 
//	// 
//	
//	@Override
//	public void borrowBook(int bookId, int userId) {
//		// TODO Auto-generated method stub
//		Book book = bookRepo.findById(bookId).orElseThrow(()->new BookNotFoundException("book not found with id "+bookId));
//		
//		if(!book.isAvailable()) {
//			throw new RuntimeException("Book is already borrowed");
//		}
//		
//		User user = userRepo.findById(userId).orElseThrow(()->new RunTimeException("user not found with id: "+userId));
//		
//		BorrowRecord record = new BorrowRecord().builder().book(book).user(user).borrowDate(LocalDate.now()).returned(false).build();
////		book.builder().available(false);
//		book.setAvailable(false);
//		borrowRecordRepo.save(record);
//		bookRepo.save(book);
//
//	}
//
//	@Override
//	public void returnBook(int bookId, int userId) {
//		// TODO Auto-generated method stub
//		// check if the book belong to library ? 
//		// if the user is valid ? as we need to update the user -- brownie -- accept the book if issued 
//		BorrowRecord record = borrowRecordRepo.findByBookIdAndReturnedFalse(bookId).orEleseThrow(()->new RunTimeException("Borrow record not found"));
//		// find book record & retured status is false, like lib is excepting book to be returned
//		if(!record.getUser().getId().equals(userId)) {
//			throw new RunTimeException("this book was not borrowed by this user");
//		}
//		record.setReturnDate(LocalDate.now());
//		record.setReturned(true);
//		Book book = record.getBook();
//		book.setAvailable(true);
//		
//		borrowRecordRepo.save(record);
//		bookRepo.save(book);
//	}
//	
//	@Override
//	List<BorrowRecord> getBorrowHistory(int userId){
//		User user = new 
//		return borrowRecordRepo.findByUserId(userId);
//	}
	

}
