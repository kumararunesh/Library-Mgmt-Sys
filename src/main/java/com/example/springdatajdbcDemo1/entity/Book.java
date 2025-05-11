package com.example.springdatajdbcDemo1.entity;

public class Book {

    private long bookId;
    private String name;
    private String author;
    private String description;
    private boolean available;
    private double pricePerDay;
    private double penaltyPerDay;


    public Book() {
    }

    public Book(String name, String author, String description, boolean available, double pricePerDay, double penaltyPerDay) {

        this.name = name;
        this.author = author;
        this.description = description;
        this.available = available;
        this.pricePerDay = pricePerDay;
        this.penaltyPerDay = penaltyPerDay;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public double getPenaltyPerDay() {
        return penaltyPerDay;
    }

    public void setPenaltyPerDay(double penaltyPerDay) {
        this.penaltyPerDay = penaltyPerDay;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                ", pricePerDay=" + pricePerDay +
                ", penaltyPerDay=" + penaltyPerDay +
                '}';
    }
}
