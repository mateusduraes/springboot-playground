package com.playground.books.api;

import com.playground.books.domain.Book;
import com.playground.books.domain.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping( "/api/books")
public class BooksController {

    @Autowired
    private BookService service;

    @GetMapping()
    public ResponseEntity<Iterable<Book>> get() {
        return ResponseEntity.ok(service.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> get(@PathVariable("id") Long id) {

        Optional<Book> book = service.getBookById(id);
        return book
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Book>> get(@PathVariable("tipo") String tipo) {
        List<Book> books = service.getBookByType(tipo);
        return books.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(books);
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
