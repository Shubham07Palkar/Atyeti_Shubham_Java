package com.Transactional.bookStore.controller;

import com.Transactional.bookStore.entity.Book;
import com.Transactional.bookStore.service.BookService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping
    @Transactional
    public Book create(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("/{isbn}")
    public Book read(@PathVariable String isbn){
        return bookService.getBook(isbn);
    }


    @PutMapping("/{isbn}/price")
    public Book update(@PathVariable String isbn, @RequestParam double price){
        return bookService.updatePrice(isbn, price);
    }

    @DeleteMapping("/{isbn}")
    public String delete(@PathVariable String isbn){
        bookService.deleteBook(isbn);
        return "Deleted Book with isbn: "+isbn;
    }

    @GetMapping
    public List<Book> listOfBooks(){
        return bookService.getAllBooks();
    }

}
