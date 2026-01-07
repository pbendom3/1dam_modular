package org.example;

import java.util.Scanner;

public class Modo2 {

    static Scanner teclado;

    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        while (casoDePrueba()) {
        }
    } // main

    public static boolean casoDePrueba() {
       // leer caso de prueba
        int x = teclado.nextInt();
        int y = teclado.nextInt();
        teclado.nextLine();
        if (x < 0 || y < 0)
            return false;
        else {
            // CÓDIGO PRINCIPAL AQUÍ
            System.out.println((x+y)*2);
            return true;
        }
    } // casoDePrueba


}
