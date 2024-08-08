package com.example.library.service;

import com.example.library.dto.BorrowingRecordDTO;

public interface BorrowingRecordService {
    BorrowingRecordDTO borrowBook(Long bookId, Long patronId);
    BorrowingRecordDTO returnBook(Long bookId, Long patronId);
}
