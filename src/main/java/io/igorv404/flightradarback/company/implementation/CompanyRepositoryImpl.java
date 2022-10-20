package io.igorv404.flightradarback.company.implementation;

import io.igorv404.flightradarback.company.Company;
import io.igorv404.flightradarback.company.CompanyRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyRepositoryImpl implements CompanyRepository {
  private final JdbcTemplate jdbcTemplate;

  public CompanyRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Company> findAll() {
    String FIND_ALL = "SELECT * FROM company";
    return this.jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Company.class));
  }

  @Override
  public Optional<Company> findById(String name) {
    String FIND_BY_NAME = "SELECT * FROM company WHERE name=?";
    try {
      return Optional.ofNullable(this.jdbcTemplate.queryForObject(FIND_BY_NAME, BeanPropertyRowMapper.newInstance(Company.class), name));
    } catch (EmptyResultDataAccessException e) {
      return Optional.empty();
    }
  }

  @Override
  public int save(Company entity) {
    String CREATE = "INSERT INTO company VALUES (?, ?, ?)";
    return this.jdbcTemplate.update(CREATE, entity.getName(), entity.getCountryName(), entity.getCountOfPlane());
  }

  @Override
  public int update(String name, Company entity) {
    String UPDATE = "UPDATE company SET count_of_plane=? WHERE name=?";
    return this.jdbcTemplate.update(UPDATE, entity.getCountOfPlane(), name);
  }

  @Override
  public void delete(String name) {
    String DELETE = "DELETE FROM company WHERE name=?";
    this.jdbcTemplate.update(DELETE, name);
  }
}
