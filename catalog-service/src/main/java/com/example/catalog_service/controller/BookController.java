package com.example.catalog_service.controller;

import com.example.catalog_service.model.Book;
import com.example.catalog_service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        logger.info("Request received to get all books-testrolloutnew123456789");
        List<Book> books = bookService.getAllBooks();
        logger.info("Returning {} books", books.size());
        return books;
    }

    @GetMapping("/acceptance")
    public ResponseEntity<String> acceptanceTest() {

        logger.info("Acceptance test endpoint hit.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("fail");
        //return ResponseEntity.ok("success");
    }


}