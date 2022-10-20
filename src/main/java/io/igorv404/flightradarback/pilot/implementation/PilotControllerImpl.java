package io.igorv404.flightradarback.pilot.implementation;

import io.igorv404.flightradarback.pilot.Pilot;
import io.igorv404.flightradarback.pilot.PilotController;
import io.igorv404.flightradarback.pilot.PilotService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PilotControllerImpl implements PilotController {
  private final PilotService pilotService;

  public PilotControllerImpl(PilotService pilotService) {
    this.pilotService = pilotService;
  }

  @Override
  public List<Pilot> findBySurname(String surname) {
    return this.pilotService.findBySurname(surname);
  }

  @Override
  public List<Pilot> findAll() {
    return this.pilotService.findAll();
  }

  @Override
  public Optional<Pilot> findById(Integer id) {
    return this.pilotService.findById(id);
  }

  @Override
  public int save(Pilot entity) {
    return this.pilotService.save(entity);
  }

  @Override
  public int update(Integer id, Pilot entity) {
    return this.pilotService.update(id, entity);
  }

  @Override
  public void delete(Integer id) {
    this.pilotService.delete(id);
  }
}
