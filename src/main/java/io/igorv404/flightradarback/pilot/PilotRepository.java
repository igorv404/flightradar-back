package io.igorv404.flightradarback.pilot;

import io.igorv404.flightradarback.templates.RepositoryTemplate;

import java.util.List;

public interface PilotRepository extends RepositoryTemplate<Pilot, Integer> {
  List<Pilot> findBySurname(String surname);
}
