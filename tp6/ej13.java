package tp6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*13. Hacer un programa que dada la matriz de secuencias de
enteros definida y precargada, y un número entero ingresado por
el usuario, elimine de cada fila las secuencias de tamaño igual al
número ingresado. */
public class ej13 {
        public static final int MAXFILA = 5, MAXCOL=10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double probabilidad_numero = 0.4;
    public static void main(String[]args){
        int [][] matint = new int[MAXFILA][MAXCOL];
        int numero = 0;

        cargar_matriz_secuencias(matint);
        System.out.println(".");
        imprimir_matriz(matint);
        numero = obtenerNumero();

        recorrerFilas(matint,numero);
        System.out.println(" oCURRENCIA BORRADA ");
        imprimir_matriz(matint);

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

    public static void eliminarSecs(int[]arr, int numero){
        int inicio = 0;
        int fin =-1;
        int tamanio = 0;
        while(inicio<MAXCOL){
            inicio = buscar_inicio(arr, fin+1);
            if(inicio<MAXCOL){
                fin = buscar_fin(arr, fin);

                tamanio = fin-inicio+1;
                if(tamanio == numero){
                    eliminar(arr, inicio,fin);
                    fin = inicio;   
                }
            }
        }
    }

    public static void eliminar(int[]arr, int ini, int fin){
        while(ini<=fin){
            corrimiento_izq(arr, ini);
            ini++;
        }
    }
    public static void recorrerFilas(int[][] mat, int numero){

        for(int fila=0; fila<MAXFILA; fila++){
            eliminarSecs(mat[fila], numero);
        }
        
    }

    public static void corrimiento_izq(int[]arr, int ini){
        for(int i =ini; i<MAXCOL-1; i++){
            arr[i]=arr[i+1];
        }
        arr[MAXCOL-1] = 0;
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

    public static void cargar_matriz_secuencias(int[][] matint) {
        Random r = new Random();
        for (int fila = 0; fila < MAXFILA; fila++) {
            matint[fila][0] = 0;
            matint[fila][MAXCOL - 1] = 0;
            for (int col = 1; col < MAXCOL - 1; col++) {
                if (r.nextDouble() > probabilidad_numero) {
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
