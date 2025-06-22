package com.abel.library.model;

public class Book {
    private String bid;
    private String title;
    private String author;
    private String genre;
    private String publishedYear;
    private String status;

    // Getters
    public String getId() {
        return bid;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getGenre() {
        return genre;
    }
    public String getPublishedYear() {
        return publishedYear;
    }
    public String getStatus() {
        return status;
    }

    // Setters
    public void setId(String bid) {
        this.bid = bid;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setPublishedYear(String publishedYear) {
        this.publishedYear = publishedYear;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
