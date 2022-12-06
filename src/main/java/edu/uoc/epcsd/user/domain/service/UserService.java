package edu.uoc.epcsd.user.domain.service;

import edu.uoc.epcsd.user.domain.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {

    List<User> findAllUsers();

    Optional<User> findUserById(Long id);

    Optional<User> findUserByCompany(Company company);

    User createUser(User user);

    void deleteUser(Long id);
}
