package io.igorv404.flightradarback.city.implementation;

import io.igorv404.flightradarback.city.City;
import io.igorv404.flightradarback.city.CityController;
import io.igorv404.flightradarback.city.CityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityControllerImpl implements CityController {
  private final CityService cityService;

  public CityControllerImpl(CityService cityService) {
    this.cityService = cityService;
  }

  @Override
  public List<City> findByName(String name) {
    return this.cityService.findByName(name);
  }

  @Override
  public List<City> findAll() {
    return this.cityService.findAll();
  }

  @Override
  public Optional<City> findById(Integer id) {
    return this.cityService.findById(id);
  }

  @Override
  public int save(City entity) {
    return this.cityService.save(entity);
  }

  @Override
  public int update(Integer id, City entity) {
    return this.cityService.update(id, entity);
  }

  @Override
  public void delete(Integer id) {
    this.cityService.delete(id);
  }
}
