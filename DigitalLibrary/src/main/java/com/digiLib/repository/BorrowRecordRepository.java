package com.digiLib.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digiLib.entities.BorrowRecord;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord,Integer>{
}
