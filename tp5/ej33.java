package practica2025;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*33. Hacer un programa que dado el arreglo definido y precargado,
y un número entero ingresado por el usuario, copie de forma
continua las secuencias de tamaño igual al número ingresado en
otro arreglo de iguales características e inicializado con 0. La
copia en este último arreglo deben comenzar desde el principio
del mismo.
 */
public class ej33 {
     public static final int MAX = 20;

    public static void main(String[] args) {
        int[] arrA = {0, 0, 0, 0, 4, 5, 6, 0, 7, 8, 9, 0, 0, 3, 2, 1, 0, 5, 4, 0};
        int []arrCopia= new int[MAX];
        int numero=0;
        numero=obtenerNumero();
        copiarSecuencias(arrA,arrCopia, numero);
        System.out.println("\nArreglo original:");
        imprimir_arreglo(arrA);
        copiarSecuencias(arrA,arrCopia, numero);
        System.out.println("\nArreglo Copia:");
        imprimir_arreglo(arrCopia);

       

    }
    public static void copiarSecuencias(int[]arr, int[]arrCopia, int numero){
        int inicio=0;
        int fin =-1;
        int tamanio =0;
        int i =0;
        while(inicio<MAX){
            inicio = buscarInicio(arr, fin+1);
            if(inicio<MAX){
                fin = buscarFin(arr, inicio);
                tamanio = fin-inicio+1;
                if(numero == tamanio){ 
                    
                    i = copiarSec(arr, arrCopia, inicio, fin, i);
                    
                }
            }
            
            
        }
    }
    public static int copiarSec(int[]arr, int[]arrCopia, int inicio, int fin, int i){

        while (inicio<=fin){
            arrCopia[i] = arr[inicio];
            i++;
            inicio++;
        }
        return i;
    }
    public static int obtenerNumero(){
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
