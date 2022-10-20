package io.igorv404.flightradarback.model.implementation;

import io.igorv404.flightradarback.model.Model;
import io.igorv404.flightradarback.model.ModelRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelRepositoryImpl implements ModelRepository {
  private final JdbcTemplate jdbcTemplate;

  public ModelRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Model> findAll() {
    String FIND_ALL = "SELECT * FROM model";
    return this.jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Model.class));
  }

  @Override
  public Optional<Model> findById(String name) {
    String FIND_BY_NAME = "SELECT * FROM model WHERE name=?";
    try {
      return Optional.ofNullable(this.jdbcTemplate.queryForObject(FIND_BY_NAME, BeanPropertyRowMapper.newInstance(Model.class), name));
    } catch (EmptyResultDataAccessException e) {
      return Optional.empty();
    }
  }

  @Override
  public int save(Model entity) {
    String CREATE = "INSERT INTO model VALUES (?, ?, ?, ?)";
    return this.jdbcTemplate.update(CREATE, entity.getName(), entity.getLength(), entity.getWingspan(), entity.getCountOfSeats());
  }

  @Override
  public int update(String name, Model entity) {
    String UPDATE = "UPDATE model SET length=?, wingspan=?, count_of_seats=? WHERE name=?";
    return this.jdbcTemplate.update(UPDATE, entity.getLength(), entity.getWingspan(), entity.getCountOfSeats(), name);
  }

  @Override
  public void delete(String name) {
    String DELETE = "DELETE FROM model WHERE name=?";
    this.jdbcTemplate.update(DELETE, name);
  }
}
