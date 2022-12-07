package edu.uoc.pds.user.application.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.uoc.pds.user.domain.Role;
import lombok.Getter;

import javax.validation.constraints.NotNull;

public class CreateRoleRequest {

    @Getter
    @NotNull
    private final Role role;

    @JsonCreator
    public CreateRoleRequest(@JsonProperty("role") @NotNull final Role role) {
        this.role = role;
    }
}
