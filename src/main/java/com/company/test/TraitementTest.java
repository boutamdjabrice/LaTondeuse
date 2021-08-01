package com.company.test;

import com.company.src.main.Fichier;
import com.company.src.main.Orientation;
import com.company.src.main.Tondeuse;
import com.company.src.main.Traitement;
import junit.framework.TestCase;

import org.junit.Assert;

import java.io.File;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;



public class TraitementTest extends TestCase {

  Traitement traitement = new Traitement();


  Fichier fichier = new Fichier();

  List<String> ligne;

  /*public void setUp(){
    String path = "src/main/java/com/company/test/ressources/Itineraire.txt";
    File file = new File(path);
    String absolutePath = file.getAbsolutePath();
    ligne = fichier.OuvrirFichier(absolutePath);
  }*/

  public void testInitialisationDeLaTondeuseDepuisLeFichier(){
    assertThat(new Tondeuse(1, 2, Orientation.NORD)).isEqualToIgnoringGivenFields(traitement.initialisationDeLaTondeuse("1 2 N"), "position");
  }

  public void testTraitementDeLaSerieInstructionPourLaTondeuse(){
    assertEquals(new Tondeuse(1,3,Orientation.NORD).toString(), traitement.serieInstruction("GAGAGAGAA"));
  }

}