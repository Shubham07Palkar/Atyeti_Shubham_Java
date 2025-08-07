package com.Transactional.bookStore.service;

import com.Transactional.bookStore.entity.Book;
import com.Transactional.bookStore.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepo;

    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Book addBook(Book book){
        return bookRepo.save(book);
    }

    public Book getBook(String isbn){
        return bookRepo.findById(isbn).orElseThrow(()-> new RuntimeException("Book Not Found"));
    }

    public Book updatePrice(String isbn, double newPrice){
        Book book = getBook(isbn);
        book.setPrice(newPrice);
        return book;
    }

    public void deleteBook(String isbn){
        bookRepo.deleteById(isbn);
    }

    public List<Book> getAllBooks(){
       return bookRepo.findAll();
    }

}
