package org.example;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Esta clase contiene una version que resuelve el problema 260 de Acepta el reto, aunque esta versión en el Juez da TLE.
 * @author Jacobo San Mauro Martínez
 * @version 1.0 (17/12/2024)
 */

public class Proyecto_Alan_Smithee_short {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        int pruebas = read.nextInt();
        read.nextLine();

        for (int i = 0; i < pruebas; i++) {

            String frase1 = read.nextLine().toLowerCase().replace(" ", "");
            String frase2 = read.nextLine().toLowerCase().replace(" ", "");

            String[] frase1_vector = frase1.split("");
            String[] frase2_vector = frase2.split("");

            if (frase1_vector.length != frase2_vector.length){

                System.out.println("NO");

            } else {

                Arrays.sort(frase1_vector);
                Arrays.sort(frase2_vector);

                boolean anagrama = true;
                for (int j = 0; j <frase1_vector.length ; j++) {

                    if (frase1_vector[j].equals(frase2_vector[j])){

                    }else {
                        anagrama = false;
                        break;
                    }

                }

                if (anagrama){

                    System.out.println("SI");

                }else {

                    System.out.println("NO");

                }

            }

        }

    }

}
