package io.igorv404.flightradarback.terminal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Terminal {
  private Integer id;
  private Integer number;
  private Integer airportId;
}
