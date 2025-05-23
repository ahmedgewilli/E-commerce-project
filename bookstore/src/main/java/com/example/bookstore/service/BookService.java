package com.example.bookstore.service;

import com.example.bookstore.entity.Bookstore;
import com.example.bookstore.repository.RepoBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final RepoBook r;
    @Autowired
    public BookService(RepoBook r) {
        this.r = r;
    }

    public Optional<Bookstore> getUser(Integer id) {
    return r.findById(id);
    }

    public Optional<Bookstore> save(Bookstore bookstore) {
        return Optional.of(r.save(bookstore));
    }
    public List<Bookstore> Getall() {
        return r.findAll();
    }
}
