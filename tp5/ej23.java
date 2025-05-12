package practica2025;

import java.util.Random;

/*Dado un arreglo de tamao de arreglo MAX=20 de secuencias. En
el caso de eliminar secuencias se debe hacer corrimiento.
23. Hacer un programa que devuelva la posicin de inicio y fin de la
primera secuencia de nmeros distinta de ceros.
 */
public class ej23 {
    
    public static final int MAX = 20;
    public static final int MAXVALOR = 20;
    public static final int MINVALOR =1;
    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 4, 5, 6, 0, 7, 8, 9, 10, 0, 13, 12, 11, 0, 14, 15, 0};


        System.out.println("\nArreglo");
        imprimir_arreglo(arr);
        int inicio= buscarInicio(arr, 0);
        int fin = buscarFin(arr, inicio);
        System.out.println("\nLa secuencia comienza en la posicion: "+inicio+" y termina en la posicion: "+fin);
    }
    public static int buscarInicio(int[]arr, int ini){
        while (ini < MAX && arr[ini] == 0 ) {
            ini++;
        }
        return ini;
            
    }
    public static int buscarFin(int[]arr, int ini){
        while(ini<MAX && arr[ini]  != 0){
            ini++;
        }
        return ini-1;
    }

 


    public static void imprimir_arreglo(int[] arr) {
        for (int i = 0; i < MAX; i++) {
            System.out.print("|" + arr[i] + "|");
          
        }
    }

}
