package practica2025;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*1. Cargar un arreglo de tamaño 15, pidiendo el ingreso por teclado
de valores entre 1 y 12. Luego mostrar cómo quedó cargado. */

public class ej1{
    public static final int MAX = 15;
    public static final int MAXVALOR = 12;
    public static final int MINVALOR =1 ;
    public static void main(String[]args){  
        int [] arr = new int [MAX];
        System.out.println("");
        imprimir_arreglo(arr);
        rellenarArreglo(arr);
        imprimir_arreglo(arr);
        
        

    }


    public static void rellenarArreglo(int[] arr) {
        int i = 0;
        while (i < MAX) {
            int valor = obtener_numero();
            if (valor < MINVALOR || valor > MAXVALOR) {
                System.out.println("El número es incorrecto. Debe estar entre " + MINVALOR + " y " + MAXVALOR + ".");
            } else {
                arr[i] = valor;
                i++;
            }
        }
    }
    public static int obtener_numero(){
        int valor = 0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("ingrese un numero entre 1 y 12");
            
            valor = Integer.valueOf(entrada.readLine());
        } catch (Exception e) {
            // TODO: handle exception
        }
        return valor;
    }

    public static void imprimir_arreglo(int[] arr) {
        for (int i = 0; i < MAX; i++) {
            System.out.print("|" + arr[i] + "|");
          
        }
    }
}