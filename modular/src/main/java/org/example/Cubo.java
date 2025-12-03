package org.example;

import java.util.Scanner;

public class Cubo {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce un número...");
        int numero = teclado.nextInt();
        int resultado = cubo(numero);
        System.out.println(resultado);

    }

    public static int cubo(int numero){
        return numero*numero*numero;
    }





}
