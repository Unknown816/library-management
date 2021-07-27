package edu.nit.librarymanage.controller;

import edu.nit.librarymanage.base.PageRequest;
import edu.nit.librarymanage.base.PageResult;
import edu.nit.librarymanage.persist.BookEntity;
import edu.nit.librarymanage.persist.TalkEntity;
import edu.nit.librarymanage.persist.TalkRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("talk")
@RestController
public class TalkController {
    private final TalkRepository talkRepository;

    public TalkController(TalkRepository talkRepository) {
        this.talkRepository = talkRepository;
    }

    @GetMapping
    public PageResult<TalkEntity> listTalk(TalkEntity example, PageRequest pageable) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnoreNullValues().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<TalkEntity> of = Example.of(example, exampleMatcher);
        Page<TalkEntity> all = talkRepository.findAll(of, pageable.toPageable());
        return PageResult.of(all.toList(), all.getTotalElements());
    }

    @GetMapping("{id}")
    public TalkEntity findTalk(@PathVariable Long id) {
        return talkRepository.findById(id).orElse(null);
    }

    @PostMapping
    public void addTalk(
            @RequestBody TalkEntity entity
    ) {
        talkRepository.save(entity);
    }

    @DeleteMapping("{id}")
    public void deleteTalk(@PathVariable Long id) {
        talkRepository.deleteById(id);
    }

}
