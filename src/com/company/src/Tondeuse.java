package com.company.src;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tondeuse {

  int cordX;
  int cordY;
  Orientation orientation;
  String mouvement;

  public Tondeuse() {
  }

}
