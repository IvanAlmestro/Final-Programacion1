package tp6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
/*
 * 4. Hacer un programa que dada una matriz de enteros de tamaño
5*10 que se encuentra precargada, solicite al usuario un número
entero y una posición fila, columna. Con estos datos tendrá que
realizar un corrimiento a derecha (se pierde el último valor en
dicha fila) y colocar el número en la matriz en la posición fila,
columna indicada.

 */
public class ej4 {
       public static final int MAXFILA = 5, MAXCOL=10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double probabilidad_numero = 4;
    public static void main(String[]args){
        int [][] matint = new int[MAXFILA][MAXCOL];
        cargar_matriz(matint);
        System.out.println(".");
        imprimir_matriz(matint);

        int fila = obtenerPos(MAXFILA);
        while (fila>MAXFILA || fila<0) {
            System.err.println("posicion incorrecta");
            fila = obtenerPos(MAXFILA);
        }
        int col= obtenerPos(MAXCOL);
        while (col>MAXCOL || col<0) {
            System.err.println("posicion incorrecta");
            col = obtenerPos(MAXCOL);
        }
        corrimiento_der(matint[fila], col);
        imprimir_matriz(matint);
    }

    public static void corrimiento_der(int[]arr, int pos){
        for(int i = MAXCOL-1; i>pos; i--){
            arr[i]=arr[i-1];
        }
    }

    public static int obtenerPos(int maximo) {
        int pos = 0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Ingrese una pos  entre  0  y " + maximo);
            pos = Integer.valueOf(entrada.readLine());
        }

        catch (Exception e) {
            System.out.println(e);
        }
        return pos;
    }

    public static void cargar_matriz(int[][] matint) {
        Random r = new Random();
        for (int fila = 0; fila < MAXFILA; fila++) {
            matint[fila][0] = 0;
            matint[fila][MAXCOL - 1] = 0;
            for (int col = 1; col < MAXCOL - 1; col++) {
                if (r.nextDouble() < probabilidad_numero) {
                    matint[fila][col] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
                } else {
                    matint[fila][col] = 0;
                }

            }
        }
    }
    public static void imprimir_matriz(int[][] matint) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            for (int col = 0; col < MAXCOL; col++) {

                System.out.print("|" + matint[fila][col]);
            }
            System.out.print("\n");
        }
    }
}
