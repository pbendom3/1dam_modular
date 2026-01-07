package org.example;

import java.util.Scanner;

/**
 * Clase que cuenta cuántas veces se repite cada nota en una canción introducida por el usuario.
 * @author Iris
 */

public class Teclas_de_Piano {

    /**
     * Entrada: Se le pide al usuario el número de notas y las notas de la canción.
     * Salida: Muestra cuantas veces se ha repetido cada nota (De la nota más baja a la más alta de toda la escala).
     */

    static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        do {
            try {
                System.out.println("Introduce el número de notas de la canción: ");
                int num_notas = Integer.parseInt(read.nextLine()); //El int pasa a ser de tipo String porque antes no podía leer la siguiente línea (problemas en el buffer, había que limpiarlo)
                if (num_notas == 0) //Si el número de notas es igual a 0 sale del bucle y termina el programa
                    break;

                System.out.println("Introduce las notas de la canción (Do#4, Sib3, Sol#5...)");
                String notas = read.nextLine();
                int[] contador_notas = procesar(num_notas, notas);
                //Se llama al método procesar para que separe cada nota (mediante un split).
                // Calcula el indice correspondiente de cada nota (mediante el método nota_indice).
                // Cuenta cuántas veces se pulsa una tecla en el piano (84 posiciones).
                // Imprime por pantalla cuántas veces se ha pulsado cada tecla.

                for (int i = nota_mas_baja(contador_notas); i <= nota_mas_alta(contador_notas); i++) {
                    System.out.print(contador_notas[i] + " ");
                }
                //Muestra las veces que se repite cada nota,
                //desde la más grave hasta la más aguda de la canción.
                System.out.println();

            } catch (NumberFormatException e) { // Muestra un mensaje de error si el usuario introduce algo que no sea un número
                System.out.println("ERROR: Formato incorrecto.");
                System.out.println("*******************************************");
            }

        } while (true); //Como la condición siempre se cumple, hasta que no pongas un 0 el programa no sale del bucle.

    }

    /**
     * Procesa las notas introducidas por el usuario y calcula cuantas veces se repite cada nota en la canción.
     * @param num_notas número total de notas que tiene la canción
     * @param notas nota completa (Con alteraciones y octavas correspondientes)
     */

    public static int[] procesar(int num_notas, String notas){ //Recibe cuántas notas tiene la canción (num_notas) y las notas (notas).

        int[] contador_notas = new int[84]; //7 octavas × 12 notas = 84 teclas. Java pone el valor inicial de las notas a 0.

        String[] cancion = notas.split(" "); //Separa cada nota completa a partir de espacios

        for (int i = 0; i < num_notas; i++) { //Recorre el número de notas de la canción introducido por teclado
            int indice = nota_indice(cancion[i]); //Convierte cada nota en un índice del 0 al 83 (para identificar donde se sitúa cada nota en el teclado.
            contador_notas[indice]++; //Si esa nota se repite más de una vez, aumentará el contador.
        }
        return contador_notas; //Devuelve el array con todas las notas repetidas.
    }

    /**
     * Convierte una nota en su respectivo índice dentro del array del contador de notas que se repiten.
     * @param nota_completa nota completa (Con alteraciones y octavas correspondientes)
     */

    public static int nota_indice(String nota_completa){ //Recibe la nota completa

        try {
            int longitud = nota_completa.length(); //Guarda la longitud de la nota.
            String nota = nota_completa.substring(0, longitud - 1); //Extrae la nota completa sin la octava correspondiente.
            int octava = Integer.parseInt(nota_completa.substring(longitud - 1)); //Extrae la octava de la nota completa.
            int i = 0; //Se guarda la posición de la nota en la octava (de 0 a 11).

            switch (nota){ //Pasa la nota sin la octava al índice asignado
                case "Do": //enarmónicas
                case "Si#":
                    i = 0;
                    break;
                case "Do#": //enarmónicas
                case "Reb":
                    i = 1;
                    break;
                case "Re":
                    i = 2;
                    break;
                case "Re#": //enarmónicas
                case "Mib":
                    i = 3;
                    break;
                case "Mi": //enarmónicas
                case "Fab":
                    i = 4;
                    break;
                case "Mi#": //enarmónicas
                case "Fa":
                    i = 5;
                    break;
                case "Fa#": //enarmónicas
                case "Solb":
                    i = 6;
                    break;
                case "Sol":
                    i = 7;
                    break;
                case "Sol#": //enarmónicas
                case "Lab":
                    i = 8;
                    break;
                case "La":
                    i = 9;
                    break;
                case "La#": //enarmónicas
                case "Sib":
                    i = 10;
                    break;
                case "Dob": //enarmónicas
                case "Si":
                    i = 11;
                    break;
                default: //Si el formato no es correcto, devuelve 0.
                    return 0;
            }

            i += (octava - 1) * 12; //Octava = 12 notas. La octava 1 empieza en 0.
            return i; //Devuelve la posición de la nota en el piano.

        } catch (NumberFormatException e) { // Muestra un mensaje de error si la nota no termina en un número.
            System.out.println("ERROR: Formato incorrecto.");
            System.out.println("*******************************************");
            return 0;
        }
    }

    /**
     * Localiza la nota más baja en el array del contador de notas que se repiten.
     * @param contador cuenta cuantas veces se repite una nota
     */

    public static int nota_mas_baja (int[] contador){ //Recibe un array con el número de veces que se repite cada nota de la canción (Devuelve la nota más baja).

        int indice_bajo = -1; //Valor por defecto cuando no encuentra la nota

        for (int i = 0; i < contador.length; i++) { //Recorre el array de izquierda a derecha (donde se encuentra la nota más grave).
            if (contador[i] != 0){ //Verifica si la nota se repite al menos una vez.
                indice_bajo = i; //Guarda el índice de la nota encontrada.
                break; //Sale del bucle cuando la encuentra.
            }
        }
        return indice_bajo; //Devuelve el índice de la nota más grave.
    }

    /**
     * Localiza la nota más alta en el array del contador de notas que se repiten.
     * @param contador cuenta cuantas veces se repite una nota
     */

    public static int nota_mas_alta (int[] contador){ //Recibe un array con el número de veces que se repite cada nota de la canción (Devuelve la nota más alta).

        int indice_alto = -1; //Valor por defecto cuando no encuentra la nota

        for (int i = contador.length - 1; i >= 0; i--) { //Recorre el array de derecha a izquierda (donde se encuentra la nota más grave).
            if (contador[i] != 0){ //Verifica si la nota se repite al menos una vez.
                indice_alto = i; //Guarda el índice de la nota encontrada.
                break; //Sale del bucle cuando la encuentra.
            }
        }
        return indice_alto; //Devuelve el índice de la nota más alta.
    }
}

