package edu.nit.librarymanage.controller;

import edu.nit.librarymanage.base.PageRequest;
import edu.nit.librarymanage.base.PageResult;
import edu.nit.librarymanage.persist.UserEntity;
import edu.nit.librarymanage.persist.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("users")
@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public PageResult<UserEntity> listUser(UserEntity example, PageRequest pageable){
        Example<UserEntity> of=Example.of(example);
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
