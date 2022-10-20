package io.igorv404.flightradarback.airport.implementation;

import io.igorv404.flightradarback.airport.Airport;
import io.igorv404.flightradarback.airport.AirportController;
import io.igorv404.flightradarback.airport.AirportService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AiportControllerImpl implements AirportController {
  private final AirportService airportService;

  public AiportControllerImpl(AirportService airportService) {
    this.airportService = airportService;
  }

  @Override
  public List<Airport> findByName(String name) {
    return this.airportService.findByName(name);
  }

  @Override
  public List<Airport> findAll() {
    return this.airportService.findAll();
  }

  @Override
  public Optional<Airport> findById(Integer id) {
    return this.airportService.findById(id);
  }

  @Override
  public int save(Airport entity) {
    return this.airportService.save(entity);
  }

  @Override
  public int update(Integer id, Airport entity) {
    return this.airportService.update(id, entity);
  }

  @Override
  public void delete(Integer id) {
    this.airportService.delete(id);
  }
}
