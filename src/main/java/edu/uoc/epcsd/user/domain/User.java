package edu.uoc.epcsd.user.domain;

import edu.uoc.epcsd.user.infrastructure.repository.jpa.RoleEntity;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NotNull
    private Long id;

    @NotNull
    private String fullName;

    @NotNull
    private String password;

    @NotNull
    private String email;

    @NotNull
    private String mobileNumber;

    private Company company;

    @Builder.Default
    private Set<Role> roles = new HashSet<>();


}