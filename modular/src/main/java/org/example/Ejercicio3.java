package org.example;

import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce una cadena...");
        String cadena = teclado.nextLine();
        cadena = mayusculas(cadena);
        System.out.println(cadena);
        int total_vocales = contarVocales(cadena);
        System.out.println("Vocales totales " + total_vocales);

    }

    public static String mayusculas(String cadena){
        cadena = cadena.toUpperCase();
        return cadena;
    }

    public static int contarVocales(String cadena){

        int a = 0;
        int e = 0;
        int i = 0;
        int o = 0;
        int u = 0;

        for (int j = 0; j < cadena.length(); j++) {

            switch (cadena.charAt(j)){
                case 'A':
                    a++;
                    break;
                case 'E':
                    e++;
                    break;
                case 'I':
                    i++;
                    break;
                case 'O':
                    o++;
                    break;
                case 'U':
                    u++;
                    break;
            }

        }

        System.out.println("A: " + a);
        System.out.println("E: " + e);
        System.out.println("I: " + i);
        System.out.println("O: " + o);
        System.out.println("U: " + u);

        return a+e+i+o+u;

    }
}
