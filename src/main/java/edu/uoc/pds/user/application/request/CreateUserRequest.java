package edu.uoc.pds.user.application.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.uoc.pds.user.domain.User;
import lombok.Getter;

import javax.validation.constraints.NotNull;

public class CreateUserRequest {

    @Getter
    @NotNull
    private final User user;

    @JsonCreator
    public CreateUserRequest(@JsonProperty("user") @NotNull final User user) {
        this.user = user;
    }


}
