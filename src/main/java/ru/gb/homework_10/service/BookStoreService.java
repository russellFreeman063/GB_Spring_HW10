package ru.gb.homework_10.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.homework_10.aspect.TrackUserAction;
import ru.gb.homework_10.model.Book;
import ru.gb.homework_10.repository.BookStoreRepository;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookStoreService {

    private BookStoreRepository repository;

    @TrackUserAction
    public List<Book> getAllBooks(){
        return repository.findAll();
    }

    public Optional<Book> getBookById(Long id){
        return repository.findById(id);
    }

    @TrackUserAction
    public void createBook(Book book){
        repository.save(book);
    }


    public Book updateBook(Long id, Book bookDetails){
        Optional<Book> optionalBook = repository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setPublicationYear(bookDetails.getPublicationYear());
            book.setPrice(bookDetails.getPrice());
            book.setQuantity(bookDetails.getQuantity());
            return repository.save(book);
        } else {
            throw new IllegalArgumentException("Book not found with id: " + id);
        }
    }

    public void deleteBook(Long id){
        repository.deleteById(id);
    }

}
