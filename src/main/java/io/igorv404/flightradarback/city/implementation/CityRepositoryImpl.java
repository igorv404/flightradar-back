package io.igorv404.flightradarback.city.implementation;

import io.igorv404.flightradarback.city.City;
import io.igorv404.flightradarback.city.CityRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityRepositoryImpl implements CityRepository {
  private final JdbcTemplate jdbcTemplate;

  public CityRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<City> findAll() {
    String FIND_ALL = "SELECT * FROM city";
    return this.jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(City.class));
  }

  @Override
  public Optional<City> findById(Integer id) {
    String FIND_BY_ID = "SELECT * FROM city WHERE id=?";
    try {
      return Optional.ofNullable(this.jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(City.class), id));
    } catch (EmptyResultDataAccessException e) {
      return Optional.empty();
    }
  }

  @Override
  public List<City> findByName(String name) {
    String FIND_BY_NAME = "SELECT * FROM city WHERE name=?";
    return this.jdbcTemplate.query(FIND_BY_NAME, BeanPropertyRowMapper.newInstance(City.class), name);
  }

  @Override
  public int save(City entity) {
    String CREATE = "INSERT INTO city VALUES (?, ?, ?)";
    return this.jdbcTemplate.update(CREATE, null, entity.getName(), entity.getCountryName());
  }

  @Override
  public int update(Integer id, City entity) {
    String UPDATE = "UPDATE city SET name=? WHERE id=?";
    return this.jdbcTemplate.update(UPDATE, entity.getName(), id);
  }

  @Override
  public void delete(Integer id) {
    String DELETE = "DELETE FROM city WHERE id=?";
    this.jdbcTemplate.update(DELETE, id);
  }
}
