package com.company.src.main;

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

  public List<String> OuvrirFichier(String path) {
    List<String> list = new ArrayList<>();
    try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {

      list = br.lines().collect(Collectors.toList());

    } catch (IOException e) {
      e.printStackTrace();
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
}
