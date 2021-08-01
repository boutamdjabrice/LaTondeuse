package com.company.src.main;


import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class Tondeuse {

  final static Logger logger = Logger.getLogger(Tondeuse.class);

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
      logger.info("La tondeuse passe de l'orientation Nord vers celle de l'Ouest");
      break;
    case OUEST:
      this.orientation = Orientation.SUD;
      logger.info("La tondeuse passe de l'orientation Ouest vers celle du Sud");
      break;
    case SUD:
      this.orientation = Orientation.EST;
      logger.info("La tondeuse passe de l'orientation Sud vers celle de l'Est");
      break;
    case EST:
      this.orientation = Orientation.NORD;
      logger.info("La tondeuse passe de l'orientation Est vers celle du Nord");
      break;
    }
  }

  public void tournerVersLaDroite() {
    switch (orientation){
    case NORD:
      this.orientation = Orientation.EST;
      logger.info("La tondeuse passe de l'orientation Nord vers celle de l'Est");
      break;
    case EST:
      this.orientation = Orientation.SUD;
      logger.info("La tondeuse passe de l'orientation Est vers celle du Sud");
      break;
    case SUD:
      this.orientation = Orientation.OUEST;
      logger.info("La tondeuse passe de l'orientation Sud vers celle de l'Ouest");
      break;
    case OUEST:
      this.orientation = Orientation.NORD;
      logger.info("La tondeuse passe de l'orientation Ouest vers celle du Nord");
      break;
    }
  }

  public void avancer(Pelouse pelouse) {
    switch (orientation){
    case NORD:
      if (pelouse.cordY == this.cordY) {
        this.position = Arrays.asList(this.cordX, this.cordY);
        logger.info("La tondeuse reste sur place car elle touche un bord de la pelouse");
      }
      else {
        this.position = Arrays.asList(this.cordX, this.cordY = this.cordY + 1);
        logger.info("La tondeuse avance vers le Nord");
      }
      break;
    case OUEST:
      if (cordX == 0) {
        this.position = Arrays.asList(this.cordX, this.cordY);
        logger.info("La tondeuse reste sur place car elle touche un bord de la pelouse");
      }
      else {
        this.position = Arrays.asList(this.cordX = this.cordX - 1, this.cordY);
        logger.info("La tondeuse avance vers l'Ouest");
      }
      break;
    case EST:
      if (pelouse.cordX == this.cordX) {
        this.position = Arrays.asList(this.cordX, this.cordY);
        logger.info("La tondeuse reste sur place car elle touche un bord de la pelouse");
      }
      else {
        this.position = Arrays.asList(this.cordX = this.cordX + 1, this.cordY);
        logger.info("La tondeuse avance vers l'Est");
      }
      break;
    case SUD:
      if (cordY == 0) {
        this.position = Arrays.asList(this.cordX, this.cordY);
        logger.info("La tondeuse reste sur place car elle touche un bord de la pelouse");
      }
      else {
        this.position = Arrays.asList(this.cordX, this.cordY = this.cordY - 1);
        logger.info("La tondeuse avance vers le Sud");
      }
      break;
    }
  }

  public String toString(){
    return this.cordX + " " + this.cordY + " " + this.orientation.getAbreviation();
  }
}
