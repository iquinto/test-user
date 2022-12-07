package edu.uoc.pds.user.domain;


import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    private Long id;

    private ERole name;

    private String description;
}
