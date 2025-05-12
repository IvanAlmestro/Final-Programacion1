package practica2025;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*7. Hacer un programa que dado un arreglo de enteros y un número
N, genere un arreglo con las posiciones donde se encuentra dicho
número. A continuación, multiplicar por un número M todas las
ocurrencias del número N en el arreglo original.
 */
public class ej7a {
     public static final int MAX = 10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR =1;
    public static final int numeroM =2;
    public static void main(String[]args){
        int [] arr= new int[MAX];
        int [] arrPos= new int[MAX];
        cargar_arreglo(arr);
        System.out.println(" ");
        imprimir_arreglo(arr);
        int numero = obtenerNumero();
        buscarOcurrencia(arr, arrPos, numero);
        imprimir_arreglo(arr);
        System.out.println(" ");
        imprimir_arreglo(arrPos);
        System.out.println("arreglo con las pos de las ocurrencias");
    }
    public static void buscarOcurrencia(int[]arr,int []arrPos, int numero){
        int j=0;
        for(int i =0; i<MAX; i++){
            if(arr[i]== numero){
                arr[i]= arr[i]*numeroM;
                arrPos[j]=i;
                j++;
            }
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
