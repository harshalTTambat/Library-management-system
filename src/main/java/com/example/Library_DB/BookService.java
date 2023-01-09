package com.example.Library_DB;

import com.example.Library_DB.Models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
     BookRepository bookRepository ;
    // mocking the interface

    public String createBook(Book book) throws Exception
    {
        // validation logic
        // checking if the book id is already present
        // we don't want to override the book if by mistake user send same id twice
        try {
            if (bookRepository.findById(book.getId()).get() == null)
            {
                throw new Exception();
            }
            return "Book is already present ";
        }
        catch (Exception e)
        {
            bookRepository.save(book);
            return "successfully added a book..";
        }

    }
    public Book getBookById(int id) throws Exception
    {

        Book book = bookRepository.findById(id).get();
        return book;
    }
    public String updateBookPages(UpdateBookPages updateBookPages)
    {
        //we need to convert (Entry DTO) into --> Entity Object
        int id = updateBookPages.getId();
        //founding book by id from repository class
        Book bookToBeUpdated = bookRepository.findById(id).get();
        //update pages from book
        bookToBeUpdated.setPages(updateBookPages.getPages());
        // now saving that updated book
        bookRepository.save(bookToBeUpdated);
        return "Updated successfully";
    }
    public List<ResponseObj> getBookNamesAndAuthors()
    {
        //from repository class we will get List of Entity
        // findAll() working like ---> select * from book_table
        List<Book> bookList = bookRepository.findAll();

        // making ans list of response obj
        List<ResponseObj> ansList = new ArrayList<>();
        // iterating over bookList
        for(Book book: bookList)
        {
            // creating object of ResponseObj class
            ResponseObj obj = new ResponseObj();
             obj.name = book.getName();
             obj.author = book.getAuthor();
            ansList.add(obj);
        }
        return ansList;
    }

}
