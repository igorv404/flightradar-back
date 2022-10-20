package io.igorv404.flightradarback.terminal.implementation;

import io.igorv404.flightradarback.terminal.Terminal;
import io.igorv404.flightradarback.terminal.TerminalRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerminalRepositoryImpl implements TerminalRepository {
  private final JdbcTemplate jdbcTemplate;

  public TerminalRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Terminal> findAll() {
    String FIND_ALL = "SELECT * FROM terminal";
    return this.jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Terminal.class));
  }

  @Override
  public Optional<Terminal> findById(Integer id) {
    String FIND_BY_ID = "SELECT * FROM terminal WHERE id=?";
    try {
      return Optional.ofNullable(this.jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(Terminal.class), id));
    } catch (EmptyResultDataAccessException e) {
      return Optional.empty();
    }
  }

  @Override
  public int save(Terminal entity) {
    String CREATE = "INSERT INTO terminal VALUES (?, ?, ?)";
    return this.jdbcTemplate.update(CREATE, null, entity.getNumber(), entity.getAirportId());
  }

  @Override
  public int update(Integer id, Terminal entity) {
    String UPDATE = "UPDATE terminal SET number=? WHERE id=?";
    return this.jdbcTemplate.update(UPDATE, entity.getNumber(), id);
  }

  @Override
  public void delete(Integer id) {
    String DELETE = "DELETE FROM terminal WHERE id=?";
    this.jdbcTemplate.update(DELETE, id);
  }
}
