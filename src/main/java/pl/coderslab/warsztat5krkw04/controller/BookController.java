package pl.coderslab.warsztat5krkw04.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.warsztat5krkw04.model.Book;
import pl.coderslab.warsztat5krkw04.service.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private MemoryBookService mbs;

    public BookController(MemoryBookService mbs) {
        this.mbs = mbs;
    }

    @GetMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("")
    public List<Book> getAll() {
        return this.mbs.getList();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) {
        return this.mbs.getById(id);
    }

    @PostMapping("")
    public String addBook(@RequestBody Book book) {
        this.mbs.addBook(book);
        return "{\"status\": \"ok\"}";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        this.mbs.deleteById(id);
        return "{\"status\": \"ok\"}";
    }

    @PutMapping("/{id}")
    public String editBook(@RequestBody Book book) {
        this.mbs.editBook(book);
        return "{\"status\": \"ok\"}";
    }
}
