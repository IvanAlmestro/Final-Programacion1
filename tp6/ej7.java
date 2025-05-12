package tp6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Random;

/*7. Hacer un programa que dada una matriz de enteros ordenada
creciente por filas de tamaño 4*5 que se encuentra precargada,
solicite al usuario un número entero y una fila, y luego inserte el
número en la matriz en la fila indicada manteniendo su orden.
 */
public class ej7 {
    public static final int MAXFILA = 5, MAXCOL=10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double probabilidad_numero = 4;
    public static void main(String[]args){
        int [][] matint = new int[MAXFILA][MAXCOL];
        int numero = 0;
        int fila =0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));


        cargar_matriz(matint);
        System.out.println(".");
        ordenarArregloCreciente(matint);
        imprimir_matriz(matint);
       
        try {
            System.out.println("Ingrese un numero entero");
            numero = Integer.valueOf(entrada.readLine());
            System.out.println("ingrese una fila");
            fila = Integer.valueOf(entrada.readLine());
   
    
        } catch (Exception e) {
            System.out.println(e);
        }
        if(fila>=0&& fila<MAXFILA){
            insertarOrdenado(matint[fila], numero);
        }


        System.out.println(" inserto ordenado:  ");
        imprimir_matriz(matint);


    }

    
    public static void insertarOrdenado(int[]arr, int numero){
        int i = 0;
        while(i<MAXCOL && arr[i]<numero){
            i++;
        }
        if(i<MAXCOL){
            corrimiento_der(arr,i);
            arr[i] = numero;
        }else if(i==MAXCOL){
            arr[i-1] = numero;
        }
    }
    public static void corrimiento_der(int[]arr, int ini){
        for (int i = MAXCOL-1; i>ini; i--){
            arr[i]=arr[i-1];
        }
    }


    public static int obtenerNumero() {
        int pos = 0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Ingrese un entero");
            pos = Integer.valueOf(entrada.readLine());
        }

        catch (Exception e) {
            System.out.println(e);
        }
        return pos;
    }
    public static void ordenarArregloCreciente(int[][] mat) {
        int fila = 0;
        while (fila < MAXFILA) {
            int aux;
            for (int i = 0; i < MAXCOL; i++) {
                for (int j = i; j < MAXCOL; j++) {
                    if (mat[fila][i] > mat[fila][j]) {
                        aux = mat[fila][i];
                        mat[fila][i] = mat[fila][j];
                        mat[fila][j] = aux;
                    }
                }
            }
            fila++;
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