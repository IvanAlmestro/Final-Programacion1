package tp6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*9. Hacer un programa que dada una matriz de enteros de tamaño
4*5 que se encuentra precargada, solicite al usuario el ingreso de
una fila y dos números enteros (columnas de la matriz), y ordene
de forma creciente la matriz en la fila indicada entre las dos
posiciones columnas ingresadas.
 */
public class ej9 {
    public static final int MAXFILA = 5, MAXCOL=10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double probabilidad_numero = 4;

    public static void main(String[]args){
        int[][] matint = new int[MAXFILA][MAXCOL];
        int fila =0, col1=0, col2=0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        cargar_matriz(matint);
        System.out.println(" MAtriz original: ");
        imprimir_matriz(matint);
        try {
            System.out.println("Ingrese una fila");
            fila = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese una columna");
            col1 = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese otra columna");
            col2 = Integer.valueOf(entrada.readLine());
        } catch (Exception e) {
            // TODO: handle exception
        }
        ordenarCreciente(matint[fila], col1, col2);
        System.out.println("Matriz ordenada");
        imprimir_matriz(matint);


    }



    public static void ordenarCreciente(int[]arr, int col1, int col2){
        for (int i = col1; i < col2; i++) {
            for (int j = col1; j < col2; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
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
