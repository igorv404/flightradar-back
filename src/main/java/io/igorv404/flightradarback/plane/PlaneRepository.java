package io.igorv404.flightradarback.plane;

import io.igorv404.flightradarback.templates.RepositoryTemplate;

import java.util.List;

public interface PlaneRepository extends RepositoryTemplate<Plane, Integer> {
  List<Plane> findByModelName(String name);

  List<Plane> findByCompanyName(String name);
}
