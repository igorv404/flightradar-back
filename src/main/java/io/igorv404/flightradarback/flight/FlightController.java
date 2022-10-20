package io.igorv404.flightradarback.flight;

import io.igorv404.flightradarback.templates.ControllerTemplate;

import java.util.Date;
import java.util.List;

public interface FlightController extends ControllerTemplate<Flight, Integer> {
  List<Flight> findByDate(Date date);
}
