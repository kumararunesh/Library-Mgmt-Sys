package com.example.springdatajdbcDemo1.entity;

import java.time.LocalDate;

public class IssueBook {

    private long issueId;
    private long bookId;
    private long userId;
    private LocalDate issuedDate;
    private LocalDate expectedSubmitDate;
    private LocalDate actualSubmitDate;
    private int issueDays;
    private double totalFee;
    private double totalPenalty=0;
    private boolean returned =false;

    public IssueBook() {
    }

    public IssueBook(long bookId, long userId, LocalDate issuedDate,
                     LocalDate expectedSubmitDate, LocalDate actualSubmitDate,
                     int issueDays, double totalFee, double totalPenalty, boolean returned) {
        this.bookId = bookId;
        this.userId = userId;
        this.issuedDate = issuedDate;
        this.expectedSubmitDate = expectedSubmitDate;
        this.actualSubmitDate = actualSubmitDate;
        this.issueDays = issueDays;
        this.totalFee = totalFee;
        this.totalPenalty = totalPenalty;
        this.returned = returned;
    }

    public long getIssueId() {
        return issueId;
    }

    public void setIssueId(long issueId) {
        this.issueId = issueId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public LocalDate getExpectedSubmitDate() {
        return expectedSubmitDate;
    }

    public void setExpectedSubmitDate(LocalDate expectedSubmitDate) {
        this.expectedSubmitDate = expectedSubmitDate;
    }

    public LocalDate getActualSubmitDate() {
        return actualSubmitDate;
    }

    public void setActualSubmitDate(LocalDate actualSubmitDate) {
        this.actualSubmitDate = actualSubmitDate;
    }

    public int getIssueDays() {
        return issueDays;
    }

    public void setIssueDays(int issueDays) {
        this.issueDays = issueDays;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public double getTotalPenalty() {
        return totalPenalty;
    }

    public void setTotalPenalty(double totalPenalty) {
        this.totalPenalty = totalPenalty;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    @Override
    public String toString() {
        return "IssueBook{" +
                "issueId=" + issueId +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", issuedDate=" + issuedDate +
                ", expectedSubmitDate=" + expectedSubmitDate +
                ", actualSubmitDate=" + actualSubmitDate +
                ", issueDays=" + issueDays +
                ", totalFee=" + totalFee +
                ", totalPenalty=" + totalPenalty +
                ", returned=" + returned +
                '}';
    }
}
