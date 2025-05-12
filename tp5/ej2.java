package practica2025;

import java.util.Random;

/*2. Hacer un programa que dado un arreglo ya cargado con 10
enteros, calcule el promedio y lo muestre por la consola. */
public class ej2 {
    public static final int MAX = 10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR=1;

    public static void main(String[] args) {
        int[]arr= new int[MAX];
        System.out.println("- ");
        cargar_arreglo(arr);
        imprimir_arreglo(arr);
        promedio_arreglo(arr);

    }

    public static void promedio_arreglo(int[]arr){
        int contador=0;
        int total = 0;
        for(int i =0; i<MAX; i++){
            total += arr[i];
            contador++;
        }
        System.out.println("El promedio del arreglo es: " + total/contador);
    }

    public static void imprimir_arreglo(int[] arr) {
        for (int i = 0; i < MAX; i++) {
            System.out.print("|" + arr[i] + "|");
          
        }
    }

    public static void cargar_arreglo(int[] arr) {
        Random r = new Random();
        for (int fila = 0; fila < MAX; fila++) {
            
                if (r.nextDouble() < 1) {
                    arr[fila] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            }
        }
    }
}
