package org.example;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @autor Patricia
 * @version 1.0
 */
public class Ejercicio4 {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        double recaudacion[] = introducirRecaudacion();
        System.out.println(Arrays.toString(recaudacion));

        System.out.println(diaMaximo(recaudacion));

        double media = media (recaudacion);
        System.out.println(media);

        double domingo = domingo(recaudacion);
        System.out.println(domingo);

        if (domingo > media){
            System.out.println("SI");
        }else{
            System.out.println("NO");
        }


    }

    /**
     * @author Patricia
     * @version 1.0
     * Método para introducir las ganancias diarias de un bar
     * @return - devuelve un vector con los importes diarios de martes a domingo
     */
    public static double[] introducirRecaudacion(){

        double recaudacion[] = new double[6];

        for (int i = 0; i < recaudacion.length; i++) {
            recaudacion[i] = teclado.nextDouble();
        }

        return recaudacion;

    }

    /**
     * Método que calcular qué día se han tenido más ventas.
     * @param recaudacion - recibe un vector con las ventas diarias de martes a domingo
     * @return - devuelve el día de la semana que más ventas han habido
     */
    public static String diaMaximo(double recaudacion[]){

        double maximo = recaudacion[0];
        int dia = 0;

        for (int i = 0; i < recaudacion.length; i++) {
            if (recaudacion[i]>maximo){
                maximo = recaudacion[i];
                dia = i;
            }
        }

        return dia_semana(dia);

    }

    public static String dia_semana(int dia){

        switch (dia){
            case 0:
                return "MARTES";
            case 1:
                return "MIÉRCOLES";
            case 2:
                return "JUEVES";
            case 3:
                return "VIERNES";
            case 4:
                return "SÁBADO";
            case 5:
                return "DOMINGO";
        }

        return "";

    }

    public static double media (double recaudacion[]){

        double acumulado = 0;

        for (int i = 0; i < recaudacion.length; i++) {
            acumulado += recaudacion[i];
        }

        return (acumulado/recaudacion.length);

    }

    public static double domingo (double recaudacion[]){

        return recaudacion[recaudacion.length-1];

    }

}
