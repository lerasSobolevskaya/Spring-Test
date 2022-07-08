package org.example.dao.impl;

import org.example.dao.BookDao;
import org.example.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDaoImpl implements BookDao {

    public static int COUNT;

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> list() {
        String sql = "SELECT * FROM book";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public Book getById(int id) {
        String sql = "SELECT * FROM book WHERE id=?";

        return jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    @Override
    public void create(Book book) {
        String sql = "INSERT INTO book VALUES (1, ?, ?)";
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor());

    }

    @Override
    public void update(int id, Book book) {
        String sql = "UPDATE book SET title = ?, author = ? WHERE id=?";
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), id);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM book WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}
