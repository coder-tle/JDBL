package com.digiLib.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digiLib.entities.Book;

public interface BookRepository extends JpaRepository<Book,Integer>{
	List<Book> findByCategoryIgnoreCase(String category);
	List<Book> findByTitleContainingIgnoreCase(String keyword);
	Optional<Book> findByIsbn(String isbn);
	List<Book> findByAuthorIgnoreCase(String author);
}
