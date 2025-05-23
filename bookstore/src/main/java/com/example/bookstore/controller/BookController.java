package com.example.bookstore.controller;

import com.example.bookstore.entity.Bookstore;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
    @RequestMapping("/Bookstore")
@CrossOrigin
public class BookController {
    private final BookService b;
    @Autowired
    public BookController(BookService b) {
        this.b = b;
    }
        @GetMapping("/IDvalue")
        public ResponseEntity<Bookstore> getBookById(@RequestParam Integer ID) {
            Optional<Bookstore> bookstore = b .getUser(ID);
            return bookstore.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }


    @PostMapping("/ID")
    public Optional<Bookstore> save(@RequestBody Bookstore bookstore) {
        return b.save(bookstore);
    }
    @GetMapping("/getall")
    public List<Bookstore> Getall() {
        return b.Getall();
    }
}
