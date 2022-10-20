package io.igorv404.flightradarback.city;

import io.igorv404.flightradarback.templates.ServiceTemplate;

import java.util.List;

public interface CityService extends ServiceTemplate<City, Integer> {
  List<City> findByName(String name);
}
