package io.igorv404.flightradarback.model.implementation;

import io.igorv404.flightradarback.model.Model;
import io.igorv404.flightradarback.model.ModelController;
import io.igorv404.flightradarback.model.ModelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelControllerImpl implements ModelController {
  private final ModelService modelService;

  public ModelControllerImpl(ModelService modelService) {
    this.modelService = modelService;
  }

  @Override
  public List<Model> findAll() {
    return this.modelService.findAll();
  }

  @Override
  public Optional<Model> findById(String name) {
    return this.modelService.findById(name);
  }

  @Override
  public int save(Model entity) {
    return this.modelService.save(entity);
  }

  @Override
  public int update(String name, Model entity) {
    return this.modelService.update(name, entity);
  }

  @Override
  public void delete(String name) {
    this.modelService.delete(name);
  }
}
