package com.example.springdatajdbcDemo1.dao;

import com.example.springdatajdbcDemo1.entity.IssueBook;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IssueBookRowMapper implements RowMapper<IssueBook> {


    @Override
    public IssueBook mapRow(ResultSet rs, int rowNum) throws SQLException {
        IssueBook issueBook = new IssueBook();
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
        issueBook.setIssueId(rs.getLong("issue_id"));
        issueBook.setBookId(rs.getLong("book_id"));
        issueBook.setIssuedDate(rs.getDate("issued_date").toLocalDate());
        issueBook.setExpectedSubmitDate(rs.getDate("expected_submit_date").toLocalDate());
        issueBook.setActualSubmitDate(rs.getDate("actual_submit_date").toLocalDate());
        issueBook.setIssueDays(rs.getInt("issue_days"));
        issueBook.setTotalFee(rs.getDouble("total_fee"));
        issueBook.setTotalPenalty(rs.getDouble("total_penalty"));
        issueBook.setReturned(rs.getBoolean("returned"));




        return issueBook;
    }
}
