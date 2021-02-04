package com.company.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class MapModel {


    private int[][] map;
    private String fichierDuTerrain;


    public MapModel() {
        fichierDuTerrain = "src/com/company/map.txt";
        map = new int[50][50];
    }

    public void initMap() {// peut lancer une exception
        File fichier = new File(fichierDuTerrain);
        String ligne = "";
        BufferedReader lecteurFichier;
        try {
            lecteurFichier = new BufferedReader(new FileReader(fichier));

            int i = 0;
            StringTokenizer st = new StringTokenizer(ligne, ",");

            do {
                int j = 0;
                try {
                    ligne = lecteurFichier.readLine();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if (ligne != null) {

                    st = new StringTokenizer(ligne, ",");


                    while (st.hasMoreTokens()) {

                        map[i][j] = Integer.parseInt(st.nextToken(","));
                        //						System.out.println(j+"j");
                        //						System.out.println(i);
                        j++;
                    }
                    System.out.println(ligne);
                    i++;

                }


            } while (ligne != null);

            try {
                lecteurFichier.close();
            } catch (IOException e) {
                System.out.println("LecteurFichier bug");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erreur initMapLogique");
        }
    }


    public int[][] getMap() {
        return map;
    }

}





