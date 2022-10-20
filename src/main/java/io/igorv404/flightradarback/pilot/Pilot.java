package io.igorv404.flightradarback.pilot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pilot {
  private Integer id;
  private String name;
  private String surname;
  private Integer age;
  private Integer flightExperience;
}
