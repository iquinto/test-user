package edu.uoc.epcsd.user.infrastructure.repository.jpa;

import edu.uoc.epcsd.user.domain.Company;
import edu.uoc.epcsd.user.domain.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CompanyRepositoryImpl implements CompanyRepository {

    private final SpringDataCompanyRepository jpaRepository;


    @Override
    public List<Company> findAllComapanies() {
        return jpaRepository.findAll().stream().map(CompanyEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Company> findCompanyById(Long id) {
        return jpaRepository.findById(id).map(CompanyEntity::toDomain);
    }

    @Override
    public Long createCompany(Company company) {
        return jpaRepository.save(CompanyEntity.fromDomain(company)).getId();
    }

    @Override
    public void deleteCompany(Long id) {
         jpaRepository.deleteById(id);
    }
}
