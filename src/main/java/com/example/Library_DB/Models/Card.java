package com.example.Library_DB.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Card")
// lombok Maven library
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Card {     // this is as child table of student

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int fine;
    private String expiry;

    // connecting to the parent table (student)
    //to add foreign key column in child table
    @OneToOne   // relationship
    @JoinColumn // by default, it keeps the Id(primary key) as foreign key
    public Student student;    // connects the student entity

}
