package edu.uoc.pds.user.application.request;

import edu.uoc.pds.user.domain.User;
import lombok.Getter;

import javax.validation.constraints.NotNull;

public class LoginRequest {

    @Getter
    @NotNull
    private  String email;


    @Getter
    @NotNull
    private  String password;

}
