package org.example.service;

import org.example.model.Book;

import java.util.List;

public interface BookService {

    List<Book> listBooks();

    void createBook(Book book);

    Book getBook(int id);

    void deleteBook(int id);

    void updateBook(int id, Book book);
}
