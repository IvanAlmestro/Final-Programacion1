package practica2025;

import java.util.Random;

/*3. Con el mismo arreglo del ejercicio anterior informe por pantalla
cuantos elementos del mismo están por encima del promedio
calculado. */
public class ej3 {
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
        int promedio = 0;
        for(int i =0; i<MAX; i++){
            total += arr[i];
            contador++;
        }
        promedio = total/contador;
        System.out.println(" El promedio del arreglo es: " + promedio);
        elemMayorAProm(arr, promedio);

    }
    public static void elemMayorAProm(int[]arr, int valor){
        int contador= 0;
        for(int i = 0; i<MAX; i++){
            if(arr[i]>valor){
                contador++;
            }
        }
        System.out.println("La cantidad de elementos superior al promedio es de: " + contador);
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
