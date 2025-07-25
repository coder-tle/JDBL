package com.digiLib.entities;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@Entity 
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BorrowRecord
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="user_id") // what does this ManyToOne mean ? I mean which in these two table which is being mapped to which ? 
	// like which is part of many & which is part of one ? 
	private User user;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	private Book book;
	
	private LocalDate borrowDate;
	
	private LocalDate returnDate;
	
	private boolean returned;

}
