package edu.uoc.pds.user.infrastructure.repository.jpa;

import edu.uoc.pds.user.domain.ERole;
import edu.uoc.pds.user.domain.Role;
import lombok.*;

import javax.persistence.*;

@Entity
@ToString(exclude = "shows")
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class RoleEntity implements DomainTranslatable<Role> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private ERole name;


    @Column(name = "description")
    private String description;

    public static RoleEntity fromDomain(Role role) {
        if (role == null) {
            return null;
        }

        return RoleEntity.builder()
                .id(role.getId())
                .name(role.getName())
                .description(role.getDescription())
                .build();
    }

    @Override
    public Role toDomain() {

        return Role.builder()
                .id(this.getId())
                .name(this.getName())
                .description(this.getDescription())
                .build();
    }
}
