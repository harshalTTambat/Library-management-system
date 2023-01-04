package com.example.Library_DB;

import jakarta.persistence.*;

@Entity
@Table(name="user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
       // for each column it will keep separate count, and auto increment it
    private int id;
    private String name;
    private int age;
    private String email;

    public User() {
    }

    public User(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
