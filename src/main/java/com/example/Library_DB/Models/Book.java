package com.example.Library_DB.Models;

import jakarta.persistence.*;

@Entity
@Table(name="Books") // if table name is not specify it will take class name by default
public class Book {
@Id  // must write , to represent primary key in table
    private int id;
// by default column names in my sql are same as attribute names in this class
    private String name;
    private int pages;
    private String author;

    // book is as child of student class
    @ManyToOne
    @JoinColumn
    private Student student; // connecting student entity

    public Book() {
    }

    public Book(int id, String name, int pages, String author) {
        this.id = id;
        this.name = name;
        this.pages = pages;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setAuthor(String author) {
        this.author = author;
    }
}
