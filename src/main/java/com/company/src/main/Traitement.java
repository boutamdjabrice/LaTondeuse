package com.company.src.main;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Traitement {

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
    return new Tondeuse(Integer.parseInt(elementSeparer.get(0)), Integer.parseInt(elementSeparer.get(1)), orientation);
  }

  public String serieInstruction(Tondeuse tondeuse, String serieInstruction, Pelouse pelouse) {
    String[] list = serieInstruction.split("(?!^)");
    for (String lettre: list) {
      switch (lettre){
      case "D":
        tondeuse.tournerVersLaDroite();
        break;
      case "G":
        tondeuse.tournerVersLaGauche();
        break;
      case "A":
        tondeuse.avancer(pelouse);
        break;
      }
    }
      return tondeuse.toString();
    }

}
