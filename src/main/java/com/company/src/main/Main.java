package com.company.src.main;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;

import static java.lang.System.exit;

public class Main {

    final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("------------ Debut du programme ----------------");
        // args[0] = "D:\programme\workspaceGitMoi\LaTondeuse\src\main\resources\Itineraire.txt";
        File file = new File(args[0]);
        String absolutePath = file.getAbsolutePath();
        Fichier fichier = new Fichier();
        List<String> lignes = fichier.OuvrirFichier(absolutePath);
        try {
            fichier.testDuFormat(lignes);
        } catch (IOException e) {
            logger.error("Erreur attrapée au niveau du test de si le fichier à le bon format : "+ e);
            logger.error("-------------- fin suite à l'erreur ----------------------");
            exit(1);
        }
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
                logger.info("La tondeuse "+count+" commence à la position : "+tondeuse.toString());
                System.out.println("------------------------------------------------------------------------------------- La tondeuse "+count+" commence à la position : "+tondeuse.toString());
            } else if (entry.getKey() % 2 == 1){
                String positionFinal = traitement.serieInstruction(tondeuse, entry.getValue(), pelouse);
                logger.info("La tondeuse "+count+" finit à la position : "+positionFinal);
                System.out.println("------------------------------------------------------------------------------------- La tondeuse "+count+" finit à la position : "+positionFinal);
                count++;
                tondeuse = new Tondeuse();
            }
        }
        logger.info("------------ fin du programme ----------------");
        exit(0);
    }
}
