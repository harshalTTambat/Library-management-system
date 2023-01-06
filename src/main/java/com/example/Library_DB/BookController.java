package com.example.Library_DB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/add_book")
    public String createBook(@RequestBody() Book book) {
        // in this layer we are handling it by try catch
        try {
            return bookService.createBook(book);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/get_book")
    public Book getBook(@RequestParam("id") int id)
    {
       try {
           Book book = bookService.getBookById(id);
           return book;
       } catch (Exception e) {
           throw new RuntimeException(e);
       }

    }
    @PutMapping("/update_pages")
    public String updatePages(@RequestBody() UpdateBookPages updateBookPages)
    {
        return bookService.updateBookPages(updateBookPages);
    }
    @GetMapping("/get_bookNames_and_authors")
    public List<ResponseObj> getBookNamesAndAuthors()
    {

       List<ResponseObj> response = bookService.getBookNamesAndAuthors();
       return response;
    }
}
