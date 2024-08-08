package com.example.library.service.impl;

import com.example.library.dto.BorrowingRecordDTO;
import com.example.library.entity.Book;
import com.example.library.entity.BorrowingRecord;
import com.example.library.entity.Patron;
import com.example.library.exception.ResourceNotFoundException;
import com.example.library.repository.BookRepository;
import com.example.library.repository.BorrowingRecordRepository;
import com.example.library.repository.PatronRepository;
import com.example.library.service.BorrowingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BorrowingRecordServiceImpl implements BorrowingRecordService {

    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PatronRepository patronRepository;

    @Override
    public BorrowingRecordDTO borrowBook(Long bookId, Long patronId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + bookId));
        Patron patron = patronRepository.findById(patronId)
                .orElseThrow(() -> new ResourceNotFoundException("Patron not found with id: " + patronId));

        BorrowingRecord borrowingRecord = new BorrowingRecord();
        borrowingRecord.setBook(book);
        borrowingRecord.setPatron(patron);
        borrowingRecord.setBorrowedDate(LocalDate.now());
        borrowingRecord = borrowingRecordRepository.save(borrowingRecord);

        return convertToDTO(borrowingRecord);
    }

    @Override
    public BorrowingRecordDTO returnBook(Long bookId, Long patronId) {
        BorrowingRecord borrowingRecord = borrowingRecordRepository.findByBookIdAndPatronId(bookId, patronId)
                .orElseThrow(() -> new ResourceNotFoundException("Borrowing record not found for book id: " + bookId + " and patron id: " + patronId));

        borrowingRecord.setReturnDate(LocalDate.now());
        borrowingRecord = borrowingRecordRepository.save(borrowingRecord);

        return convertToDTO(borrowingRecord);
    }

    private BorrowingRecordDTO convertToDTO(BorrowingRecord borrowingRecord) {
        BorrowingRecordDTO borrowingRecordDTO = new BorrowingRecordDTO();
        borrowingRecordDTO.setId(borrowingRecord.getId());
        borrowingRecordDTO.setBookId(borrowingRecord.getBook().getId());
        borrowingRecordDTO.setPatronId(borrowingRecord.getPatron().getId());
        borrowingRecordDTO.setBorrowedDate(borrowingRecord.getBorrowedDate());
        borrowingRecordDTO.setReturnDate(borrowingRecord.getReturnDate());
        return borrowingRecordDTO;
    }
}
