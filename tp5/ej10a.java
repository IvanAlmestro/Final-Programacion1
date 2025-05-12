package practica2025;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*10. Hacer un programa que verifique en un arreglo si tiene al
menos N números primos. N debe ser ingresado por el usuario.
Reutilizar los métodos ya desarrollados.
 */
public class ej10a {
     public static final int MAX = 10;
    public static final int MAXVALOR = 20;
    public static final int MINVALOR =1;
    public static void main(String[]args){
        int [] arr= new int[MAX];

        cargar_arreglo(arr);
        System.out.println(" ");
        imprimir_arreglo(arr);
        int numero = obtenerNumero();
        if(hayNcantPrimoss(arr, numero)){
            System.out.println("Hay " + numero + " o mas numeros primos");
        }else{
            System.out.println("NO HAy " + numero + " o mas numeros primos");
        }
        
    }
    
    public static boolean hayNcantPrimoss(int[]arr, int numero){
        int contador=0;
        for(int i =1; i<MAX; i++){
            if(esPrimo(arr[i])){
                contador++;
            }
        }
        return contador>numero;
    }
    public static boolean esPrimo(int numero){
        
        int contador =0;
        for (int i = 2; i <= Math.sqrt(numero); i++){
            if(numero%i==0){
                contador++;
            }

        }
        return contador<=2;
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
