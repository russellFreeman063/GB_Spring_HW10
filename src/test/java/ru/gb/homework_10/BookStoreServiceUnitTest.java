package ru.gb.homework_10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.gb.homework_10.model.Book;
import ru.gb.homework_10.repository.BookStoreRepository;
import ru.gb.homework_10.service.BookStoreService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class BookStoreServiceUnitTest {

    @InjectMocks
    private BookStoreService service;

    @Mock
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

        when(repository.save(book)).thenReturn(book);

        // Блок действия
        service.createBook(book);

        // Блок проверки
        verify(repository, times(1)).save(book);

    }
    @Test
    public void getAllBooksTest() {

        // Блок предусловия
        Book book1 = new Book();
        book1.setId(1L);
        book1.setTitle("Test Title1");
        book1.setAuthor("Test Author1");
        book1.setPublicationYear(2000);
        book1.setPrice(1000.00);
        book1.setQuantity(1);

        Book book2 = new Book();
        book2.setId(2L);
        book2.setTitle("Test Title2");
        book2.setAuthor("Test Author2");
        book2.setPublicationYear(1990);
        book2.setPrice(2000.00);
        book2.setQuantity(2);

        List<Book> books = Arrays.asList(book1, book2);
        when(repository.findAll()).thenReturn(books);

        // Блок действия
        List<Book> booksTest = service.getAllBooks();

        // Блок проверки
        assertEquals(2, booksTest.size());
        verify(repository, times(1)).findAll();

    }

}
