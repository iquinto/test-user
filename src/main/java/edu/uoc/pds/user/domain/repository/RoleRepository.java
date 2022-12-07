package edu.uoc.pds.user.domain.repository;

import edu.uoc.pds.user.domain.ERole;
import edu.uoc.pds.user.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository {

    List<Role> findAllRoles();

    Optional<Role> findRoleById(Long id);

    Optional<Role> findRoleByName(ERole name);

    Long createRole(Role role);

    void deleteRole(Long id);
}
