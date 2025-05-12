package tp6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*5. Hacer un programa que dada una matriz de enteros de tamaño
5*10 que se encuentra precargada, solicite al usuario un número
entero y elimine la primera ocurrencia de número en la matriz (un
número igual) si existe. Para ello tendrá que buscar la posición y si
está, realizar un corrimiento a izquierda y no continuar buscando.
 */
public class ej5 {
    public static final int MAXFILA = 5, MAXCOL=10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double probabilidad_numero = 4;
    public static void main(String[]args){
        int [][] matint = new int[MAXFILA][MAXCOL];
        int numero = 0;

        cargar_matriz(matint);
        System.out.println(".");
        imprimir_matriz(matint);
        numero = obtenerNumero();
        recorrerFilas(matint,numero);
        System.out.println(" oCURRENCIA BORRADA ");
        imprimir_matriz(matint);

    }
    public static void recorrerFilas(int[][] mat, int numero){
        int posBorrar=0;
        boolean seEncontro = false;
        for(int fila=0; fila<MAXFILA; fila++){
            posBorrar= buscarOcurrencia(mat[fila], numero);
            if(!seEncontro){
                corrimiento_izq(mat[fila], posBorrar);
                seEncontro = true;
            }
        }
        
    }

    public static void corrimiento_izq(int[]arr, int ini){
        for(int i =ini; i<MAXCOL-1; i++){
            arr[i]=arr[i+1];
        }
        arr[MAXCOL-1] = 0;
    }
    public static int buscarOcurrencia(int[]arr, int numero){
        int i = 0;
        int pos = 0;
        while(i<MAXCOL){
            if(arr[i]== numero){
                pos = i;
            }
            i++;
        }
        return pos;
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
