package edu.uoc.pds.user.application.request;

import edu.uoc.pds.user.infrastructure.repository.jpa.CompanyEntity;
import edu.uoc.pds.user.infrastructure.repository.jpa.RoleEntity;
import edu.uoc.pds.user.infrastructure.repository.jpa.UserEntity;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.stream.Collectors;

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

    @Builder.Default
    private Set<Role> roles = new HashSet<>();

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
                .company(CompanyEntity.fromDomain(user.getCompany()))
                .roles(user.getRoles().stream().map(RoleEntity::fromDomain).collect(Collectors.toSet()))
                .build();
    }

}


}
