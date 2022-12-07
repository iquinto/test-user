package edu.uoc.epcsd.user.infrastructure.repository.jpa;

import edu.uoc.epcsd.user.domain.ERole;
import edu.uoc.epcsd.user.domain.Role;
import edu.uoc.epcsd.user.domain.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoleRepositoryImpl implements RoleRepository {

    private final SpringDataRoleRepository jpaRepository;


    @Override
    public List<Role> findAllRoles() {
         return jpaRepository.findAll().stream().map(RoleEntity::toDomain).collect(Collectors.toList());

    }

    @Override
    public Optional<Role> findRoleById(Long id) {
        return  jpaRepository.findById(id).map(RoleEntity::toDomain);
    }

    @Override
    public Optional<Role> findRoleByName(ERole name) {
        return  jpaRepository.findByName(name).map(RoleEntity::toDomain);
    }


    @Override
    public Long createRole(Role role) {
        return jpaRepository.save(RoleEntity.fromDomain(role)).getId();
    }

    @Override
    public void deleteRole(Long id) {
        jpaRepository.deleteById(id);
    }
}
