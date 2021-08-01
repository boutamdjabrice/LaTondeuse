package com.company.src.main;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Fichier {

  final static Logger logger = Logger.getLogger(Fichier.class);

  public List<String> OuvrirFichier(String path) {
    List<String> list = new ArrayList<>();
    try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {

      list = br.lines().collect(Collectors.toList());

    } catch (IOException e) {
      logger.error("Fichier introuvable : " + e);
    }
    return list;
  }

  public Map<Integer, String> TransformationEnMapSansPremiereLigne(List<String> list){
    Map<Integer, String> map = new HashMap<>();
    int count = 0;
    for (int i = 0; i < list.size(); i++){
      if (i % 2 == 1){
        map.put(count, list.get(i));
        count++;
        map.put(count,list.get(i+1));
        count++;
      }
    }
    return map;
  }

  public void testDuFormat(List<String> lignes) throws IOException {
    if (lignes.size() % 2 == 0)
        throw new IOException("Nombre de ligne paire");
  }
}
