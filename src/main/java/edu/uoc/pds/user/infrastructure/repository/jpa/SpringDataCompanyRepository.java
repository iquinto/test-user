package edu.uoc.pds.user.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataCompanyRepository extends JpaRepository<CompanyEntity, Long> {
}
