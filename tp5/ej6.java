package practica2025;

import java.util.Random;

/*6. Hacer un programa que dado un arreglo de enteros de tamaño 10
que se encuentra cargado, obtenga la cantidad de números pares
que tiene y la imprima. */
public class ej6 {
    public static final int MAX = 10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR =1;
    public static void main(String[]args){
        int [] arr= new int[MAX];

        cargar_arreglo(arr);
        System.out.println(" ");
        imprimir_arreglo(arr);
        cantPares(arr);
    }
    public static void cantPares(int[]arr){
        int cantPares=0;
        for(int i = 0; i<MAX; i++){
            if((arr[i]%2)==0){
                cantPares++;
            }
        }
        System.out.println("La cantidad de pares del arreglo es de "+ cantPares);
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
