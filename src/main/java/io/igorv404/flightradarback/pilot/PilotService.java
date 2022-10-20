package io.igorv404.flightradarback.pilot;

import io.igorv404.flightradarback.templates.ServiceTemplate;

import java.util.List;

public interface PilotService extends ServiceTemplate<Pilot, Integer> {
  List<Pilot> findBySurname(String surname);
}
