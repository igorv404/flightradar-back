package io.igorv404.flightradarback.company.implementation;

import io.igorv404.flightradarback.company.Company;
import io.igorv404.flightradarback.company.CompanyController;
import io.igorv404.flightradarback.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyControllerImpl implements CompanyController {
  private final CompanyService companyService;

  public CompanyControllerImpl(CompanyService companyService) {
    this.companyService = companyService;
  }

  @Override
  public List<Company> findAll() {
    return this.companyService.findAll();
  }

  @Override
  public Optional<Company> findById(String name) {
    return this.companyService.findById(name);
  }

  @Override
  public int save(Company entity) {
    return this.companyService.save(entity);
  }

  @Override
  public int update(String name, Company entity) {
    return this.companyService.update(name, entity);
  }

  @Override
  public void delete(String name) {
    this.companyService.delete(name);
  }
}
