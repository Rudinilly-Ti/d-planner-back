package com.example.dplanner.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dplanner.domain.entityes.User;
import com.example.dplanner.domain.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public List<User> listUsers() {
        return repository.findAll();
    }

    public ResponseEntity<User> create(User user) {
        var response = repository.findByEmail(user.getEmail());

        if (response.isEmpty()) {
            String novasenha = new BCryptPasswordEncoder().encode(user.getSenha());
            user.setSenha(novasenha);
            return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(user));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email).get();
    }

    public ResponseEntity<User> updateUser(User user) {
        var response = repository.findById(user.getId());
        if (response.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            User tempUser = response.get();
            if (user.getNome() != null) {
                tempUser.setNome(user.getNome());
            }
            if (user.getUsername() != null) {
                tempUser.setUsername(user.getUsername());
            }
            if (user.getEmail() != null) {
                tempUser.setEmail(user.getEmail());
            }
            if (user.getSenha() != null) {
                tempUser.setSenha(user.getSenha());
            }
            var finalUser = repository.save(tempUser);
            if (finalUser == null) {
                return ResponseEntity.badRequest().build();
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(finalUser);
            }
        }
    }
}
