package practica2025;

/*31. Hacer un programa que invierta el orden de la última secuencia
en un arreglo.
 */
public class ej31 {
    public static final int MAX =20;
    public static void main (String[]args){
        int[] arrA = {0, 0, 0, 0, 4, 5, 6, 0, 7, 8, 9, 10, 0, 13, 12, 11, 0, 15, 14, 0};
        int fin= buscarFin(arrA, MAX-1);
        int inicio = buscarInicio(arrA, fin);
       
        
        System.out.println("\nArreglo original:");
        imprimir_arreglo(arrA);

        invertirOrdenSec(arrA, inicio, fin);

        System.out.println("\nArreglo después de eliminar secuencias:");
        imprimir_arreglo(arrA);
    }

    public static void invertirOrdenSec(int[]arr, int inicio, int fin){
        int aux =0;
        while(inicio<=fin)
        {
            aux= arr[inicio];
            arr[inicio]= arr[fin];
            arr[fin] = aux;
            inicio++;
            fin--;
        }
    }
    public static int buscarInicio(int[]arr, int fin){
        while(fin >0 && arr[fin] != 0){
            fin--;
        }
        return fin+1;
    }
    public static int buscarFin(int[]arr, int fin){
        while(fin>0&& arr[fin]==0){
            fin--;
        }
        return fin;
    }
    public static void imprimir_arreglo(int[] arr) {
        for (int i = 0; i < MAX; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.println();
    }
}
