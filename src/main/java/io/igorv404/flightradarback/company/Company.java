package io.igorv404.flightradarback.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
  private String name;
  private String countryName;
  private Integer countOfPlane;
}
