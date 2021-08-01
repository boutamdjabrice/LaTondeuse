package com.company.test;

import com.company.src.main.*;
import junit.framework.TestCase;
import static org.assertj.core.api.Assertions.assertThat;



public class TraitementTest extends TestCase {

  Traitement traitement = new Traitement();

  public void testInitialisationDeLaTondeuseDepuisLeFichier(){
    assertThat(new Tondeuse(1, 2, Orientation.NORD)).isEqualToIgnoringGivenFields(traitement.initialisationDeLaTondeuse("1 2 N"), "position");
  }

  public void testTraitementDeLaSerieInstructionPourLaTondeuse(){
    Tondeuse tondeuse = new Tondeuse(3,3, Orientation.EST);
    Pelouse pelouse = new Pelouse(5,5);
    assertEquals(new Tondeuse(5,1,Orientation.EST).toString(), traitement.serieInstruction(tondeuse, "AADAADADDA",pelouse));
  }

}