package edu.uoc.epcsd.user.domain;


import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    private Long id;

    private ERole name;

    private String desciption;
}
