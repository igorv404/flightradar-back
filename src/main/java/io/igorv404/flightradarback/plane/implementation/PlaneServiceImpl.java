package io.igorv404.flightradarback.plane.implementation;

import io.igorv404.flightradarback.plane.Plane;
import io.igorv404.flightradarback.plane.PlaneRepository;
import io.igorv404.flightradarback.plane.PlaneService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaneServiceImpl implements PlaneService {
  private final PlaneRepository planeRepository;

  public PlaneServiceImpl(@Qualifier("planeRepositoryImpl") PlaneRepository planeRepository) {
    this.planeRepository = planeRepository;
  }

  @Override
  public List<Plane> findAll() {
    return this.planeRepository.findAll();
  }

  @Override
  public Optional<Plane> findById(Integer id) {
    return this.planeRepository.findById(id);
  }

  @Override
  public int save(Plane entity) {
    return this.planeRepository.save(entity);
  }

  @Override
  public int update(Integer id, Plane entity) {
    return this.planeRepository.update(id, entity);
  }

  @Override
  public void delete(Integer id) {
    this.planeRepository.delete(id);
  }

  @Override
  public List<Plane> findByModelName(String name) {
    return this.planeRepository.findByModelName(name);
  }

  @Override
  public List<Plane> findByCompanyName(String name) {
    return this.planeRepository.findByCompanyName(name);
  }
}
