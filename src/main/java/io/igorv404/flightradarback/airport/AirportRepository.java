package io.igorv404.flightradarback.airport;

import io.igorv404.flightradarback.templates.RepositoryTemplate;

import java.util.List;

public interface AirportRepository extends RepositoryTemplate<Airport, Integer> {
  List<Airport> findByName(String name);
}
