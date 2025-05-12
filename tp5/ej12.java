package practica2025;

import java.util.Random;

/*12. Dado dos arreglos de números enteros: un arreglo A de tamaño
MAXA y un arreglo B de tamaño MAXB con números entre 0 y
MAXA-1, determinar la suma de los elementos del arreglo A cuyas
posiciones son indicadas por el arreglo B. Por ejemplo, dado
A={3,6,31,9}, MAXA=3 y B={0,2} con MAXB=2 el sistema deberá
informar: 34 (lo cual es el resultado de sumar el 3 de la posición 0
y el 31 de la posición 2 del arreglo A).
 */
public class ej12 {
    public static final int MAXA = 10;
    public static final int MAXB= 3;
    public static final int MAXVALOR = MAXA-1;
    public static final int MINVALOR =0;
    public static void main(String[]args){
        int [] arrA= new int[MAXA];
        int [] arrB= new int[MAXB];
        cargar_arreglo(arrA);

        cargar_arreglo(arrB);
        System.out.println(" ");
        imprimir_arreglo(arrA);
        System.out.println(" ");
        imprimir_arreglo(arrB);
        System.out.println("La suma da: " + suma(arrA, arrB));
        
    }
    public static double suma(int[]arrA, int[]arrB){
        double suma =0.0;
        int aux=0;
        int i =0;
        while (i<MAXB) {
            aux =arrB[i];
            suma += arrA[aux];
            i++;
        }
            
                
          
       return suma;
    }

    public static void imprimir_arreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("|" + arr[i] + "|");
          
        }
    }
   
    public static void cargar_arreglo(int[] arr) {
        Random r = new Random();
        for (int fila = 0; fila < arr.length; fila++) {
            
                if (r.nextDouble() < 1) {
                    arr[fila] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            }
        }
    }

}
