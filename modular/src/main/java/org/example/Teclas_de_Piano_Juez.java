package org.example;

import java.util.Scanner;

public class Teclas_de_Piano_Juez {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        do {
            int num_notas = Integer.parseInt(read.nextLine());
            if (num_notas == 0)
                break;

            String notas = read.nextLine();
            int[] contador_notas = procesar(num_notas, notas);

            int mas_alta = nota_mas_alta(contador_notas);
            int mas_baja = nota_mas_baja(contador_notas);

            for (int i = mas_baja; i < mas_alta ; i++) {
                System.out.print(contador_notas[i] + " ");
            }
            System.out.println(contador_notas[mas_alta]); //Evita el espacio al final de la linea

        } while (true);

    }

    public static int[] procesar(int num_notas, String notas){

        int[] contador_notas = new int[84];

        String[] cancion = notas.split(" ");

        for (int i = 0; i < num_notas; i++) {
            int indice = nota_indice(cancion[i]);
            contador_notas[indice]++;
        }
        return contador_notas;
    }

    public static int nota_indice(String nota_completa){

        int longitud = nota_completa.length();
        String nota = nota_completa.substring(0, longitud - 1);
        int octava = Integer.parseInt(nota_completa.substring(longitud - 1));
        int i = 0;

        switch (nota){
            case "Do":
            case "Si#":
                i = 0;
                break;
            case "Do#":
            case "Reb":
                i = 1;
                break;
            case "Re":
                i = 2;
                break;
            case "Re#":
            case "Mib":
                i = 3;
                break;
            case "Mi":
            case "Fab":
                i = 4;
                break;
            case "Mi#":
            case "Fa":
                i = 5;
                break;
            case "Fa#":
            case "Solb":
                i = 6;
                break;
            case "Sol":
                i = 7;
                break;
            case "Sol#":
            case "Lab":
                i = 8;
                break;
            case "La":
                i = 9;
                break;
            case "La#":
            case "Sib":
                i = 10;
                break;
            case "Dob":
            case "Si":
                i = 11;
                break;
        }

        i += (octava - 1) * 12;
        return i;
    }

    public static int nota_mas_baja (int[] contador){

        int indice_bajo = -1;

        for (int i = 0; i < contador.length; i++) {
            if (contador[i] != 0){
                indice_bajo = i;
                break;
            }
        }
        return indice_bajo;
    }

    public static int nota_mas_alta (int[] contador){

        int indice_alto = -1;

        for (int i = contador.length - 1; i >= 0; i--) {
            if (contador[i] != 0){
                indice_alto = i;
                break;
            }
        }
        return indice_alto;
    }
}
