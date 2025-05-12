package practica2025;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
/*22. Hacer un programa que elimine los valores pares en un arreglo
de tamao MAX=10.
 */
public class ej22 {
    public static final int MAX = 10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR =1;
    public static void main(String[] args) {
        int[] arr = new int[MAX];

        cargar_arreglo(arr);
        System.out.println("\nArreglo original:");
        imprimir_arreglo(arr);

        eliminarPares(arr);
        System.out.println("\nArreglo sin números pares:");
        imprimir_arreglo(arr);
    }
    public static void eliminarPares(int[] arr) {
        int i = 0;
        while (i < MAX) {
            if (arr[i] % 2 == 0) {  
                corrimiento_izq(arr, i);  
                arr[MAX - 1] = 0;  
                // NO aumentamos i aquí
            } else {  
                i++; // Solo avanzamos si no eliminamos nada  
            }
            
        }
    }
    public static void corrimiento_izq(int[] arr, int ini) {
        for (int i = ini; i < MAX - 1; i++) {
            arr[i] = arr[i + 1];
        }
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
