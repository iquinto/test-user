package edu.uoc.epcsd.user.domain.service;

import edu.uoc.epcsd.user.domain.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {


    // roles
    List<Role> findAllRoles();

    Optional<Role> findRoleById(Long id);

    Optional<Role> findRoleByName(ERole name);

    Long createRole(Role role);

    void deleteRole(Long id);

    // companies
    List<Company> findAllComapanies();

    Optional<Company> findCompanyById(Long id);

    Long createCompany(Company company);

    void deleteCompany(Long id);


    // users
    List<User> findAllUsers();

    Optional<User> findUserById(Long id);

    Optional<User> findUserByCompany(Company company);

    User createUser(User user);

    void deleteUser(Long id);
}
