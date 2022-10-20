package io.igorv404.flightradarback.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Model {
  private String name;
  private Float length;
  private Float wingspan;
  private Integer countOfSeats;
}
