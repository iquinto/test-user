package edu.uoc.pds.user.domain.service;

import edu.uoc.pds.user.domain.User;


public interface AuthenticationService {
    User signIn(String email, String password) throws Exception;

    User validateToken(String token);
    String createToken(User user);
}
