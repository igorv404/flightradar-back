package io.igorv404.flightradarback.templates;

import java.util.List;
import java.util.Optional;

public interface RepositoryTemplate<T, ID> {
  List<T> findAll();

  Optional<T> findById(ID id);

  int save(T entity);

  int update(ID id, T entity);

  void delete(ID id);
}
