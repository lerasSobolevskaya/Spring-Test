package org.example.service.impl;

import org.example.dao.BookDao;
import org.example.model.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> listBooks() {
        return bookDao.list();
    }

    @Override
    public void createBook(Book book) {
        bookDao.create(book);
    }

    @Override
    public Book getBook(int id) {
        return bookDao.getById(id);
    }

    @Override
    public void deleteBook(int id) {
        bookDao.delete(id);
    }

    @Override
    public void updateBook(int id, Book book) {
        bookDao.update(id, book);
    }
}
