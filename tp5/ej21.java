package practica2025;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*21. Hacer un programa que inserte un elemento en un arreglo
(ordenado decrecientemente) de tamao MAX=10. */
public class ej21 {
       public static final int MAX = 10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR =1;
    public static void main(String[]args){
        int [] arr= new int[MAX];

        cargar_arreglo(arr);

 
        System.out.println(" ");
        imprimir_arreglo(arr);
        insertarNumeroOrdenado(arr);
                imprimir_arreglo(arr);
     

        
    }
    public static void insertarNumeroOrdenado(int[]arr){
        int numero = obtenerNumero();
        boolean inserto=false;
        int i = 0;
        while(i<MAX && !inserto){
            if(arr[i] < numero){
                corrimiento_der(arr, i);
                arr[i] = numero;
                inserto = true;
            }else{
                i++;
            }
        }
        
    }
    public static void corrimiento_der(int[]arr, int ini){
        for(int i = MAX-1; i>ini; i--){
            arr[i]= arr[i-1];
        }
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
