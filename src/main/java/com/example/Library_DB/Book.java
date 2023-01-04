package com.example.Library_DB;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="book_table") // if table name is not specify it will take class name by default
public class Book {
@Id  // must write , to represent primary key in table
    private int id;
// by default column names in my sql are same as attribute names in this class
    private String bookName;
    private int pages;
    private String author;

    public Book() {
    }

    public Book(int bookId, String bookName, int pages, String author) {
        this.id = bookId;
        this.bookName = bookName;
        this.pages = pages;
        this.author = author;
    }

    public int getBookId() {
        return id;
    }

    public void setBookId(int bookId) {
        this.id = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String auther) {
        this.author = auther;
    }
}
