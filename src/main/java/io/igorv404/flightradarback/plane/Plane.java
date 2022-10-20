package io.igorv404.flightradarback.plane;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plane {
  private Integer id;
  private String modelName;
  private String companyName;
  private Integer speed;
  private Integer flightTime;
}
