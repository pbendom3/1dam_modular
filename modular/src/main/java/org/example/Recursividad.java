package org.example;

import java.sql.SQLOutput;

public class Recursividad {

    static int limite = 10000;

    public static void main(String[] args) {

        System.gc(); //Limpia lo que pueda antes de medir

        long inicioEjecucion = System.nanoTime();
        long memoriaAntes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        imprimir(1);

        long finEjecucion = System.nanoTime();
        long memoriaDespues = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.println("Tiempo recursivo: " + (finEjecucion - inicioEjecucion) + " ns");
        System.out.println("Memoria consumida recursivo: " + (memoriaDespues - memoriaAntes) + " bytes");

        System.gc(); //Limpia lo que pueda antes de medir

        inicioEjecucion = System.nanoTime();
        memoriaAntes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        imprimir_bucle();

        finEjecucion = System.nanoTime();
        memoriaDespues = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.println("Tiempo: " + (finEjecucion - inicioEjecucion) + " ns");
        System.out.println("Memoria consumida: " + (memoriaDespues - memoriaAntes) + " bytes");

//      System.out.println(suma(10));

        System.out.println(digitos(4556));

        System.out.println(potencia(2, 4));

        del_reves(25);

        System.out.println();

        String frase = "Hola mundo soy una frase al reves";
        char[] frase_char = frase.toCharArray();
        del_reves_char(frase_char.length - 1, frase_char);
        del_reves_char_sin_vector(frase.length() - 1, frase);
        System.out.println();
        System.out.println(comprobarBinario(33));
        System.out.println(pasar_binario(10));
    }

    public static void imprimir(int inicio) {

        if (inicio <= limite) {
            System.out.println(inicio);
            imprimir(inicio + 1);
        }

    }

    public static void imprimir_bucle() {

        for (int i = 1; i <= 10000; i++) {
            System.out.println(i);
        }

    }

    public static int suma(int num) {

        if (num == 0) {
            return 0;
        } else {
            return num + suma(num - 1);
        }

    }

    public static int digitos(int numero) {

        if (numero < 10) {
            return 1;
        } else {
            return 1 + digitos(numero / 10);
        }

    }

    public static int potencia(int base, int exponente) {

        if (exponente == 1) {
            return base;
        } else {
            return base * potencia(base, exponente - 1);
        }

    }

    public static void del_reves(int numero) {

        if (numero < 10) {
            System.out.print(numero);
        } else {
            System.out.print(numero % 10);
            del_reves(numero / 10);
        }

    }

    public static void del_reves_char(int posicion, char[] frase) {

        if (posicion >= 0) {
            System.out.print(frase[posicion]);
            del_reves_char(posicion - 1, frase);
        }

    }

    public static void del_reves_char_sin_vector(int posicion, String frase) {

        if (posicion >= 0) {
            System.out.print(frase.charAt(posicion));
            del_reves_char_sin_vector(posicion - 1, frase);
        }

    }

    public static boolean comprobarBinario(int numero) {

        if (numero >= 10) {

            if (numero % 10 == 0 || numero % 10 == 1) {
                return comprobarBinario(numero / 10);
            } else {
                return false;
            }
        } else {
            if (numero == 0 || numero == 1) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static String pasar_binario(int num){
        if (num<=1){
            return Integer.toString(num);
        }else{
            return pasar_binario(num/2)+num%2;
        }
    }
}
