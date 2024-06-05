package ru.gb.homework_10.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.homework_10.model.Book;
import ru.gb.homework_10.service.BookStoreService;


@Controller
@AllArgsConstructor
public class BookStoreController {

    private final BookStoreService service;

    @GetMapping()
    public String getIndex() {
        return "index";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "about";
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", service.getAllBooks());
        return "books";
    }

    @PostMapping("/books")
    public String addBook(Model model, Book book) {
        service.createBook(book);
        model.addAttribute("books", service.getAllBooks());
        return "books";
    }


}
