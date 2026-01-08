package org.example;

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

        System.out.println(potencia(2,4));

    }

    public static void imprimir(int inicio){

        if (inicio <= limite){
            System.out.println(inicio);
            imprimir(inicio+1);
        }

    }

    public static void imprimir_bucle(){

        for (int i = 1; i <= 10000; i++) {
            System.out.println(i);
        }

    }

    public static int suma(int num){

        if (num==0){
            return 0;
        }else{
            return num+suma(num-1);
        }

    }

    public static int digitos(int numero){

        if (numero < 10){
            return 1;
        }else{
            return 1+digitos(numero/10);
        }

    }

    public static int potencia(int base, int exponente){

        if (exponente==1){
            return base;
        }else{
            return base*potencia(base,exponente-1);
        }

    }


}
