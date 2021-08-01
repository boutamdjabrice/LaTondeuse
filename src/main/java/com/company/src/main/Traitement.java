package com.company.src.main;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Traitement {

  final static Logger logger = Logger.getLogger(Traitement.class);

  public Tondeuse initialisationDeLaTondeuse(String  ligne) {
    List<String> elementSeparer = Arrays.asList(ligne.split(" "));
    Orientation orientation = null;
    switch (elementSeparer.get(2)) {
    case "N":
      orientation = Orientation.NORD;
      break;
    case "O":
      orientation = Orientation.OUEST;
      break;
    case "S":
      orientation = Orientation.SUD;
      break;
    case "E":
      orientation = Orientation.EST;
      break;
    }
    logger.info("La tondeuse est initialisée à la posistion : "+elementSeparer.get(0)+ " " + elementSeparer.get(1)+" "+orientation);
    return new Tondeuse(Integer.parseInt(elementSeparer.get(0)), Integer.parseInt(elementSeparer.get(1)), orientation);
  }

  public String serieInstruction(Tondeuse tondeuse, String serieInstruction, Pelouse pelouse) {
    String[] list = serieInstruction.split("(?!^)");
    for (String lettre: list) {
      switch (lettre){
      case "D":
        tondeuse.tournerVersLaDroite();
        logger.info("La tondeuse à tourner vers la droite");
        break;
      case "G":
        tondeuse.tournerVersLaGauche();
        logger.info("La tondeuse à tourner vers la gauche");
        break;
      case "A":
        tondeuse.avancer(pelouse);
        logger.info("La tondeuse à avancer");
        break;
      }
    }
      return tondeuse.toString();
    }

}
