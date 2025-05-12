package practica2025;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*27. Hacer un programa que dado un número N ingresado por el
usuario, elimine las secuencias de tamaño N de números distintos
de cero.
 */
public class ej27 {
    public static final int MAX = 20;
    public static void main(String[]args){
        int[] arr = {0, 0, 0, 0, 4, 5, 6, 0, 7, 8, 9, 10, 0, 13, 12, 11, 0, 14, 15, 0};
        int numero=0;
        System.out.println("\nArreglo");
        imprimir_arreglo(arr);
        numero= obtenerNumero();
        eliminarSecTamanioX(arr,numero);
        imprimir_arreglo(arr);


    }
    public static void eliminarSecTamanioX(int[]arr, int numero){
        int inicio=0;
        int fin = -1;
        int tamanioActual=0;
 
        while(inicio<MAX){
            inicio=buscarInicio(arr, fin+1);
            if(inicio < MAX){
                fin = buscarFin(arr, inicio);
                tamanioActual= fin-inicio+1;
                if(tamanioActual==numero){
                    eliminarSec(arr, inicio, fin);
             
                }
            }
        }
       
        
    }
    public static void eliminarSec(int[]arr, int ini, int fin){
        int contador = fin-ini+1;
        int i =0;
        while(i<contador){
            corrimiento_izq(arr, ini);
            i++;
        }
    }
    public static void corrimiento_izq(int[] arr, int pos) {
        for (int i = pos; i < MAX - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[MAX - 1] = 0;
    }
    public static void imprimir_arreglo(int [] arr){
        for (int pos=0;pos<MAX;pos++){
            System.out.print(arr[pos] + "|");
        }
    }

    public static int buscarInicio(int[]arr, int ini){
        while(ini<MAX&& arr[ini] ==0){
            ini++;
        }
        return ini;

    }
    public static int buscarFin(int[]arr, int ini){
        while(ini<MAX&& arr[ini]!=0){
            ini++;
        }
        return ini-1;
    }
       public static int obtenerNumero(){
        int numero=0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Ingrese un numero");
            numero = Integer.valueOf(entrada.readLine());
        } catch (Exception e) {
            // TODO: handle exception
        }
        return numero;
    }

}
