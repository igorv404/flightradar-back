package io.igorv404.flightradarback.city;

import io.igorv404.flightradarback.templates.ControllerTemplate;

import java.util.List;

public interface CityController extends ControllerTemplate<City, Integer> {
  List<City> findByName(String name);
}
