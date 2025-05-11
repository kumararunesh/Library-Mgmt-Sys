package com.example.springdatajdbcDemo1.dao;

import com.example.springdatajdbcDemo1.entity.IssueBook;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class IssueBookDao {

    private JdbcTemplate jdbcTemplate;

    public IssueBookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
//    issue_id bigint primary key auto_increment,
//    book_id bigint,
//    user_id bigint,
//    issued_date date,
//    expected_submit_date date,
//    actual_submit_date date,
//    issue_days int,
//    total_fee double,
//    total_penalty double default 0,
//    returned bool default false,
    public long saveIssueBook(IssueBook issueBook)
    {
        String query = "insert into issued_books (book_id,user_id,issued_date,expected_submit_date," +
                "actual_submit_date,issue_days,total_fee,total_penalty,returned) values (?,?,?,?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        long rowsUpdated = jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                    ps.setLong(1, issueBook.getBookId());
                    ps.setLong(2, issueBook.getUserId());
                    ps.setDate(3, Date.valueOf(issueBook.getIssuedDate()));
                    ps.setDate(4, Date.valueOf(issueBook.getExpectedSubmitDate()));
                    ps.setDate(5, Date.valueOf(issueBook.getActualSubmitDate()));
                    ps.setInt(6, issueBook.getIssueDays());
                    ps.setDouble(7, issueBook.getTotalFee());
                    ps.setDouble(8, issueBook.getTotalPenalty());
                    ps.setBoolean(9, issueBook.isReturned());

                    return ps;
                }
                , keyHolder
        );


        System.out.println("Issue Id is "+ keyHolder.getKey().longValue());
        return keyHolder.getKey().longValue();
    }

    public IssueBook getIssueBook(long issueId)
    {
        String query = "select * from issued_books where issue_id = ?";
        IssueBook issueBook = jdbcTemplate.queryForObject(query, new IssueBookRowMapper(), issueId);
        System.out.println(issueBook);
        return issueBook;
    }

    public void returnedBook(long issueId,IssueBook issueBook)
    {
        String query = "update issued_books set actual_submit_date =?," +
                "total_penalty=?,returned = ? ,total_fee=? ,issue_days=? " +
                "where" +
                " issue_id = ?";

        int updatedRows = jdbcTemplate.update(query, Date.valueOf(issueBook.getActualSubmitDate()), issueBook.getTotalPenalty(),
                issueBook.isReturned(),issueBook.getTotalFee(),issueBook.getIssueDays() ,issueId);

        System.out.println("Rows Affected"+ updatedRows);


    }
}
