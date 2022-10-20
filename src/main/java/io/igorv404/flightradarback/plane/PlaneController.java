package io.igorv404.flightradarback.plane;

import io.igorv404.flightradarback.templates.ControllerTemplate;

import java.util.List;

public interface PlaneController extends ControllerTemplate<Plane, Integer> {
  List<Plane> findByModelName(String name);

  List<Plane> findByCompanyName(String name);
}
