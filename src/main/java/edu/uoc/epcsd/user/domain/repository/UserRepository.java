package edu.uoc.epcsd.user.domain.repository;

import edu.uoc.epcsd.user.domain.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository {

    List<User> findAllUsers();

    Optional<User> findUserById(Long id);

    Optional<User> findUserByCompany(Company company);

    User createUser(User user);

    void deleteUser(Long id);

}
