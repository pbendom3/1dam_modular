package HundirLaFlota;

import java.util.Random;
import java.util.Scanner;


/**
 * Esta clase contiene el metodo main y todo lo necesario para resolver el problema 137 de Hundir la Flota.
 * @author Alberto Planelles Monllor
 * @version 1.0
 * @see <a href="https://aceptaelreto.com/problem/statement.php?id=137&cat=14">Problema 137 Hundir la Flota</a>
 */
public class Hundirla {
    static Scanner entrada = new Scanner(System.in);
    static Random random = new Random();
    public static boolean casoDePrueba() {
        System.out.println("¡Bienvenido a Hundir la Flota!");
        System.out.println("Introduce el numero de barcos: ");
        int numeroBarcos = entrada.nextInt();
        if (numeroBarcos == 0)
        return false;
        else {
            if (numeroBarcos > 10) {
                System.out.println("Número de barcos no válido. Debe ser como máximo 10.");
                return false;
            }

            entrada.nextLine();
            System.out.println("Introduce el tamaño de cada barco: ");
            String tamanosBarcos = entrada.nextLine();
            String[] tamanos = tamanosBarcos.split(" ");
            for (int z = 0; z < tamanos.length; z++) {
                int comprobar = Integer.parseInt(tamanos[z]);
                if (comprobar < 0) {
                    System.out.println("Tamaño de barco no válido. Debe ser siempre mayor que cero.");
                    return false;
                }
            }


            System.out.println("Introduce el tamaño del tablero:");
            int tamanoTablero = entrada.nextInt();

            String[][] tablero = new String[tamanoTablero][tamanoTablero];


            for (int i = 0; i < tamanoTablero; i++) {
                for (int j = 0; j < tamanoTablero; j++) {
                    tablero[i][j] = "0";
                }
            }

            for (int k = 0; k < numeroBarcos; k++) {
                int tamanoBarco = Integer.parseInt(tamanos[k]);
                boolean horizontal = random.nextBoolean();
                int fila;
                int col;

                if (horizontal) {
                    fila = random.nextInt(tamanoTablero);
                    col = random.nextInt(tamanoTablero - tamanoBarco + 1);

                    for (int l = 0; l < tamanoBarco; l++) {
                        tablero[fila][col + l] = "1";
                    }

                } else {
                    fila = random.nextInt(tamanoTablero - tamanoBarco + 1);
                    col = random.nextInt(tamanoTablero);

                    for (int l = 0; l < tamanoBarco; l++) {
                        tablero[fila + l][col] = "1";
                    }
                }

            }
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero[i].length; j++) {
                    System.out.print(tablero[i][j] + " ");
                }
                System.out.println();
            }
            boolean valido = true;
            int n = tablero.length;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (tablero[i][j].equals("1")) {
                        // Comprobar derecha
                        if (j + 1 < n && tablero[i][j + 1].equals("1")) {
                            int boat = j + 1;
                            while (boat < n && tablero[i][boat].equals("1")) {
                                boat++;
                            }
                            // Comprobar que no hay barcos en la fila de abajo y arriba
                            for (int m = j; m < boat; m++) {
                                if ((i - 1 >= 0 && tablero[i - 1][m].equals("1")) || (i + 1 < n && tablero[i + 1][m].equals("1"))) {
                                    valido = false;
                                }
                            }
                            j = boat - 1; // Actualizar j para saltar el barco ya comprobado
                        }
                        // Comprobar abajo
                        else if (i + 1 < n && tablero[i + 1][j].equals("1")) {
                            int boat = i + 1;
                            while (boat < n && tablero[boat][j].equals("1")) {
                                boat++;
                            }
                            // Comprobar que no hay barcos a la izquierda y derecha
                            for (int m = i; m < boat; m++) {
                                if ((j - 1 >= 0 && tablero[m][j - 1].equals("1")) || (j + 1 < n && tablero[m][j + 1].equals("1"))) {
                                    valido = false;
                                }
                            }
                            i = boat - 1; // Actualizar i para saltar el barco ya comprobado
                        }
                    }
                }
            }

            if (valido) {
                System.out.println("SI");
            }else{
                System.out.println("NO");
            }
            return true;
        }
    }
    public static void main(String[] args) {
        while (casoDePrueba());

    }
}
