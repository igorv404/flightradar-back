package io.igorv404.flightradarback.plane;

import io.igorv404.flightradarback.templates.ServiceTemplate;

import java.util.List;

public interface PlaneService extends ServiceTemplate<Plane, Integer> {
  List<Plane> findByModelName(String name);

  List<Plane> findByCompanyName(String name);
}
