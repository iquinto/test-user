package edu.uoc.pds.user.domain.service;

import edu.uoc.pds.user.application.request.AuthenticatedUserResponse;
import edu.uoc.pds.user.application.request.LoginRequest;
import edu.uoc.pds.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class AuthenticationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKey;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public AuthenticatedUserResponse signIn(LoginRequest loginRequest) {
        User user = userService.findUserByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + loginRequest.getEmail()));


        boolean correct = passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());
       // boolean correct = passwordEncoder.matches(CharBuffer.wrap(loginRequest.getPassword()), user.getPassword());

        if (correct) {
            AuthenticatedUserResponse userResponse = AuthenticatedUserResponse.fromDomain(user);
            userResponse.setToken(createToken(user));
            return userResponse;
        }

        // throw new Exception("Invalid password");

        return null;
    }



    public AuthenticatedUserResponse validateToken(String token) {
        String login = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        User user = userService.findUserByEmail(login)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " ));

        AuthenticatedUserResponse userResponse = AuthenticatedUserResponse.fromDomain(user);
        userResponse.setToken(createToken(user));
        return userResponse;
    }

    private String createToken(User user) {
        Claims claims = Jwts.claims().setSubject(user.getEmail());

        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000); // 1 hour

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

}
