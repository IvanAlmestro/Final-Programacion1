package practica2025;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*10. Hacer un programa que dado un arreglo de enteros de tamaño
10 que se encuentra precargado, solicite al usuario un número
entero y elimine la primera ocurrencia del número (un número
igual) en el arreglo (si existe). Para ello tendrá que buscar la
posición y si está, realizar un corrimiento a izquierda (queda una
copia de la última posición del arreglo en la anteúltima posición). */
public class ej10 {
    public static final int MAX = 10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR =1;
    public static void main(String[]args){
        int [] arr= new int[MAX];

        cargar_arreglo(arr);
        System.out.println(" ");
        imprimir_arreglo(arr);
        int numero = obtenerNumero();
        eliminarPrimerOcurrencia(arr, numero);
        imprimir_arreglo(arr);

        
    }
    public static void eliminarPrimerOcurrencia(int []arr, int numero){
        boolean seEncontro=false;
        int i =0;
        while(i < MAX && !seEncontro){
            if(arr[i]==numero){
                seEncontro = true;
            }
            i++;
        }
        if(i <MAX && seEncontro){
            corrimiento_izq(arr, i-1);
        }
    }
    public static void corrimiento_izq(int[]arr, int pos){
        
        for(int i =pos; i<MAX-1 ; i++){
            arr[i]= arr[i+1];
        }
    }

    public static void imprimir_arreglo(int[] arr) {
        for (int i = 0; i < MAX; i++) {
            System.out.print("|" + arr[i] + "|");
          
        }
    }
    public static int obtenerNumero(){
        int numero =0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Ingrese un numero entero");
            numero = Integer.valueOf(entrada.readLine());
        } catch (Exception e) {
            // TODO: handle exception
        }
        return numero;
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
