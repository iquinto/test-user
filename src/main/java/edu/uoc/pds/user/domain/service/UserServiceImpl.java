package edu.uoc.pds.user.domain.service;

import edu.uoc.pds.user.domain.Company;
import edu.uoc.pds.user.domain.ERole;
import edu.uoc.pds.user.domain.Role;
import edu.uoc.pds.user.domain.User;
import edu.uoc.pds.user.domain.repository.CompanyRepository;
import edu.uoc.pds.user.domain.repository.RoleRepository;
import edu.uoc.pds.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAllRoles();
    }

    @Override
    public Optional<Role> findRoleById(Long id) {
        return roleRepository.findRoleById(id);
    }

    @Override
    public Optional<Role> findRoleByName(ERole name) {
        return roleRepository.findRoleByName(name);
    }

    @Override
    public Long createRole(Role role) {
        return roleRepository.createRole(role);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteRole(id);
    }

    // company
    @Override
    public List<Company> findAllComapanies() {
        return companyRepository.findAllComapanies();
    }

    @Override
    public Optional<Company> findCompanyById(Long id) {
        return companyRepository.findCompanyById(id);
    }

    @Override
    public Long createCompany(Company company) {
         return companyRepository.createCompany(company);
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteCompany(id);
    }

    // users
    @Override
    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public Optional<User> findUserByCompany(Company company) {
        return userRepository.findUserByCompany(company);
    }

    @Override
    public User createUser(User user) {
        System.out.println("HOLAALLALA " + user.getEmail());
        if (userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("Email is alredy used!");
        }


        if(user.getCompany() != null){
            Company company = companyRepository.findCompanyById(user.getCompany().getId()).get();
            user.setCompany(company);
        }

        Set<Role> roles = new HashSet<>();
        if(user.getRoles().size() > 0){
            user.getRoles().forEach(role -> {
                switch (role.getName()) {
                    case ROLE_ADMINISTRATOR:
                        Role adminRole = roleRepository.findRoleByName(ERole.ROLE_ADMINISTRATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case ROLE_ORGANIZER:
                        Role modRole = roleRepository.findRoleByName(ERole.ROLE_ORGANIZER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);
                        break;
                    default:
                        Role userRole = roleRepository.findRoleByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }else {
            Role userRole = roleRepository.findRoleByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        }

        user.setRoles(roles);
        return userRepository.createUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
