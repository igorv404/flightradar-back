package io.igorv404.flightradarback.model.implementation;

import io.igorv404.flightradarback.model.Model;
import io.igorv404.flightradarback.model.ModelRepository;
import io.igorv404.flightradarback.model.ModelService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelServiceImpl implements ModelService {
  private final ModelRepository modelRepository;

  public ModelServiceImpl(@Qualifier("modelRepositoryImpl") ModelRepository modelRepository) {
    this.modelRepository = modelRepository;
  }

  @Override
  public List<Model> findAll() {
    return this.modelRepository.findAll();
  }

  @Override
  public Optional<Model> findById(String name) {
    return this.modelRepository.findById(name);
  }

  @Override
  public int save(Model entity) {
    return this.modelRepository.save(entity);
  }

  @Override
  public int update(String name, Model entity) {
    return this.modelRepository.update(name, entity);
  }

  @Override
  public void delete(String name) {
    this.modelRepository.delete(name);
  }
}
