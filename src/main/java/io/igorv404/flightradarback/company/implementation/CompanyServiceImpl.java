package io.igorv404.flightradarback.company.implementation;

import io.igorv404.flightradarback.company.Company;
import io.igorv404.flightradarback.company.CompanyRepository;
import io.igorv404.flightradarback.company.CompanyService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
  private final CompanyRepository companyRepository;

  public CompanyServiceImpl(@Qualifier("companyRepositoryImpl") CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  @Override
  public List<Company> findAll() {
    return this.companyRepository.findAll();
  }

  @Override
  public Optional<Company> findById(String name) {
    return this.companyRepository.findById(name);
  }

  @Override
  public int save(Company entity) {
    return this.companyRepository.save(entity);
  }

  @Override
  public int update(String name, Company entity) {
    return this.companyRepository.update(name, entity);
  }

  @Override
  public void delete(String name) {
    this.companyRepository.delete(name);
  }
}
