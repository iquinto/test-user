package edu.uoc.epcsd.user.domain.service;

import edu.uoc.epcsd.user.domain.*;
import edu.uoc.epcsd.user.domain.repository.CategoryRepository;
import edu.uoc.epcsd.user.domain.repository.ShowRepository;
import edu.uoc.epcsd.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public Optional<User> findUserByCompany(Company company) {
        return userRepository.findUserByCompany(company);
    }

    @Override
    public User createUser(User user) {
        return userRepository.createUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }
}
