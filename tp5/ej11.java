package practica2025;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*11. Dado dos arreglos de números enteros A y B determinar si
todos los números almacenados en el arreglo A están presentes
en el arreglo B.
 */
public class ej11{
     public static final int MAX = 10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR =1;
    public static void main(String[]args){
        int [] arrA= new int[MAX];
        int [] arrB= new int[MAX];
        cargar_arreglo(arrA);

        cargar_arreglo(arrB);
        System.out.println(" ");
        imprimir_arreglo(arrA);
        System.out.println(" ");
        imprimir_arreglo(arrB);
        if(mismosElementos(arrA, arrB)){
            System.out.println("El arreglo b tiene todos los elementos del arreglo a");
        }else{
            System.out.println("El arreglo b no tiene todos los elementos del arreglo a");
        }

        
    }
    public static boolean mismosElementos(int[]arrA, int []arrB){
        int contador =0;
        for(int i =0;i<MAX;i++){
            
                if(arrA[i]==arrB[i]){
                    contador++;
                }
            
        }
        return contador==MAX;
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