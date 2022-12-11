package edu.uoc.pds.user.application.rest;

import edu.uoc.pds.user.application.request.AuthenticatedUserResponse;
import edu.uoc.pds.user.application.request.CreateCompanyRequest;
import edu.uoc.pds.user.application.request.CreateUserRequest;
import edu.uoc.pds.user.application.request.LoginRequest;
import edu.uoc.pds.user.domain.User;
import edu.uoc.pds.user.domain.service.AuthenticationService;
import edu.uoc.pds.user.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/auth")
public class AuthenticationRESTController {

    private final AuthenticationService authenticationService;
    private final UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody LoginRequest loginRequest) {
        log.info("signIn user with email:  " + loginRequest.getEmail());
        try{
            User user = authenticationService.signIn(loginRequest.getEmail(), loginRequest.getPassword());
            AuthenticatedUserResponse authenticatedUserResponse = AuthenticatedUserResponse.fromDomain(user);
            String key =  authenticationService.createToken(user);
            authenticatedUserResponse.setToken(key);
            log.info("user found with token :  " + authenticatedUserResponse.getToken());
            return ResponseEntity.ok(authenticatedUserResponse);
        }catch(Exception e){
            log.error("Error found :  " + e.getMessage());
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerBuyer(@RequestBody CreateUserRequest createUserRequest) {
        log.info("Creating user " + createUserRequest.getUser());
        try {
            User user = userService.createUser(createUserRequest.getUser());
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(user.getId())
                    .toUri();
            return ResponseEntity.created(uri).body(user.getId());
        }catch(Exception e){
            log.error("Error found :  " + e.getMessage());
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/validatetoken")
    public ResponseEntity<AuthenticatedUserResponse> validate(@RequestParam String token) {
        log.info("Trying to validate token " +  token);
        User user =  authenticationService.validateToken(token);
        AuthenticatedUserResponse authenticatedUserResponse = AuthenticatedUserResponse.fromDomain(user);
        String key =  authenticationService.createToken(user);
        authenticatedUserResponse.setToken(key);
        return ResponseEntity.ok(authenticatedUserResponse);
    }

}
