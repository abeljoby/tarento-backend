package com.abel.library.controller;

import com.abel.library.model.Book;
import com.abel.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository repo;

    @PostMapping
    public String create(@RequestBody Book book) {
        repo.save(book);
        return "Book added successfully!";
    }

    @GetMapping
    public List<Book> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{bid}")
    public Book getOne(@PathVariable int bid) {
        return repo.findById(bid);
    }

    @PutMapping("/{bid}")
    public String update(@PathVariable int bid, @RequestBody Book book) {
        repo.update(bid, book);
        return "Book updated!";
    }

    @DeleteMapping("/{bid}")
    public String delete(@PathVariable int bid) {
        repo.delete(bid);
        return "Book deleted!";
    }
}
