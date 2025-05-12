package tp6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*11. Hacer un programa que dada la matriz de secuencias de
enteros definida y precargada permita encontrar por cada fila la
posición de inicio y fin de la secuencia cuya suma de valores sea
mayor.
 */
public class ej11 {
    public static final int MAXFILA = 5, MAXCOL=10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double probabilidad_numero = 4;
    public static void main(String[]args){
        int [][] matint = new int[MAXFILA][MAXCOL];
   

        cargar_matriz(matint);
        System.out.println(".");
        imprimir_matriz(matint);
    
        recorrerFilas(matint);


    }
    public static void recorrerFilas(int[][] mat){
        
        for(int fila=0; fila<MAXFILA; fila++){
            System.out.println("La fila :" + fila + " tiene la  mayor suma de: " + obtenerMayorSumaSec(mat[fila]));
        }
        
    }
    public static int obtenerMayorSumaSec(int[]arr){
        int inicio = 0;
        int fin = -1;
        int mayorSuma=0;
        int sumaActual=0;
        while(inicio <MAXCOL){
            inicio = buscar_inicio(arr, fin+1);
            if(inicio<MAXCOL){
                fin = buscar_fin(arr, inicio);
                sumaActual = suma(arr, inicio, fin);
                if(sumaActual>mayorSuma){
                    mayorSuma = sumaActual;
                }
            }
            
        }
        return mayorSuma;
    }


    public static int buscar_inicio(int[]arr, int ini){
        while(ini<MAXCOL && arr[ini]==0){
            ini++;
        }
        return ini;
    }
    public static int buscar_fin(int[]arr, int fin){
        while(fin<MAXCOL && arr[fin]!=0){
            fin++;
        }
        return fin-1;
    }

    public static int suma(int[]arr, int ini, int fin){
        int suma=0;
        while(ini<=fin){
            suma+=arr[ini];
            ini++;
        }
        return suma;
    }

    public static void cargar_matriz(int[][] matint) {
        Random r = new Random();
        for (int fila = 0; fila < MAXFILA; fila++) {
            matint[fila][0] = 0;
            matint[fila][MAXCOL - 1] = 0;
            for (int col = 1; col < MAXCOL - 1; col++) {
                if (r.nextDouble() < probabilidad_numero) {
                    matint[fila][col] = (r.nextInt(MAXVALOR - MINVALOR + 1));
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
