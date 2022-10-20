package io.igorv404.flightradarback.flight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
  private Integer id;
  private Integer pilotId;
  private Integer planeId;
  private Integer startTerminal;
  private Integer endTerminal;
  private Date data;
  private Time time;
  private Integer price;
}
