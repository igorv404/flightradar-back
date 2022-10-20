package io.igorv404.flightradarback.pilot;

import io.igorv404.flightradarback.templates.ControllerTemplate;

import java.util.List;

public interface PilotController extends ControllerTemplate<Pilot, Integer> {
  List<Pilot> findBySurname(String surname);
}
