package org.example;

import java.util.Scanner;

public class Modo3 {

    static Scanner teclado;

    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        while (casoDePrueba()) {
        }
    } // main

    public static boolean casoDePrueba() {
        if (!teclado.hasNext())
            return false;
        else {
            // CÓDIGO PRINCIPAL AQUÍ
            // (incluyendo la lectura del caso de prueba)
            int toros = teclado.nextInt();
            int velocidad_corredor = 0;
            for (int i = 0; i < toros; i++) {
                int velocidad_toro = teclado.nextInt();
                if (velocidad_toro>velocidad_corredor){
                    velocidad_corredor = velocidad_toro;
                }
            }
            System.out.println(velocidad_corredor);
            teclado.nextLine();
            return true;
        }
    } // casoDePrueba

}
