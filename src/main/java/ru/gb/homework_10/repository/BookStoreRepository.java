package ru.gb.homework_10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.homework_10.model.Book;


public interface BookStoreRepository extends JpaRepository<Book, Long> {

}
