package edu.uoc.epcsd.user.domain.repository;

import edu.uoc.epcsd.user.domain.Company;
import edu.uoc.epcsd.user.domain.User;
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
