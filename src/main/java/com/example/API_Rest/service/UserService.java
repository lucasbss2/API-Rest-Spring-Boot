package com.example.API_Rest.service;
import java.util.Optional;
import com.example.API_Rest.model.User;
import com.example.API_Rest.repository.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo ;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User registerUser(String username, String password) {
        String senhaCriptografada = passwordEncoder.encode(password);
        User usuario = new User(username, senhaCriptografada);
        return userRepo.save(usuario);
    }

    public Optional<User> searchByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
