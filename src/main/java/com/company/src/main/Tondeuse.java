package com.company.src.main;


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

  public Tondeuse(int cordX, int cordY, Orientation orientation) {
    this.cordX = cordX;
    this.cordY = cordY;
    this.orientation = orientation;
  }

  public void tournerVersLaGauche() {
    switch (orientation){
    case NORD:
      this.orientation = Orientation.OUEST;
      break;
    case OUEST:
      this.orientation = Orientation.SUD;
      break;
    case SUD:
      this.orientation = Orientation.EST;
      break;
    case EST:
      this.orientation = Orientation.NORD;
      break;
    }
  }

  public void tournerVersLaDroite() {
    switch (orientation){
    case NORD:
      this.orientation = Orientation.EST;
      break;
    case EST:
      this.orientation = Orientation.SUD;
      break;
    case SUD:
      this.orientation = Orientation.OUEST;
      break;
    case OUEST:
      this.orientation = Orientation.NORD;
      break;
    }
  }

  public void avancer(Pelouse pelouse) {
    switch (orientation){
    case NORD:
      if (pelouse.cordY == this.cordY){
        this.position = Arrays.asList(this.cordX, this.cordY);
        break;
      }
      else {
        this.position = Arrays.asList(this.cordX, this.cordY = this.cordY + 1);
        break;
      }
    case OUEST:
      if (cordX == 0) {
        this.position = Arrays.asList(this.cordX, this.cordY);
        break;
      }
      else{
        this.position = Arrays.asList(this.cordX = this.cordX - 1, this.cordY);
        break;
      }
    case EST:
      if (pelouse.cordX == this.cordX){
        this.position = Arrays.asList(this.cordX, this.cordY);
        break;
      }
      else {
        this.position = Arrays.asList(this.cordX = this.cordX + 1, this.cordY);
        break;
      }
    case SUD:
      if (cordY == 0) {
        this.position = Arrays.asList(this.cordX, this.cordY);
        break;
      }
      else {
        this.position = Arrays.asList(this.cordX, this.cordY = this.cordY - 1);
        break;
      }
    }
  }

  public String toString(){
    return String.valueOf(this.cordX) + " " + String.valueOf(this.cordY) + " " + this.orientation.toString();
  }
}
