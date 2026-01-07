package org.example;

public class Sobrecarga {

    public static void atacar(){
        System.out.println("ATACANDO");
    }

    public static void atacar(String nombre){
        System.out.println("Te está atacando " + nombre);
    }

    public static void atacar (int nivel){
        System.out.println("ATACANDO CON NIVEL " + nivel);
    }

    public static void main(String[] args) {

        atacar("10");
    }

}
