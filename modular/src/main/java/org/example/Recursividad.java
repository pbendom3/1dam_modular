package org.example;

public class Recursividad {

    static int limite = 10;

    public static void main(String[] args) {

      imprimir(1);


    }

    public static void imprimir(int inicio){

        if (inicio <= limite){
            System.out.println(inicio);
            imprimir(inicio+1);
        }

    }


}
