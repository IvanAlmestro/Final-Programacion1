package practica2025;

/*29. Hacer un programa que elimine de un arreglo todas las
secuencias que tienen orden descendente entre sus elementos.
 */
public class ej29 {
    public static final int MAX = 20;

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 4, 5, 6, 0, 7, 8, 9, 10, 0, 13, 12, 11, 0, 15, 14, 0};
        

        System.out.println("\nArreglo original:");
        imprimir_arreglo(arr);

        eliminarSec(arr);

        System.out.println("\nArreglo después de eliminar secuencias:");
        imprimir_arreglo(arr);
    }

    public static void eliminarSec(int[] arr) {
        int inicio = 0;
        int fin = -1;

        while (inicio < MAX) {
            inicio = buscarInicio(arr, fin + 1);
            if (inicio < MAX) {
                fin = buscarFin(arr, inicio, MAX);

                if (esDescendente(arr, inicio, fin)) {
                    eliminarSec(arr, inicio, fin);
                    fin = inicio - 1; // Reiniciar búsqueda después de eliminar
                }
            }
        }
    }

    public static boolean esDescendente(int[] arr, int ini, int fin) {
       while(ini< MAX && arr[ini]>arr[ini+1]){
            ini++;
       }
       return ini >fin;
    }

    public static void eliminarSec(int[] arr, int ini, int fin) {
        int cantidad = fin - ini + 1;
        for (int i = 0; i < cantidad; i++) {
            corrimiento_izq(arr, ini);
        }
    }

    public static void corrimiento_izq(int[] arr, int pos) {
        for (int i = pos; i < MAX - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[MAX - 1] = 0; // Última posición en 0
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

    public static int buscarFin(int[] arr, int ini, int maximo) {
        while (ini < maximo && arr[ini] != 0) {
            ini++;
        }
        return ini - 1;
    }
}
