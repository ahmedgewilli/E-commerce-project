package com.example.bookstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Bookstore")
public class Bookstore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="IDvalue")
    private int id;
    @Column(name = "Titleofbook")
    String title;
    @Column(name = "Quantity")
    int quantity;
    @Column(name = "Authorname")
    String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title   ;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
