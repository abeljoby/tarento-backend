package com.abel.library.repository;

import com.abel.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Book mapRow(ResultSet rs, int rowNum) throws java.sql.SQLException {
        Book b = new Book();
        b.setId(rs.getString("bid"));
        b.setTitle(rs.getString("title"));
        b.setAuthor(rs.getString("author"));
        b.setGenre(rs.getString("genre"));
        b.setPublishedYear(rs.getString("published_year"));
        b.setStatus(rs.getString("status"));
        return b;
    }

    public int save(Book book) {
        return jdbcTemplate.update(
            "INSERT INTO book (bid, title, author, genre, published_year, status) VALUES (?, ?, ?, ?, ?, ?)",
            book.getId(), book.getTitle(), book.getAuthor(), book.getGenre(), book.getPublishedYear(), book.getStatus()
        );
    }

    public List<Book> findAll() {
        return jdbcTemplate.query("SELECT * FROM book", this::mapRow);
    }

    public Book findById(int bid) {
        return jdbcTemplate.queryForObject("SELECT * FROM book WHERE bid = ?", this::mapRow, bid);
    }

    public int update(int bid, Book book) {
        String bidStr = String.valueOf(bid);
        return jdbcTemplate.update(
            "UPDATE book SET title=?, author=?, genre=?, published_year=?, status=? WHERE bid=?",
            book.getTitle(), book.getAuthor(), book.getGenre(), book.getPublishedYear(), book.getStatus(), bidStr
        );
    }

    public int delete(int bid) {
        return jdbcTemplate.update("DELETE FROM book WHERE bid = ?", bid);
    }
}
