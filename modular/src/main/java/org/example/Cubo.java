package org.example;

import java.util.Scanner;

public class Cubo {

    public static void main(String[] args) {

        int resultado = cubo();
        System.out.println(resultado);

    }

    public static int cubo(){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce un número...");
        int numero = teclado.nextInt();
        return numero*numero*numero;
    }

    public static boolean par(int numero){
        if (numero % 2 == 0){
            return true;
        }else{
            return false;
        }
    }

}
