package edu.nit.librarymanage.service;

import edu.nit.librarymanage.persist.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final BookShelfRepository bookShelfRepository;

    public AuthService(UserRepository userRepository, TokenRepository tokenRepository, BookShelfRepository bookShelfRepository) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.bookShelfRepository=bookShelfRepository;
    }

    public TokenEntity login(String name,String password){
        // find user by name
        Optional<UserEntity> optional = userRepository.findByName(name);
        // if user exist
        final UserEntity user;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new IllegalArgumentException("用户不存在");
        }
        // check password

        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("密码错误");
        }
        TokenEntity tk = new TokenEntity();
        tk.setUserid(user.getId());
        tk.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
        tk.setCreateTime(new Date());
        tokenRepository.save(tk);
        // else
        // throw

        return tk;
    }

    public void register(String name,String password){
        UserEntity user= new UserEntity();
        BookShelfEntity bookShelf = new BookShelfEntity();
        Optional<UserEntity> optional = userRepository.findByName(name);
        if (!optional.isPresent()) {
            user.setName(name);
            user.setPassword(password);
            user.setCreateDate(new Date());
            user.setQx("0");
            //user.setBookShelf(bookShelf);
            userRepository.save(user);

            UserEntity user2 = new UserEntity();
            Optional<UserEntity> optional2 = userRepository.findByName(name);
            user2 = optional2.get();
            BookShelfEntity bookShelf2=new BookShelfEntity();
            bookShelf2.setUserId(user2.getId());
            bookShelfRepository.save(bookShelf2);
            user2.setBookShelf(bookShelf2);
            userRepository.save(user2);

        }else{
            throw new IllegalArgumentException("用户已存在");
        }
    }
}
