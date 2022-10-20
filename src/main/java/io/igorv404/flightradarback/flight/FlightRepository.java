package io.igorv404.flightradarback.flight;

import io.igorv404.flightradarback.templates.RepositoryTemplate;

import java.util.Date;
import java.util.List;

public interface FlightRepository extends RepositoryTemplate<Flight, Integer> {
  List<Flight> findByDate(Date date);
}
