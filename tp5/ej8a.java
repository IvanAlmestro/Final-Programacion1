package practica2025;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*8. Hacer un programa que determine si los valores almacenados en
un arreglo de enteros se encuentran en orden ascendente.
 */
public class ej8a {
        public static final int MAX = 10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR =1;
    public static void main(String[]args){

        int [] arr= {1,2,3,4,5,6,7,8,9,80};
        int pos =0;
   
        System.out.println(" ");
        imprimir_arreglo(arr);
        esAscendente(arr);
        

        
    }
   
    public static void esAscendente(int[]arr){
        int i =0;
        while(i<MAX-1 && arr[i]<arr[i+1]){
            i++;
        }
        //ver si esto habria que hacerlo en el main 
        if(i>=MAX-1){
            System.out.println("El arreglo es ascendente");
        }else{
            System.out.println("El arreglo no es ascendente");
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
