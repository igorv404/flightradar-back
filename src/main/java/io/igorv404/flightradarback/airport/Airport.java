package io.igorv404.flightradarback.airport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airport {
  private Integer id;
  private String name;
  private Integer cityId;
}
