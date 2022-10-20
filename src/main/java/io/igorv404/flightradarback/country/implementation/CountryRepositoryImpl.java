package io.igorv404.flightradarback.country.implementation;

import io.igorv404.flightradarback.country.Country;
import io.igorv404.flightradarback.country.CountryRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryRepositoryImpl implements CountryRepository {
  private final JdbcTemplate jdbcTemplate;

  public CountryRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Country> findAll() {
    String FIND_ALL = "SELECT * FROM country";
    return this.jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Country.class));
  }

  @Override
  public Optional<Country> findById(String name) {
    String FIND_BY_ID = "SELECT * FROM country WHERE name=?";
    try {
      return Optional.ofNullable(this.jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(Country.class), name));
    } catch (EmptyResultDataAccessException e) {
      return Optional.empty();
    }
  }

  @Override
  public int save(Country entity) {
    String CREATE = "INSERT country(name) VALUES (?)";
    return this.jdbcTemplate.update(CREATE, entity.getName());
  }

  @Override
  public int update(String name, Country entity) {
    String UPDATE = "UPDATE country SET name=? WHERE name=?";
    return this.jdbcTemplate.update(UPDATE, entity.getName(), name);
  }

  @Override
  public void delete(String name) {
    String DELETE = "DELETE FROM country WHERE name=?";
    this.jdbcTemplate.update(DELETE, name);
  }
}
