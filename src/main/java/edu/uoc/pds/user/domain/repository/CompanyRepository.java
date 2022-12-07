package edu.uoc.pds.user.domain.repository;

import edu.uoc.pds.user.domain.Company;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository {

    List<Company> findAllComapanies();

    Optional<Company> findCompanyById(Long id);


    Long createCompany(Company company);

    void deleteCompany(Long id);

}
