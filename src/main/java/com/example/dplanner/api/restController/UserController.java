package com.example.dplanner.api.restController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.dplanner.domain.entityes.User;
import com.example.dplanner.domain.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/listAll")
    public List<User> listAll() {
        return service.listUsers();
    }

    @PostMapping("/new")
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        return service.create(user);
    }

    @PostMapping("/findUser")
    public User findByEmail(@RequestBody User user) {
        return service.findByEmail(user.getEmail());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return service.updateUser(user);
    }

    // @PutMapping("/login")
    // public ResponseEntity<Map<String, Object>>
    // getAuthenticated(HttpServletRequest request) {
    // String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

    // if (authorizationHeader != null && authorizationHeader.startsWith("Bearer "))
    // {
    // String refreshToken = authorizationHeader.substring("Bearer ".length());
    // Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
    // JWTVerifier verifier = JWT.require(algorithm).build();
    // DecodedJWT decodedJWT = verifier.verify(refreshToken);

    // String email = decodedJWT.getSubject();
    // User user = service.findByEmail(email);

    // Map<String, Object> response = new HashMap<>();
    // response.put("id", user.getId());
    // response.put("nome", user.getNome());
    // response.put("login", user.getEmail());

    // return ResponseEntity.ok(response);
    // } else {
    // throw new RuntimeException("Refresh token is missing");
    // }
    // }

}
