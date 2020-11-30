package edu.nit.librarymanage.controller;

import edu.nit.librarymanage.base.PageRequest;
import edu.nit.librarymanage.base.PageResult;
import edu.nit.librarymanage.persist.TokenEntity;
import edu.nit.librarymanage.persist.UserEntity;
import edu.nit.librarymanage.persist.UserRepository;
import edu.nit.librarymanage.service.AuthService;
import lombok.Data;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("users")
@RestController
public class UserController {

    private final AuthService authService;
    private final UserRepository userRepository;

    public UserController(AuthService authService, UserRepository userRepository) {
        this.authService = authService;
        this.userRepository = userRepository;
    }

    @Data
    public static class LoginForm{
        String name;
        String password;
    }

    @PostMapping("login")
    public TokenEntity login(
            @RequestBody LoginForm loginForm
    ){
        return authService.login(loginForm.name,loginForm.password);
    }

    @GetMapping
    public PageResult<UserEntity> listUser(UserEntity example, PageRequest pageable){
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnoreNullValues().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<UserEntity> of=Example.of(example,exampleMatcher);
        Page<UserEntity> all=userRepository.findAll(of,pageable.toPageable());
        return PageResult.of(all.toList(),all.getTotalElements());
    }

    @GetMapping("{id}")
    public UserEntity findUser(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping
    public void addUser(
            @RequestBody UserEntity entity
    ) {
        userRepository.save(entity);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
