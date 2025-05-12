package practica2025;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*4. Buscar un elemento en un arreglo de caracteres ya cargado de
tamaño 10 y mostrar la/s posición/es del elemento, en caso de no
estar indicarlo también. */
public class ej4 {
    public static final int MAX = 10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR =1;
    public static void main(String[]args){
        int [] arr= new int[MAX];
        int numero = 0;
        cargar_arreglo(arr);
        System.out.println(" ");
        imprimir_arreglo(arr);
        numero = obtenerNumero();        
        buscarNumero(arr, numero);

    }
    public static void buscarNumero(int[]arr, int numero){
      
        int i=0;
        while(i < MAX-1 && arr[i] != numero){
   
            i++;
        }
        if(arr[i]==numero){
            System.out.println("El numero se encontro en la pos "+ i);
        }else{
            System.out.println("No se encontro el numero en el arreglo");
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
