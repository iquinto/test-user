package edu.uoc.pds.user.application.request;

import edu.uoc.pds.user.domain.Company;
import edu.uoc.pds.user.domain.ERole;
import edu.uoc.pds.user.domain.Role;
import edu.uoc.pds.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class AuthenticatedUserResponse {


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

    private List<ERole> roles = new ArrayList<>();

    @NotNull
    private String token;


    public static AuthenticatedUserResponse fromDomain(User user) {
        if (user == null) {
            return null;
        }

        return AuthenticatedUserResponse.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .password(user.getPassword())
                .mobileNumber(user.getMobileNumber())
                .company(user.getCompany())
                .roles(user.getRoles().stream()
                .map(Role::getName).collect(Collectors.toList()))
                .build();
    }

}


