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

  public void tournerVersLaGauche() {
    switch (orientation){
    case NORD:
      orientation = Orientation.OUEST;
      break;
    case OUEST:
      orientation = Orientation.SUD;
      break;
    case SUD:
      orientation = Orientation.EST;
      break;
    case EST:
      orientation = Orientation.NORD;
      break;
    }
  }
}
