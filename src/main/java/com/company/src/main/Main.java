package com.company.src.main;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String path = "src/main/java/com/company/src/main/ressources/Itineraire.txt";
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();
        Fichier fichier = new Fichier();
        List<String> lignes = fichier.OuvrirFichier(absolutePath);
        List<Integer> dimensionPelouse = Arrays.asList(lignes.get(0).split(" ")).stream().map(Integer::parseInt).collect(
            Collectors.toList());
        Pelouse pelouse = new Pelouse(dimensionPelouse.get(0), dimensionPelouse.get(1));
        Map<Integer, String> mapIteneraire = fichier.TransformationEnMapSansPremiereLigne(lignes);
        Tondeuse tondeuse = new Tondeuse();
        Traitement traitement = new Traitement();
        int count = 1;

        for (var entry : mapIteneraire.entrySet()) {
            if (entry.getKey() % 2 == 0){
                tondeuse = traitement.initialisationDeLaTondeuse(entry.getValue());
                System.out.println("La tondeuse "+count+" commence à la position : "+tondeuse.toString());
            } else if (entry.getKey() % 2 == 1){
                String positionFinal = traitement.serieInstruction(tondeuse, entry.getValue(), pelouse);
                System.out.println("La tondeuse "+count+" finit à la position : "+positionFinal);
                count++;
                tondeuse = new Tondeuse();
            }
        }
    }
}
