package edu.nit.librarymanage.service;

import edu.nit.librarymanage.persist.TokenEntity;
import edu.nit.librarymanage.persist.TokenRepository;
import edu.nit.librarymanage.persist.UserEntity;
import edu.nit.librarymanage.persist.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;

    public AuthService(UserRepository userRepository, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }

    public TokenEntity login(String name,String password){
        TokenEntity tokenEntity;
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
        tokenRepository.save(tk);
        // else
        // throw
        return tk;
    }
}
