package com.example.springdatajdbcDemo1.dao;

import com.example.springdatajdbcDemo1.entity.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class BookDao {


    private JdbcTemplate jdbcTemplate;

    public BookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Book saveBook(Book book)
    {
        String query = "insert into books (name,author,description,available," +
                "price_per_day,penalty_per_day) " +
                "values (?,?,?,?,?,?)";

        int updatedRows = jdbcTemplate.update(
                query,
                book.getName(),
                book.getAuthor(),
                book.getDescription(),
                book.isAvailable(),
                book.getPricePerDay(),
                book.getPenaltyPerDay()
        );
        System.out.println("Updated Rows :"+ updatedRows);

        return book;
    }

    public void updateBook(long bookId,Book book)
    {
        String query = "update books set name =? ,author = ?," +
                "description = ?,available = ? ,price_per_day=?,penalty_per_day=? where book_id = ?";

        int updatedRows = jdbcTemplate.update(query,
                book.getName(),
                book.getAuthor(),
                book.getDescription(),
                book.isAvailable(),
                book.getPricePerDay(),
                book.getPenaltyPerDay(),
                bookId
        );
        System.out.println("Updated Rows :"+ updatedRows);


    }

    public void deleteBook(long bookId)
    {
        String query = "delete from books where book_id =?";
        int updatedRows = jdbcTemplate.update(query, bookId);
        System.out.println("Updated Rows :"+ updatedRows);

    }

    public Book getBookById(long bookId)
    {
        String query = "select * from books where book_id = ?";
        Book book = jdbcTemplate.queryForObject(query, new BookRowMapper(), bookId);
        System.out.println(book);
        return book;
    }

    public List<Book> getAllBooks()
    {
        String query = "select * from books";
        List<Book> books = jdbcTemplate.query(query, new BookRowMapper());
        books.forEach(System.out::println);
        return books;
    }

    public List<Book> searchBooks(String keyword)
    {
        String query = "select * from books where name like ?";
        List<Book> books = jdbcTemplate.query(query, new BookRowMapper(), "%" + keyword + "%");
        books.forEach(System.out::println);
        return books;


    }


}
