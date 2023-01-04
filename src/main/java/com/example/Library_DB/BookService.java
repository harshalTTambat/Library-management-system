package com.example.Library_DB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
     BookRepository bookRepository;

    public String createBook(Book book)
    {

        bookRepository.save(book);
        return "Book added successfully";
    }
    public Book getBook(int id)
    {
        return bookRepository.getReferenceById(id);

    }


}
