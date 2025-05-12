package practica2025;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*9. Hacer un programa que dado un arreglo de enteros de tamaño 10
que se encuentra cargado, solicite al usuario un número entero y
lo agregue al principio del arreglo (posición 0). Para ello tendrá
que realizar un corrimiento a derecha (se pierde el último valor del
arreglo) y colocar el número en el arreglo en la posición indicada. */
public class ej9 {
    public static final int MAX = 10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR =1;
    public static void main(String[]args){
        int [] arr= new int[MAX];

        cargar_arreglo(arr);
        System.out.println(" ");
        imprimir_arreglo(arr);
        int numero = obtenerNumero();
        colocarNumero(arr, numero);
        imprimir_arreglo(arr);

        
    }
    public static void corrimiento_derecha(int[]arr, int pos){
        
        for(int i =MAX-1; i>pos; i--){
            arr[i]= arr[i-1];
        }
    }
    public static void colocarNumero(int[]arr, int numero){
        int i =0;
        corrimiento_derecha(arr, i);
        arr[i]=numero;
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
