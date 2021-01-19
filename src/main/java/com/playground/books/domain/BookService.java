package com.playground.books.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BookService {

    @Autowired
    private BookRepository rep;

    public Iterable<Book> get() {
        return rep.findAll();
    }


    public Optional<Book> getBookById(Long id) {
        return rep.findById(id);
    }

    public Iterable<Book> getBookByType(String tipo) {
        return rep.findByTipo(tipo);
    }

    public Book create(Book book) {
        return rep.save(book);
    }

    public Book update(Book book, Long id) {
        Optional<Book> optionalBook = getBookById(id);
        if (optionalBook.isPresent()) {
            Book dbBook = optionalBook.get();
            dbBook.setNome(book.getNome());
            dbBook.setTipo(book.getTipo());
            rep.save(dbBook);
            return dbBook;
        }
        throw new RuntimeException("It wasn't possible to save the book");
    }

    public void deleteById(Long id) {
        Optional<Book> book = getBookById(id);
        if (book.isPresent()) {
            rep.deleteById(id);
            return;
        }
        throw new RuntimeException("It wasn't possible to delete the book");
    }
}
