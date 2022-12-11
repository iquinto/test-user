package edu.uoc.pds.user.infrastructure.repository.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.uoc.pds.user.domain.Company;

import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@ToString(exclude = "users")
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company")
public class CompanyEntity implements DomainTranslatable<Company> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Builder.Default
    @JsonIgnore
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<UserEntity> users = new HashSet<>();


    public static CompanyEntity fromDomain(Company company) {
        if (company == null) {
            return null;
        }

        return CompanyEntity.builder()
              //  .id(company.getId())
                .name(company.getName())
                .description(company.getDescription())
                .build();
    }

    @Override
    public Company toDomain() {
        return Company.builder()
                .id(this.getId())
                .name(this.getName())
                .description(this.getDescription())
                .build();
    }
}
