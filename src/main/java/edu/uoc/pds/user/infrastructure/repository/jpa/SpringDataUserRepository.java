package edu.uoc.pds.user.infrastructure.repository.jpa;

import edu.uoc.pds.user.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.DoubleStream;

@Repository
public interface SpringDataUserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByCompany(Company name);

    Optional<UserEntity> findByEmail(String email);

    Boolean existsByEmail(String email);
}
