package io.igorv404.flightradarback.terminal.implementation;

import io.igorv404.flightradarback.terminal.Terminal;
import io.igorv404.flightradarback.terminal.TerminalController;
import io.igorv404.flightradarback.terminal.TerminalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerminalControllerImpl implements TerminalController {
  private final TerminalService terminalService;

  public TerminalControllerImpl(TerminalService terminalService) {
    this.terminalService = terminalService;
  }

  @Override
  public List<Terminal> findAll() {
    return this.terminalService.findAll();
  }

  @Override
  public Optional<Terminal> findById(Integer id) {
    return this.terminalService.findById(id);
  }

  @Override
  public int save(Terminal entity) {
    return this.terminalService.save(entity);
  }

  @Override
  public int update(Integer id, Terminal entity) {
    return this.terminalService.update(id, entity);
  }

  @Override
  public void delete(Integer id) {
    this.terminalService.delete(id);
  }
}
