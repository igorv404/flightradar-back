package io.igorv404.flightradarback.flight.implementation;

import io.igorv404.flightradarback.flight.Flight;
import io.igorv404.flightradarback.flight.FlightRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FlightRepositoryImpl implements FlightRepository {
  private final JdbcTemplate jdbcTemplate;

  public FlightRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Flight> findAll() {
    String FIND_ALL = "SELECT * FROM flight";
    return this.jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Flight.class));
  }

  @Override
  public Optional<Flight> findById(Integer id) {
    String FIND_BY_ID = "SELECT * FROM flight WHERE id=?";
    try {
      return Optional.ofNullable(this.jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(Flight.class), id));
    } catch (EmptyResultDataAccessException e) {
      return Optional.empty();
    }
  }

  @Override
  public int save(Flight entity) {
    String CREATE = "INSERT INTO flight VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    return this.jdbcTemplate.update(CREATE, null, entity.getPilotId(), entity.getPlaneId(), entity.getStartTerminal(), entity.getEndTerminal(), entity.getData(), entity.getTime(), entity.getPrice());
  }

  @Override
  public int update(Integer id, Flight entity) {
    String UPDATE = "UPDATE flight SET pilot_id=?, plane_id=?, start_terminal=?, end_terminal=?, data=?, time=?, price=? WHERE id=?";
    return this.jdbcTemplate.update(UPDATE, entity.getPilotId(), entity.getPlaneId(), entity.getStartTerminal(), entity.getEndTerminal(), entity.getData(), entity.getTime(), entity.getPrice(), id);
  }

  @Override
  public void delete(Integer id) {
    String DELETE = "DELETE FROM flight WHERE id=?";
    this.jdbcTemplate.update(DELETE, id);
  }

  @Override
  public List<Flight> findByDate(Date date) {
    String FIND_BY_SURNAME = "SELECT * FROM flight WHERE data=?";
    return this.jdbcTemplate.query(FIND_BY_SURNAME, BeanPropertyRowMapper.newInstance(Flight.class), date);
  }
}
