package io.igorv404.flightradarback.airport.implementation;

import io.igorv404.flightradarback.airport.Airport;
import io.igorv404.flightradarback.airport.AirportRepository;
import io.igorv404.flightradarback.airport.AirportService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService {
  private final AirportRepository airportRepository;

  public AirportServiceImpl(@Qualifier("airportRepositoryImpl") AirportRepository airportRepository) {
    this.airportRepository = airportRepository;
  }

  @Override
  public List<Airport> findAll() {
    return this.airportRepository.findAll();
  }

  @Override
  public Optional<Airport> findById(Integer id) {
    return this.airportRepository.findById(id);
  }

  @Override
  public int save(Airport entity) {
    return this.airportRepository.save(entity);
  }

  @Override
  public int update(Integer id, Airport entity) {
    return this.airportRepository.update(id, entity);
  }

  @Override
  public void delete(Integer id) {
    this.airportRepository.delete(id);
  }

  @Override
  public List<Airport> findByName(String name) {
    return this.airportRepository.findByName(name);
  }
}
