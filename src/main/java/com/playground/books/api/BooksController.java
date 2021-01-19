package com.playground.books.api;

import com.playground.books.domain.Book;
import com.playground.books.domain.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping( "/api/books")
public class BooksController {

    @Autowired
    private BookService service;

    @GetMapping()
    public Iterable<Book> get() {
        return service.get();
    }

    @GetMapping("/{id}")
    public Optional<Book> get(@PathVariable("id") Long id) {
        return service.getBookById(id);
    }

    @GetMapping("/tipo/{tipo}")
    public Iterable<Book> get(@PathVariable("tipo") String tipo) {
        return service.getBookByType(tipo);
    }

    @PostMapping()
    public String post(@RequestBody Book book) {
        Book createdBook = service.create(book);
        return "Book has been created: " + createdBook.getId();
    }

    @PutMapping("/{id}")
    public String update(@RequestBody Book book, @PathVariable("id") Long id) {
        Book updatedBook = service.update(book, id);
        return "Book has been updated: " + updatedBook.getId();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return "Book has been deleted";
    }

}
