package edu.nit.librarymanage.controller;

import edu.nit.librarymanage.base.PageRequest;
import edu.nit.librarymanage.base.PageResult;
import edu.nit.librarymanage.base.PageRequest;
import edu.nit.librarymanage.base.PageResult;
import edu.nit.librarymanage.persist.TokenEntity;
import edu.nit.librarymanage.persist.TokenRepository;
import edu.nit.librarymanage.persist.UserEntity;
import jdk.nashorn.internal.parser.Token;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("token")
@RestController
public class TokenController {
    private final TokenRepository tokenRepository;

    public TokenController(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @GetMapping
    public PageResult<TokenEntity> findToken(TokenEntity example, PageRequest pageable){
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnoreNullValues().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<TokenEntity> of=Example.of(example,exampleMatcher);
        Page<TokenEntity> all=tokenRepository.findAll(of,pageable.toPageable());
        return PageResult.of(all.toList(),all.getTotalElements());
    }

}
