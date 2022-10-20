package io.igorv404.flightradarback.airport.implementation;

import io.igorv404.flightradarback.airport.Airport;
import io.igorv404.flightradarback.airport.AirportRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportRepositoryImpl implements AirportRepository {
  private final JdbcTemplate jdbcTemplate;

  public AirportRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Airport> findAll() {
    String FIND_ALL = "SELECT * FROM airport";
    return this.jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Airport.class));
  }

  @Override
  public Optional<Airport> findById(Integer id) {
    String FIND_BY_ID = "SELECT * FROM airport WHERE id=?";
    try {
      return Optional.ofNullable(this.jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(Airport.class), id));
    } catch (EmptyResultDataAccessException e) {
      return Optional.empty();
    }
  }

  @Override
  public List<Airport> findByName(String name) {
    String FIND_BY_NAME = "SELECT * FROM airport WHERE name=?";
    return this.jdbcTemplate.query(FIND_BY_NAME, BeanPropertyRowMapper.newInstance(Airport.class), name);
  }

  @Override
  public int save(Airport entity) {
    String CREATE = "INSERT INTO airport VALUES (?, ?, ?)";
    return this.jdbcTemplate.update(CREATE, null, entity.getName(), entity.getCityId());
  }

  @Override
  public int update(Integer id, Airport entity) {
    String UPDATE = "UPDATE airport SET name=?, city_id=? WHERE id=?";
    return this.jdbcTemplate.update(UPDATE, entity.getName(), entity.getCityId(), id);
  }

  @Override
  public void delete(Integer id) {
    String DELETE = "DELETE FROM airport WHERE id=?";
    this.jdbcTemplate.update(DELETE, id);
  }
}
