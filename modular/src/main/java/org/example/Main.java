package org.example;

public class Main {
    public static void main(String[] args) {

        int num = 10;
        int numero = funcion(num,"patri");
        System.out.println(numero);
        procedimiento();
        System.out.println("He vuelto del procedimiento");

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        pintar_nombre("patri","kevin","david");

    }

    public static int funcion(int numero, String nombre){
        System.out.println("Hola " + nombre);
        numero = numero+20;
        return numero*10;

    }

    public static void procedimiento(){

        System.out.println("Hola soy un procedimiento y hago mis cosas no devolviendo nada...");

    }

    public static void pintar_nombre(String...nombre){

        for (String nom : nombre){
            System.out.println(nom);
        }

    }
}