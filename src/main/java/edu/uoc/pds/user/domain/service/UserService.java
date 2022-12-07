package edu.uoc.pds.user.domain.service;

import edu.uoc.pds.user.domain.Company;
import edu.uoc.pds.user.domain.ERole;
import edu.uoc.pds.user.domain.Role;
import edu.uoc.pds.user.domain.User;

import java.util.List;
import java.util.Optional;

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


    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByCompany(Company company);

    User createUser(User user);

    void deleteUser(Long id);
}
