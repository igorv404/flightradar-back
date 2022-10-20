package io.igorv404.flightradarback.plane.implementation;

import io.igorv404.flightradarback.plane.Plane;
import io.igorv404.flightradarback.plane.PlaneRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaneRepositoryImpl implements PlaneRepository {
  private final JdbcTemplate jdbcTemplate;

  public PlaneRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Plane> findAll() {
    String FIND_ALL = "SELECT * FROM plane";
    return this.jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Plane.class));
  }

  @Override
  public Optional<Plane> findById(Integer id) {
    String FIND_BY_ID = "SELECT * FROM plane WHERE id=?";
    try {
      return Optional.ofNullable(this.jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(Plane.class), id));
    } catch (EmptyResultDataAccessException e) {
      return Optional.empty();
    }
  }

  @Override
  public int save(Plane entity) {
    String CREATE = "INSERT INTO plane VALUES (?, ?, ?, ?, ?)";
    return this.jdbcTemplate.update(CREATE, null, entity.getModelName(), entity.getCompanyName(), entity.getSpeed(), entity.getFlightTime());
  }

  @Override
  public int update(Integer id, Plane entity) {
    String UPDATE = "UPDATE plane SET model_name=?, company_name=?, speed=?, flight_time=? WHERE id=?";
    return this.jdbcTemplate.update(UPDATE, entity.getModelName(), entity.getCompanyName(), entity.getSpeed(), entity.getFlightTime(), id);
  }

  @Override
  public void delete(Integer id) {
    String DELETE = "DELETE FROM plane WHERE id=?";
    this.jdbcTemplate.update(DELETE, id);
  }

  @Override
  public List<Plane> findByModelName(String name) {
    String FIND_BY_MODEL_NAME = "SELECT * FROM plane WHERE model_name=?";
    return this.jdbcTemplate.query(FIND_BY_MODEL_NAME, BeanPropertyRowMapper.newInstance(Plane.class), name);
  }

  @Override
  public List<Plane> findByCompanyName(String name) {
    String FIND_BY_COMPANY_NAME = "SELECT * FROM plane WHERE company_name=?";
    return this.jdbcTemplate.query(FIND_BY_COMPANY_NAME, BeanPropertyRowMapper.newInstance(Plane.class), name);
  }
}
