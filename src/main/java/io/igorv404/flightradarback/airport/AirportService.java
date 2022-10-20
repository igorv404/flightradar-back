package io.igorv404.flightradarback.airport;

import io.igorv404.flightradarback.templates.ServiceTemplate;

import java.util.List;

public interface AirportService extends ServiceTemplate<Airport, Integer> {
  List<Airport> findByName(String name);
}
