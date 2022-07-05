package org.example.dao;

import org.example.model.Book;

import java.util.List;

public interface BookDao {

    List<Book> list();

    Book getById(int id);

    void create(Book book);

    void update(int id, Book book);

    void delete(int id);
}
