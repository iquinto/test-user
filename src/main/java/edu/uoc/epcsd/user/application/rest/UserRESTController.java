package edu.uoc.epcsd.user.application.rest;

import edu.uoc.epcsd.user.application.request.CreateCategoryRequest;
import edu.uoc.epcsd.user.application.request.CreatePerformanceRequest;
import edu.uoc.epcsd.user.application.request.CreateShowRequest;
import edu.uoc.epcsd.user.application.request.CreateUserRequest;
import edu.uoc.epcsd.user.domain.Category;
import edu.uoc.epcsd.user.domain.Performance;
import edu.uoc.epcsd.user.domain.Show;
import edu.uoc.epcsd.user.domain.User;
import edu.uoc.epcsd.user.domain.service.CatalogService;
import edu.uoc.epcsd.user.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Set;

@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserRESTController {

    private final UserService userService;



    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAllUsers() {
        System.out.println("findAllUsers");
        return userService.findAllUsers();
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest createUserRequest) {
        System.out.println("HOLA >>>>>>> " + createUserRequest.getUser().getFullName());
        System.out.println("Creating user " + createUserRequest.getUser().getPassword());

        log.trace("Creating user " + createUserRequest);
        User user = userService.createUser(createUserRequest.getUser());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(uri).body(user);
    }




}
