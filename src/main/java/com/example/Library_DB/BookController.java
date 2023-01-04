package com.example.Library_DB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired

    BookService bookService;
    @PostMapping("/add_book")
    public ResponseEntity<String> createBook(@RequestBody() Book book)
    {
        String temp = bookService.createBook(book);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }
    @GetMapping("/get_book")
    public ResponseEntity<Book> getBook(@RequestParam("id") int id)
    {
        Book book = bookService.getBook(id);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }


}
