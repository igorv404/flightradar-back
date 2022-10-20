package io.igorv404.flightradarback.country.implementation;

import io.igorv404.flightradarback.country.Country;
import io.igorv404.flightradarback.country.CountryRepository;
import io.igorv404.flightradarback.country.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryControllerImpl implements CountryRepository {
  private final CountryService countryService;

  public CountryControllerImpl(CountryService countryService) {
    this.countryService = countryService;
  }
  @Override
  public List<Country> findAll() {
    return this.countryService.findAll();
  }

  @Override
  public Optional<Country> findById(String name) {
    return this.countryService.findById(name);
  }

  @Override
  public int save(Country entity) {
    return this.countryService.save(entity);
  }

  @Override
  public int update(String name, Country entity) {
    return this.countryService.update(name, entity);
  }

  @Override
  public void delete(String name) {
    this.countryService.delete(name);
  }
}
