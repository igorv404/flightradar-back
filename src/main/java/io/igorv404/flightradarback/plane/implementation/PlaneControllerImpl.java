package io.igorv404.flightradarback.plane.implementation;

import io.igorv404.flightradarback.plane.Plane;
import io.igorv404.flightradarback.plane.PlaneController;
import io.igorv404.flightradarback.plane.PlaneService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaneControllerImpl implements PlaneController {
  private final PlaneService planeService;

  public PlaneControllerImpl(PlaneService planeService) {
    this.planeService = planeService;
  }

  @Override
  public List<Plane> findByModelName(String name) {
    return this.planeService.findByModelName(name);
  }

  @Override
  public List<Plane> findByCompanyName(String name) {
    return this.planeService.findByCompanyName(name);
  }

  @Override
  public List<Plane> findAll() {
    return this.planeService.findAll();
  }

  @Override
  public Optional<Plane> findById(Integer id) {
    return this.planeService.findById(id);
  }

  @Override
  public int save(Plane entity) {
    return this.planeService.save(entity);
  }

  @Override
  public int update(Integer id, Plane entity) {
    return this.planeService.update(id, entity);
  }

  @Override
  public void delete(Integer id) {
    this.planeService.delete(id);
  }
}
