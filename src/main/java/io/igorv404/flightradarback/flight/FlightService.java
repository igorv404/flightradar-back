package io.igorv404.flightradarback.flight;

import io.igorv404.flightradarback.templates.ServiceTemplate;

import java.util.Date;
import java.util.List;

public interface FlightService extends ServiceTemplate<Flight, Integer> {
  List<Flight> findByDate(Date date);
}
