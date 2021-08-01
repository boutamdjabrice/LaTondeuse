package com.company.test;

import com.company.src.main.Fichier;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class FichierTest extends TestCase {

  Fichier fichier = new Fichier();

  List<String> ligne;

  public void setUp(){
    String path = "src/com/company/test/ressources/Itineraire.txt";
    File file = new File(path);
    String absolutePath = file.getAbsolutePath();
    ligne = fichier.OuvrirFichier(absolutePath);
  }

  public void testOuvrirFichierEstLirePremiereLigne(){
    assertEquals(Arrays.asList(5, 5), Arrays.asList(ligne.get(0).split(" ")).stream().map(Integer::parseInt).collect(
        Collectors.toList()));
  }

  @Test(expected= IOException.class)
  public void testOuvrirFichierEstNeLeTrouvePas(){
    String path = "src/com/company/test/ressources/Itineraires.txt";
    File file = new File(path);
    String absolutePath = file.getAbsolutePath();
    List<String> ligneFausse = fichier.OuvrirFichier(absolutePath);
  }

  public void testLectureDesLignesSuivanteDuFichierDeDeuxEnDeuxApresLaPremiereLigne(){
    Map<Integer, String> resultat = fichier.TransformationEnMapSansPremiereLigne(ligne);
    Map<Integer, String> attendu = new HashMap<>();
    attendu.put(0, "1 2 N");
    attendu.put(1, "GAGAGAGAA");
    attendu.put(2, "3 3 E");
    attendu.put(3, "AADAADADDA");
    assertEquals(attendu,resultat);
  }

  @Test(expected= IOException.class)
  public void testLeFormatDuFichierEstImpaire(){
    String path = "src/com/company/test/ressources/ItinerairePaire.txt";
    File file = new File(path);
    String absolutePath = file.getAbsolutePath();
    List<String> ligneFausse = fichier.OuvrirFichier(absolutePath);
    fichier.testDuFormat(ligne);
  }

}