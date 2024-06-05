package ru.gb.homework_10;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.homework_10.model.Book;
import ru.gb.homework_10.repository.BookStoreRepository;
import ru.gb.homework_10.service.BookStoreService;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@Transactional
class BookServiceIntegrationTest {

    @Autowired
    private BookStoreService service;

    @Autowired
    private BookStoreRepository repository;


    @Test
    public void createBookTest() {

        // Блок предусловия
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Test Title");
        book.setAuthor("Test Author");
        book.setPublicationYear(2000);
        book.setPrice(1000.00);
        book.setQuantity(1);

        // Блок действия
        service.createBook(book);

        // Блок проверки
        assertNotNull(book);
        assertEquals("Test Title", book.getTitle());
        assertNotNull(book.getId());

    }


    @Test
    void getAllBooksTest() {

        // Блок предусловия
        Book book1 = new Book();
        book1.setId(1L);
        book1.setTitle("Test Title1");
        book1.setAuthor("Test Author1");
        book1.setPublicationYear(2000);
        book1.setPrice(1000.00);
        book1.setQuantity(1);
        repository.save(book1);

        Book book2 = new Book();
        book2.setId(2L);
        book2.setTitle("Test Title2");
        book2.setAuthor("Test Author2");
        book2.setPublicationYear(1990);
        book2.setPrice(2000.00);
        book2.setQuantity(2);
        repository.save(book2);

        // Блок действия
        List<Book> books = service.getAllBooks();

        // Блок проверки
        assertEquals(2, books.size());
    }

}

