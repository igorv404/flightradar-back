package io.igorv404.flightradarback.city;

import io.igorv404.flightradarback.templates.RepositoryTemplate;

import java.util.List;

public interface CityRepository extends RepositoryTemplate<City, Integer> {
  List<City> findByName(String name);
}
