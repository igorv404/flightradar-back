package io.igorv404.flightradarback.city.implementation;

import io.igorv404.flightradarback.city.City;
import io.igorv404.flightradarback.city.CityRepository;
import io.igorv404.flightradarback.city.CityService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
  private final CityRepository cityRepository;

  public CityServiceImpl(@Qualifier("cityRepositoryImpl") CityRepository cityRepository) {
    this.cityRepository = cityRepository;
  }

  @Override
  public List<City> findAll() {
    return this.cityRepository.findAll();
  }

  @Override
  public Optional<City> findById(Integer id) {
    return this.cityRepository.findById(id);
  }

  @Override
  public int save(City entity) {
    return this.cityRepository.save(entity);
  }

  @Override
  public int update(Integer id, City entity) {
    return this.cityRepository.update(id, entity);
  }

  @Override
  public void delete(Integer id) {
    this.cityRepository.delete(id);
  }

  @Override
  public List<City> findByName(String name) {
    return this.cityRepository.findByName(name);
  }
}
