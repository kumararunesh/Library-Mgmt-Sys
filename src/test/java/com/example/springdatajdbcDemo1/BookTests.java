package com.example.springdatajdbcDemo1;

import com.example.springdatajdbcDemo1.dao.BookDao;
import com.example.springdatajdbcDemo1.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookTests {

    @Autowired
    private BookDao bookDao;

    @Test
    public void insertBooksTest()
    {
        bookDao.saveBook(new Book("Python","Arunesh",
                "Book by Arunesh on Java",true,50,50));
    }

    @Test
    public void updateBookTest()
    {
        bookDao.updateBook(1,new Book("JavaUpdated","Arunesh",
                "Book by Arunesh on Java",true,500,500));
    }

    @Test
    public void deleteBookTest()
    {
        bookDao.deleteBook(1);
    }

    @Test
    public void getBookByIdTest()
    {
        bookDao.getBookById(2);
    }

    @Test
    public void getAllBooksTest()
    {
        bookDao.getAllBooks();
    }

    @Test
    public void searchBooksTest()
    {
        bookDao.searchBooks("Py");
    }





}
