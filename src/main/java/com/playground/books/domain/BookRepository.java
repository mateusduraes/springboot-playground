package com.playground.books.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    Iterable<Book> findByTipo(String tipo);
}
