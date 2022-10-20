package io.igorv404.flightradarback.terminal.implementation;

import io.igorv404.flightradarback.terminal.Terminal;
import io.igorv404.flightradarback.terminal.TerminalRepository;
import io.igorv404.flightradarback.terminal.TerminalService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerminalServiceImpl implements TerminalService {
  private final TerminalRepository terminalRepository;

  public TerminalServiceImpl(@Qualifier("terminalRepositoryImpl") TerminalRepository terminalRepository) {
    this.terminalRepository = terminalRepository;
  }

  @Override
  public List<Terminal> findAll() {
    return this.terminalRepository.findAll();
  }

  @Override
  public Optional<Terminal> findById(Integer id) {
    return this.terminalRepository.findById(id);
  }

  @Override
  public int save(Terminal entity) {
    return this.terminalRepository.save(entity);
  }

  @Override
  public int update(Integer id, Terminal entity) {
    return this.terminalRepository.update(id, entity);
  }

  @Override
  public void delete(Integer id) {
    this.terminalRepository.delete(id);
  }
}
