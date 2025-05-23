package com.example.bookstore.repository;

import com.example.bookstore.entity.Bookstore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface RepoBook extends JpaRepository<Bookstore,Integer> {
}
