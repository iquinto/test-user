package edu.uoc.pds.user.domain.repository;

import edu.uoc.pds.user.domain.Company;
import edu.uoc.pds.user.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository {

    List<User> findAllUsers();

    Optional<User> findUserById(Long id);

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByCompany(Company company);

    User createUser(User user);

    void deleteUser(Long id);

    Boolean existsByEmail(String email);

}
