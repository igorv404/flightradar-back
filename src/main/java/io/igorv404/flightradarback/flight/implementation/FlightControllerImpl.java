package io.igorv404.flightradarback.flight.implementation;

import io.igorv404.flightradarback.flight.Flight;
import io.igorv404.flightradarback.flight.FlightController;
import io.igorv404.flightradarback.flight.FlightService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FlightControllerImpl implements FlightController {
  private final FlightService flightService;

  public FlightControllerImpl(FlightService flightService) {
    this.flightService = flightService;
  }

  @Override
  public List<Flight> findByDate(Date date) {
    return this.flightService.findByDate(date);
  }

  @Override
  public List<Flight> findAll() {
    return this.flightService.findAll();
  }

  @Override
  public Optional<Flight> findById(Integer id) {
    return this.flightService.findById(id);
  }

  @Override
  public int save(Flight entity) {
    return this.flightService.save(entity);
  }

  @Override
  public int update(Integer id, Flight entity) {
    return this.flightService.update(id, entity);
  }

  @Override
  public void delete(Integer id) {
    this.flightService.delete(id);
  }
}
