package HundirLaFlota;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * Clase principal que implementa una versión modular del juego
 * "Hundir la Flota", correspondiente al problema 137 de Acepta el Reto.
 * <p>
 * El programa permite introducir el número de barcos, sus tamaños y el
 * tamaño del tablero, genera una colocación aleatoria de los barcos y
 * comprueba si el tablero resultante es válido según las reglas del juego.
 * </p>
 *
 * @author Alberto Planelles Monllor
 * @version 1.0
 * @see <a href="https://aceptaelreto.com/problem/statement.php?id=137&cat=14">
 *      Problema 137 - Hundir la Flota</a>
 */
public class Modular {

    /** Objeto Scanner para la entrada de datos por teclado */
    static Scanner entrada = new Scanner(System.in);

    /** Objeto Random para la colocación aleatoria de los barcos */
    static Random random = new Random();

    /**
     * Método principal del programa.
     * Controla el flujo de ejecución, solicitando los datos al usuario,
     * creando el tablero, colocando los barcos y validando el resultado.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        boolean loop = true;
        while (loop) {
            System.out.println("¡Bienvenido a Hundir la Flota!");
            System.out.println("Introduce el numero de barcos: ");

            int numeroBarcos = entrada.nextInt();
            entrada.nextLine(); // Consumir el salto de línea pendiente
            if (!inputNumeroBarcos(numeroBarcos)) {
                break;
            }

            int[] tamanos = inputTamanosBarcos(numeroBarcos);
            if (tamanos == null|| tamanos.length != numeroBarcos) {
                break;
            }

            System.out.println("Introduce el tamaño del tablero:");
            int tamanoTablero = entrada.nextInt();

            String[][] tablero = crearTablero(tamanoTablero);
            colocarBarcos(tablero, tamanos);
            mostrarTablero(tablero);

            esValido(tablero);
        }
    }

    /**
     * Solicita al usuario el número de barcos a colocar.
     *
     * @return si el numero de barcos introducido es valido o no y si es 0 cierra el programa
     */
    public static boolean inputNumeroBarcos(int numeroBarcos) {

        if (numeroBarcos > 10) {
            System.out.println("Número de barcos no válido. Debe ser máximo 10.");
            return false;
        }else if(numeroBarcos == 0){
            System.out.println("Saliendo del programa.");
            exit(0);
        }
        return true;
    }

    /**
     * Solicita y valida los tamaños de los barcos.
     *
     * @param numeroBarcos número total de barcos
     * @return un array con los tamaños de los barcos o null si hay algún error
     */
    public static int[] inputTamanosBarcos(int numeroBarcos) {
        System.out.println("Introduce el tamaño de cada barco: ");
        String tamanosBarcos = entrada.next();
        String[] tamanos = tamanosBarcos.split(" ");
        int[] tamanosInt = new int[numeroBarcos];

        for (int z = 0; z < numeroBarcos; z++) {
            int comprobar = Integer.parseInt(tamanos[z]);
            if (comprobar <= 0) {
                System.out.println("Tamaño de barco no válido. Debe ser siempre mayor que cero.");
                return null;
            }
            tamanosInt[z] = comprobar;
        }
        return tamanosInt;
    }

    /**
     * Crea e inicializa un tablero cuadrado con todas sus posiciones a '0'.
     *
     * @param tamanoTablero tamaño del tablero
     * @return matriz que representa el tablero
     */
    public static String[][] crearTablero(int tamanoTablero) {
        if(tamanoTablero >128 || tamanoTablero <=0){
            System.out.println("Tamaño de tablero no válido. Debe ser siempre mayor que cero y menor que 128.");
            return null;
        }
        String[][] tablero = new String[tamanoTablero][tamanoTablero];
        for (int i = 0; i < tamanoTablero; i++) {
            for (int j = 0; j < tamanoTablero; j++) {
                tablero[i][j] = "0";
            }
        }
        return tablero;
    }

    /**
     * Coloca los barcos de forma aleatoria en el tablero, en orientación
     * horizontal o vertical aleatoriamente.
     *
     * @param tablero tablero donde se colocan los barcos
     * @param tamanosBarcos array con los tamaños de los barcos
     */
    public static void colocarBarcos(String[][] tablero, int[] tamanosBarcos) {
        int tableraco = tablero.length;

        for (int tam : tamanosBarcos) {
            boolean horizontal = random.nextBoolean();

            if (horizontal) {
                int fila = random.nextInt(tableraco);
                int col = random.nextInt(tableraco - tam + 1);
                for (int i = 0; i < tam; i++)
                    tablero[fila][col + i] = "1";
            } else {
                int fila = random.nextInt(tableraco - tam + 1);
                int col = random.nextInt(tableraco);
                for (int i = 0; i < tam; i++)
                    tablero[fila + i][col] = "1";
            }
        }
    }

    /**
     * Muestra el contenido del tablero por consola.
     *
     * @param tablero tablero a mostrar
     */
    public static void mostrarTablero(String[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Comprueba si el tablero es válido según las reglas del juego,
     * verificando que los barcos no estén en contacto lateral indebido.
     *
     * @param tablero tablero a validar
     * @return true si el tablero es válido, false en caso contrario
     */
    public static boolean esValido(String[][] tablero) {
        int n = tablero.length;
        boolean valido = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) { //entro en el array
                if (tablero[i][j].equals("1")) { // si encuentra un barco entra en este if
                    if (j + 1 < n && tablero[i][j + 1].equals("1")) {//si no se sale del array y la siguiente posicion horizontal es un barco
                        int boat = j + 1;//inicializo boat en la siguiente posicion a la del barco
                        while (boat < n && tablero[i][boat].equals("1")){ //mientras boat no se salga del array y en la posicion boat haya un barco
                            boat++;//incremento boat
                        }
                        for (int m = j; m < boat; m++) { //recorro desde la posicion del barco hasta la ultima posicion del barco
                            if ((i - 1 >= 0 && tablero[i - 1][m].equals("1")) ||(i + 1 < n && tablero[i + 1][m].equals("1"))) {//compruebo si en la fila de arriba o abajo hay un barco y si lo hay el tablero no es valido
                                valido = false;
                            }
                        }
                        j = boat - 1;//actualizo j para que continue desde la ultima posicion del barco
                    } else if (i + 1 < n && tablero[i + 1][j].equals("1")) {//si no se sale del array y la siguiente posicion vertical es un barco
                        int boat = i + 1; //inicializo boat en la siguiente posicion a la del barco
                        while (boat < n && tablero[boat][j].equals("1")){ //mientras boat no se salga del array y en la posicion boat haya un barco
                            boat++;//incremento boat
                        }
                        for (int m = i; m < boat; m++) { //recorro desde la posicion del barco hasta la ultima posicion del barco
                            if ((j - 1 >= 0 && tablero[m][j - 1].equals("1")) || (j + 1 < n && tablero[m][j + 1].equals("1"))) { //compruebo si en la columna de la izquierda o derecha hay un barco y si lo hay el tablero no es valido
                                valido = false;
                            }
                        }
                        i = boat - 1; //actualizo i para que continue desde la ultima posicion del barco
                    }
                }
            }
        }
        if(valido){
            System.out.println("SI");
            return true;
        }else{
            System.out.println("NO");
            return false;
        }

    }
}
