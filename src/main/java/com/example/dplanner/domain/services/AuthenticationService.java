package com.example.dplanner.domain.services;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import static java.util.Collections.emptyList;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationService {
    static final long EXPIRATION_TIME = 864_000_000;
    static final String SIGNINGKEY = "SecretKey";
    static final String PREFIX = "Bearer";

    static public void addToken(HttpServletResponse res, String email) {
        String JwToken = Jwts.builder().setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SIGNINGKEY)
                .compact();
        res.addHeader("Authorization", PREFIX + " " + JwToken);
        res.addHeader("Acess-Controll-Expose-Headers", "Authorization");
    }

    static public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token != null) {
            String email = Jwts.parser()
                    .setSigningKey(SIGNINGKEY)
                    .parseClaimsJws(token.replace(PREFIX, ""))
                    .getBody()
                    .getSubject();

            if (email != null) {
                return new UsernamePasswordAuthenticationToken(email, null, emptyList());
            }
        }

        return null;
    }
}
