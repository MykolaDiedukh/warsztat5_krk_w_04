package pl.coderslab.warsztat5krkw04.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public Book helloBook(){
        return new Book(1L,"9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }

    @GetMapping("")
    public List<Book> getAll(){
        return this.mbs.getList();
    }
}
