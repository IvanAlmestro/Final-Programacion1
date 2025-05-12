package practica2025;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
/*20. Suponer a partir de lo resuelto en el ejercicio anterior (11) que
el elemento a eliminar coincide con el último que hay en el arreglo.
¿Qué pasa en este caso? ¿Cómo daría una solución al problema? */
public class ej20 {
    
       public static final int MAX = 10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR =1;
    public static void main(String[]args){
        int [] arr= new int[MAX];

        cargar_arreglo(arr);

 
        System.out.println(" ");
        imprimir_arreglo(arr);

        eliminarOcurrencias(arr);
        imprimir_arreglo(arr);

        
    }
    public static void eliminarOcurrencias(int[]arr){
        int i =0;
        int numero = obtenerNumero();
        while(i<MAX){
            
            if(arr[i] == numero){
                corrimiento_izq(arr, i);
                //Aca basicamente ponemos el cero en la ultima posicion porque ya sabemos que hubo un corrimiento y de esta manera arreglamos el error.
                arr[MAX-1] =0;
            }
            //con este else hacemos que no saltee las ocurrencias que estan repetidas juntas..
            else{
                i++;
            }
           
            
        }
    }

    public static void corrimiento_izq(int[]arr, int ini){
        for(int i = ini; i<MAX-1; i++){
            arr[i]= arr[i+1];
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
