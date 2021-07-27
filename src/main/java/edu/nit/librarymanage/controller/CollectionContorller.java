package edu.nit.librarymanage.controller;


import edu.nit.librarymanage.base.PageRequest;
import edu.nit.librarymanage.base.PageResult;
import edu.nit.librarymanage.persist.BookEntity;
import edu.nit.librarymanage.persist.CollectionEntity;
import edu.nit.librarymanage.persist.CollectionRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("collect")
@RestController
public class CollectionContorller {

    CollectionRepository collectionRepository;

    public CollectionContorller(CollectionRepository collectionRepository){
        this.collectionRepository=collectionRepository;
    }

    @GetMapping
    public PageResult<CollectionEntity> listBook(CollectionEntity example, PageRequest pageable) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnoreNullValues().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<CollectionEntity> of = Example.of(example, exampleMatcher);
        Page<CollectionEntity> all = collectionRepository.findAll(of, pageable.toPageable());
        return PageResult.of(all.toList(), all.getTotalElements());
    }

    @PostMapping
    public void addBook(
            @RequestBody CollectionEntity entity
    ) {
        collectionRepository.save(entity);
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable Long id) {
        collectionRepository.deleteById(id);
    }
}
