package io.igorv404.flightradarback.airport;

import io.igorv404.flightradarback.templates.ControllerTemplate;

import java.util.List;

public interface AirportController extends ControllerTemplate<Airport, Integer> {
  List<Airport> findByName(String name);
}
