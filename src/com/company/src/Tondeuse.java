package com.company.src;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class Tondeuse {

  int cordX;
  int cordY;
  Orientation orientation;
  List<Integer> position;

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

  public void tournerVersLaDroite() {
    switch (orientation){
    case NORD:
      orientation = Orientation.EST;
      break;
    case EST:
      orientation = Orientation.SUD;
      break;
    case SUD:
      orientation = Orientation.OUEST;
      break;
    case OUEST:
      orientation = Orientation.NORD;
      break;
    }
  }

  public void avancer() {
    switch (orientation){
    case NORD:
      position = Arrays.asList(this.cordX, this.cordY + 1);
      break;
    case OUEST:
      if (cordX == 0) {
        position = Arrays.asList(this.cordX, this.cordY);
        break;
      }
      else{
        position = Arrays.asList(this.cordX - 1, this.cordY);
        break;
      }
    case EST:
      position = Arrays.asList(this.cordX + 1, this.cordY);
      break;
    case SUD:
      if (cordY == 0) {
        position = Arrays.asList(this.cordX, this.cordY);
        break;
      }
      else {
        position = Arrays.asList(this.cordX, this.cordY - 1);
        break;
      }
    }
  }
}
