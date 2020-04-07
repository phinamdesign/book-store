package com.vsii.bookstore.controller;

import com.vsii.bookstore.model.Book;
import com.vsii.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

import static com.vsii.bookstore.model.Write.writeExcel;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<?> getListBook() throws IOException {
        List<Book> books=(List<Book>) bookService.findAll();
        if (books.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(books,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createBook(@Valid @RequestBody Book book) throws IOException {
        bookService.save(book);
        List<Book> books=(List<Book>) bookService.findAll();
        final String excelFilePath = "D:\\VSI\\demo/books.xlsx";
        writeExcel(books, excelFilePath);
        return new ResponseEntity<>(book,HttpStatus.CREATED);
    }
}
