package org.example;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta clase contiene una versión con métodos que resuelve el problema 260 de Acepta el reto, aunque esta versión en el Juez da TLE.
 * @author : Jacobo San Mauro Martínez
 * @version : 1.0 (17/12/2024)
 *
 */

public class Proyecto_Alan_Smithee_short_metodos {

    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {

        int pruebas = 0;

        System.out.println("Cuantas pruebas quieres hacer?");
        try {

            pruebas = read.nextInt();
            read.nextLine();

        }catch (InputMismatchException e){

            System.out.println("El numero de pruebas no ha sido reconocido");
            return;

        }


        for (int i = 0; i < pruebas; i++) {

            String frase1 = Leer_QuitarEspacios_Minusculas();
            String frase2 = Leer_QuitarEspacios_Minusculas();

            if (!Validar_Longitud(frase1) || !Validar_Longitud(frase2) ){

                System.out.println("No puedes poner mas de 1000 caracteres ( contando espacios ) en cualquiera de las frases");
                break;

            }

            if (!Validar_Letras(frase1) || !Validar_Letras(frase2)){

                System.out.println("Solo puedes utilizar caracteres!");
                break;

            }

            String[] frase1_vector = CovertirVector_Con_Split(frase1);
            String[] frase2_vector = CovertirVector_Con_Split(frase2);

            if (!Validar_Vectores_MismaLongitud(frase1,frase2)){

                System.out.println("NO");

            } else {

                ordenar(frase1_vector, frase2_vector);

                if (Recorrer_2_Vectores_Y_Comparar(frase1_vector, frase2_vector)){

                    System.out.println("SI");

                }else {

                    System.out.println("NO");

                }

            }

        }

    }

    /**
     * @return este metodo devuelve un String que nosotros hemos escrito por pantalla quitandole los espacios y pasandolo a minusculas
     */

    public static String Leer_QuitarEspacios_Minusculas (){

        return read.nextLine().toLowerCase().replace(" ", "");

    }

    /**
     *
     * @param longitud este parametro es un String que recoge el String que nosotros le pasemos
     * @return Devuelve un true o un false dependiendo de si nuestro parametro es mayor o menor a 1000 caracteres
     */

    public static boolean Validar_Longitud (String longitud){

        return longitud.length() <= 1000;

    }

    /**
     *
     * @param letras es un parametro tipo String que recoge el String que le pasemos
     * @return Este devuelve un true o un false dependiendo de si el contenido de el String contiene solo letras del alfabeto Ingles o no ( no coge acentos )
     */

    public static boolean Validar_Letras (String letras){

        return letras.matches("[a-z]+");

    }

    /**
     *
     * @param convertir es un parametro de String que recoge el String que le pasemos
     * @return este devuelve un vector spliteado por "" que recoge un vector arriba
     */

    public static String[] CovertirVector_Con_Split (String convertir){

        return convertir.split("");

    }

    /**
     *
     * @param frase1 es un String que recoge una String que le pasemos
     * @param frase2 es un String que recoge una String que le pasemos
     * @return este metodo nos devuelve un true o un false depediendo si los dos String que le hemos pasado tienen la misma longitud o no ( no importa si los string que tenemos arriba son vectores cogera el contenido de estos )
     */

    public static boolean Validar_Vectores_MismaLongitud (String frase1, String frase2){

        if (frase1.length() != frase2.length()){

            return false;

        }else {

            return true;
        }

    }

    /**
     *
     * @param frase1_vector esto es un vector tipo String que nosotros le pasemos
     * @param frase2_vector esto es un vector tipo String que nosotros le pasemos
     */

    public static void ordenar (String[] frase1_vector, String[] frase2_vector){

        Arrays.sort(frase1_vector);
        Arrays.sort(frase2_vector);

    }

    /**
     *
     * @param frase1 esto es un vector tipo String que nosotros le pasemos
     * @param frase2 esto es un vector tipo String que nosotros le pasemos
     * @return devolvera un boolean que dara true o false dependiendo de si las letras de cada posición de uno de los  vectores encajan con las del otro
     */

    public static boolean Recorrer_2_Vectores_Y_Comparar (String[] frase1, String[] frase2){

        for (int i = 0; i < frase1.length; i++) {

            if (!frase1[i].equals(frase2[i])){

                return false;

            }
        }

        return true;

    }
}
