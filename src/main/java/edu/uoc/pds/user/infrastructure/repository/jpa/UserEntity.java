package edu.uoc.pds.user.infrastructure.repository.jpa;

import edu.uoc.pds.user.domain.User;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@ToString
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity implements DomainTranslatable<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "mobile_number", nullable = true)
    private String mobileNumber;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_company", referencedColumnName = "id")
    private CompanyEntity company;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles = new HashSet<>();


    public static UserEntity fromDomain(User user) {
        if (user == null) {
            return null;
        }

        return UserEntity.builder()
                //.id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .password(user.getPassword())
                .mobileNumber(user.getMobileNumber())
                .company(CompanyEntity.fromDomain(user.getCompany()))
                .roles(user.getRoles().stream().map(RoleEntity::fromDomain).collect(Collectors.toSet()))
                .build();
    }

    @Override
    public User toDomain() {
        User user = User.builder()
                .id(this.getId())
                .fullName(this.getFullName())
                .email(this.getEmail())
                .password(this.getPassword())
                .mobileNumber(this.getMobileNumber())
                .roles((this.getRoles().stream().map(RoleEntity::toDomain).collect(Collectors.toSet())))
                .build();

        if(this.getCompany() != null){
            user.setCompany(this.getCompany().toDomain());
        }

       return user;
    }
}
