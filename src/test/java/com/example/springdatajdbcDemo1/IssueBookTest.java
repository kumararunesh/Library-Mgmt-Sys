package com.example.springdatajdbcDemo1;

import com.example.springdatajdbcDemo1.dao.IssueBookDao;
import com.example.springdatajdbcDemo1.entity.IssueBook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class IssueBookTest {

    @Autowired
    private IssueBookDao issueBookDao;

    @Test
    public void saveIssuedBookTest()
    {

//        public IssueBook(long bookId, long userId, LocalDate issuedDate,
//            java.time.LocalDate expectedSubmitDate, java.time.LocalDate actualSubmitDate,
//        int issueDays, double totalFee, double totalPenalty, boolean returned)


        issueBookDao.saveIssueBook(new IssueBook(2,2,LocalDate.now(),LocalDate.now().plusDays(10),
               LocalDate.now().plusDays(16), 10,100,100,false));
    }

    @Test
    public void getIssueBookByIdTest()
    {
        IssueBook issueBook = issueBookDao.getIssueBook(1);
    }

    @Test
    public void returnedBookTest()
    {
        issueBookDao.returnedBook(1,new IssueBook(2,2,LocalDate.now(),LocalDate.now().plusDays(10),
                LocalDate.now().plusDays(16), 10,100,200,false));
    }
}
