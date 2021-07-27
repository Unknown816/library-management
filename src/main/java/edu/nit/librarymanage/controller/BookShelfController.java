package edu.nit.librarymanage.controller;

import edu.nit.librarymanage.base.PageRequest;
import edu.nit.librarymanage.base.PageResult;
import edu.nit.librarymanage.persist.BookShelfEntity;
import edu.nit.librarymanage.persist.BookShelfRepository;
import edu.nit.librarymanage.persist.CollectionEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("bookshelf")
@RestController
public class BookShelfController {

    BookShelfRepository bookShelfRepository;
    //UserRepository userRepository;

    public BookShelfController(BookShelfRepository bookShelfRepository) {
        this.bookShelfRepository = bookShelfRepository;
    }

    @GetMapping
    public PageResult<BookShelfEntity> findBookShelf(BookShelfEntity example, PageRequest pageable) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnoreNullValues().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<BookShelfEntity> of = Example.of(example, exampleMatcher);
        Page<BookShelfEntity> all = bookShelfRepository.findAll(of, pageable.toPageable());
        return PageResult.of(all.toList(), all.getTotalElements());
    }

    @PostMapping
    public void addBookShelf(
            @RequestBody BookShelfEntity entity
    ) {
        bookShelfRepository.save(entity);
    }
}
