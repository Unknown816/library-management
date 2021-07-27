package edu.nit.librarymanage.controller;

import edu.nit.librarymanage.base.PageRequest;
import edu.nit.librarymanage.base.PageResult;
import edu.nit.librarymanage.persist.BookEntity;
import edu.nit.librarymanage.persist.BookRepository;
import edu.nit.librarymanage.persist.NoticeEntity;
import edu.nit.librarymanage.persist.NoticeRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("notice")
@RestController
public class NoticeController {
    private final NoticeRepository noticeRepository;

    public NoticeController(NoticeRepository noticeRepository){this.noticeRepository=noticeRepository;}

    @GetMapping
    public PageResult<NoticeEntity> listNotice(NoticeEntity example, PageRequest pageable) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnoreNullValues().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<NoticeEntity> of = Example.of(example, exampleMatcher);
        Page<NoticeEntity> all = noticeRepository.findAll(of, pageable.toPageable());
        return PageResult.of(all.toList(), all.getTotalElements());
    }

    @GetMapping("{id}")
    public NoticeEntity findNotice(@PathVariable Long id) {
        return noticeRepository.findById(id).orElse(null);
    }

    @PostMapping
    public void addNotice(
            @RequestBody NoticeEntity entity
    ) {
        noticeRepository.save(entity);
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable Long id) {
        noticeRepository.deleteById(id);
    }
}
