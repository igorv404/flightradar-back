package io.igorv404.flightradarback.pilot.implementation;

import io.igorv404.flightradarback.pilot.Pilot;
import io.igorv404.flightradarback.pilot.PilotRepository;
import io.igorv404.flightradarback.pilot.PilotService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PilotServiceImpl implements PilotService {
  private final PilotRepository pilotRepository;

  public PilotServiceImpl(@Qualifier("pilotRepositoryImpl") PilotRepository pilotRepository) {
    this.pilotRepository = pilotRepository;
  }

  @Override
  public List<Pilot> findAll() {
    return this.pilotRepository.findAll();
  }

  @Override
  public Optional<Pilot> findById(Integer id) {
    return this.pilotRepository.findById(id);
  }

  @Override
  public int save(Pilot entity) {
    return this.pilotRepository.save(entity);
  }

  @Override
  public int update(Integer id, Pilot entity) {
    return this.pilotRepository.update(id, entity);
  }

  @Override
  public void delete(Integer id) {
    this.pilotRepository.delete(id);
  }

  @Override
  public List<Pilot> findBySurname(String surname) {
    return this.pilotRepository.findBySurname(surname);
  }
}
