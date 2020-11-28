package edu.nit.librarymanage.controller;

import edu.nit.librarymanage.base.PageRequest;
import edu.nit.librarymanage.base.PageResult;
import edu.nit.librarymanage.persist.BookEntity;
import edu.nit.librarymanage.persist.BookRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("book")
@RestController
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public PageResult<BookEntity> listBook(BookEntity example, PageRequest pageable) {
        Example<BookEntity> of = Example.of(example);
        Page<BookEntity> all = bookRepository.findAll(of, pageable.toPageable());
        return PageResult.of(all.toList(), all.getTotalElements());
    }

    @GetMapping("{id}")
    public BookEntity findBook(@PathVariable Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @PostMapping
    public void addBook(
            @RequestBody BookEntity entity
    ) {
        bookRepository.save(entity);
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }

}
