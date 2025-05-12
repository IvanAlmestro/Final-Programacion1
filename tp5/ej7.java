package practica2025;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*7. Implementar un método que realice un corrimiento a derecha
un arreglo ordenado de tamaño MAX=10 a partir de una posicion */
public class ej7 {
    public static final int MAX = 10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR =1;
    public static void main(String[]args){
        int [] arr= new int[MAX];
        int pos =0;
        cargar_arreglo(arr);
        System.out.println(" ");
        imprimir_arreglo(arr);
        pos = obtenerNumero();
        corrimiento_derecha(arr, pos);
        System.out.println("Asi queda el arreglo corrido  a derecha desde la pos: " + pos);
        imprimir_arreglo(arr);

        
    }
    public static void corrimiento_derecha(int[]arr, int pos){
        
        for(int i =MAX-1; i>pos; i--){
            arr[i]= arr[i-1];
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
            System.out.println("Ingrese una pos entre el 0 y 9, inclusive");
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
