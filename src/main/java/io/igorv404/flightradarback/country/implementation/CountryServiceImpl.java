package io.igorv404.flightradarback.country.implementation;

import io.igorv404.flightradarback.country.Country;
import io.igorv404.flightradarback.country.CountryRepository;
import io.igorv404.flightradarback.country.CountryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
  private final CountryRepository countryRepository;

  public CountryServiceImpl(@Qualifier("countryRepositoryImpl") CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
  }

  @Override
  public List<Country> findAll() {
    return this.countryRepository.findAll();
  }

  @Override
  public Optional<Country> findById(String name) {
    return this.countryRepository.findById(name);
  }

  @Override
  public int save(Country entity) {
    return this.countryRepository.save(entity);
  }

  @Override
  public int update(String name, Country entity) {
    return this.countryRepository.update(name, entity);
  }

  @Override
  public void delete(String name) {
    this.countryRepository.delete(name);
  }
}
