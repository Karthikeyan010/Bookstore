package com.example.catalog_service;


import com.example.catalog_service.model.Book;
import com.example.catalog_service.repository.BookRepository;
import com.example.catalog_service.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class BookServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(BookServiceTest.class);

	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	private BookService bookService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		logger.info("Initializing BookServiceTest...");
	}

	@Test
	void getAllBooks_ShouldReturnBooksList() {
		logger.info("Running test: getAllBooks_ShouldReturnBooksList");

		// Arrange
		List<Book> mockBooks = Arrays.asList(
				new Book("Spring Boot in Action", "Craig Walls", 100),
				new Book("Effective Java", "Joshua Bloch", 200)
		);
		when(bookRepository.findAll()).thenReturn(mockBooks);
		logger.info("Mocked bookRepository to return {} books", mockBooks.size());

		// Act
		List<Book> result = bookService.getAllBooks();
		logger.info("Received {} books from bookService", result.size());

		// Assert
		assertThat(result).hasSize(2);
		assertThat(result.get(0).getTitle()).isEqualTo("Spring Boot in Action");
		assertThat(result.get(1).getTitle()).isEqualTo("Effective Java");

		// Verify interaction
		verify(bookRepository, times(1)).findAll();
		logger.info("Test getAllBooks_ShouldReturnBooksList completed successfully");
	}

	@Test
	void getAllBooks_ShouldReturnEmptyList_WhenNoBooksAvailable() {
		logger.info("Running test: getAllBooks_ShouldReturnEmptyList_WhenNoBooksAvailable");

		// Arrange
		when(bookRepository.findAll()).thenReturn(List.of());
		logger.info("Mocked bookRepository to return an empty list");

		// Act
		List<Book> result = bookService.getAllBooks();
		logger.info("Received {} books from bookService", result.size());

		// Assert
		assertThat(result).isEmpty();

		// Verify interaction
		verify(bookRepository, times(1)).findAll();
		logger.info("Test getAllBooks_ShouldReturnEmptyList_WhenNoBooksAvailable completed successfully");
	}
}
