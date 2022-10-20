package io.igorv404.flightradarback.flight.implementation;

import io.igorv404.flightradarback.flight.Flight;
import io.igorv404.flightradarback.flight.FlightRepository;
import io.igorv404.flightradarback.flight.FlightService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {
  private final FlightRepository flightRepository;

  public FlightServiceImpl(@Qualifier("flightRepositoryImpl") FlightRepository flightRepository) {
    this.flightRepository = flightRepository;
  }

  @Override
  public List<Flight> findAll() {
    return this.flightRepository.findAll();
  }

  @Override
  public Optional<Flight> findById(Integer id) {
    return this.flightRepository.findById(id);
  }

  @Override
  public int save(Flight entity) {
    return this.flightRepository.save(entity);
  }

  @Override
  public int update(Integer id, Flight entity) {
    return this.flightRepository.update(id, entity);
  }

  @Override
  public void delete(Integer id) {
    this.flightRepository.delete(id);
  }

  @Override
  public List<Flight> findByDate(Date date) {
    return this.flightRepository.findByDate(date);
  }
}
