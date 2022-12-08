package edu.uoc.pds.user.application.rest;

import edu.uoc.pds.user.domain.service.UserService;
import edu.uoc.pds.user.application.request.CreateCompanyRequest;
import edu.uoc.pds.user.application.request.CreateUserRequest;
import edu.uoc.pds.user.domain.Company;
import edu.uoc.pds.user.domain.Role;
import edu.uoc.pds.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.awt.*;
import java.net.URI;
import java.util.List;

@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserRESTController {
    private final UserService userService;

    // ROLES
    @GetMapping("/roles")
    @ResponseStatus(HttpStatus.OK)
    public List<Role> findAllRoles() {
        System.out.println("findAllRoles");
        return userService.findAllRoles();
    }

    // COMPANIES
    @GetMapping("/companies")
    @ResponseStatus(HttpStatus.OK)
    public List<Company> findAllComapanies() {
        System.out.println("findAllRoles");
        return userService.findAllComapanies();
    }

    @PostMapping("/companies")
    public ResponseEntity<Long> createCompany(@RequestBody CreateCompanyRequest createCompanyRequest) {
        log.trace("Creating company " + createCompanyRequest);
        Long companyId = userService.createCompany(createCompanyRequest.getCompany());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(companyId)
                .toUri();

        return ResponseEntity.created(uri).body(companyId);
    }

    // USERS
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAllUsers() {
        log.trace("findAllUsers");
        return userService.findAllUsers();
    }


    @GetMapping("/users/{email}")
    @ResponseStatus(HttpStatus.OK)
    public  ResponseEntity<User> findUserByEmail(@PathVariable String email) {
        log.trace("findUserByEmail " + email);
        return userService.findUserByEmail(email).map(user -> ResponseEntity.ok().body(user))
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest createUserRequest) {
        log.trace("Creating user " + createUserRequest);
        User user = userService.createUser(createUserRequest.getUser());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(uri).body(user);
    }


}
