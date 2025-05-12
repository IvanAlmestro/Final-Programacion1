package practica2025;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*32. Se tiene un arreglo de enteros de tamaño 20 de secuencias de
números entre 1 y 9, separadas por 0. El arreglo está precargado,
y además empieza y termina con uno o más separadores 0. Hacer
un programa que permita obtener a través de métodos la posición
de inicio y la posición de fin de la secuencia ubicada a partir de
una posición entera ingresada por el usuario. Finalmente, si
existen imprima por pantalla ambas posiciones obtenidas.
 */
public class ej32 {
    public static final int MAX = 20;

    public static void main(String[] args) {
        int[] arrA = {0, 0, 0, 0, 4, 5, 6, 0, 7, 8, 9, 3, 0, 3, 2, 1, 0, 5, 4, 0};

        int pos=0;

        System.out.println("\nArreglo original:");
        imprimir_arreglo(arrA);
        pos = obtenerPos();
        int inicio=buscarInicio(arrA, pos);
        int fin=buscarFin(arrA, inicio);
        System.out.println("el inicio es en: " + inicio);
        System.out.println("el fin es en: " + fin);


    }

    public static int obtenerPos(){
        int numero=0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Ingrese un numero pos");
            numero = Integer.valueOf(entrada.readLine());
        } catch (Exception e) {
            // TODO: handle exception
        }
        return numero;
    }



    public static void imprimir_arreglo(int[] arr) {
        for (int i = 0; i < MAX; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.println();
    }

    public static int buscarInicio(int[] arr, int ini) {
        while (ini < MAX && arr[ini] == 0) {
            ini++;
        }
        return ini;
    }

    public static int buscarFin(int[] arr, int ini) {
        while (ini < MAX && arr[ini] != 0) {
            ini++;
        }
        return ini - 1;
    }
}

