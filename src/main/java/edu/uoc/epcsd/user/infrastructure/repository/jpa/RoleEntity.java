package edu.uoc.epcsd.user.infrastructure.repository.jpa;

import edu.uoc.epcsd.user.domain.*;
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
@Table(name = "rolse")
public class RoleEntity implements DomainTranslatable<Role> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @Enumerated(EnumType.ORDINAL)
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
                .description(role.getDesciption())
                .build();
    }

    @Override
    public Role toDomain() {
        return null;
    }
}
