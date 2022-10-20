package io.igorv404.flightradarback.pilot.implementation;

import io.igorv404.flightradarback.pilot.Pilot;
import io.igorv404.flightradarback.pilot.PilotRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PilotRepositoryImpl implements PilotRepository {
  private final JdbcTemplate jdbcTemplate;

  public PilotRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Pilot> findAll() {
    String FIND_ALL = "SELECT * FROM pilot";
    return this.jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Pilot.class));
  }

  @Override
  public Optional<Pilot> findById(Integer id) {
    String FIND_BY_ID = "SELECT * FROM pilot WHERE id=?";
    try {
      return Optional.ofNullable(this.jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(Pilot.class), id));
    } catch (EmptyResultDataAccessException e) {
      return Optional.empty();
    }
  }

  @Override
  public int save(Pilot entity) {
    String CREATE = "INSERT INTO pilot VALUES (?, ?, ?, ?, ?)";
    return this.jdbcTemplate.update(CREATE, null, entity.getName(), entity.getSurname(), entity.getAge(), entity.getFlightExperience());
  }

  @Override
  public int update(Integer id, Pilot entity) {
    String UPDATE = "UPDATE pilot SET name=?, surname=?, age=?, flight_experience=? WHERE id=?";
    return this.jdbcTemplate.update(UPDATE, entity.getName(), entity.getSurname(), entity.getAge(), entity.getFlightExperience(), id);
  }

  @Override
  public void delete(Integer id) {
    String DELETE = "DELETE FROM pilot WHERE id=?";
    this.jdbcTemplate.update(DELETE, id);
  }

  @Override
  public List<Pilot> findBySurname(String surname) {
    String FIND_BY_SURNAME = "SELECT * FROM pilot WHERE surname=?";
    return this.jdbcTemplate.query(FIND_BY_SURNAME, BeanPropertyRowMapper.newInstance(Pilot.class), surname);
  }
}
