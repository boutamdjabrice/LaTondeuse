package com.company.test;

import com.company.src.main.Orientation;
import com.company.src.main.Tondeuse;
import junit.framework.TestCase;
import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

public class TraitementTest extends TestCase {

  public void testInitialisationDeLaTondeuseDepuisLeFichier(){
    assertEquals(new Tondeuse(1, 2, Orientation.NORD), traitement.initialisationDeLaTondeuse());
  }

}