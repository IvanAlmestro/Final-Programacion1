package practica2025;


public class ej28 {
/*28. Hacer un programa que elimine de un arreglo todas las
ocurrencias de una secuencia patrón dada por otro arreglo. */
    public static final int MAX = 20;

    public static void main(String[] args) {
        int[] arr = {0, 7, 8, 9, 10, 0, 6, 0, 7, 8, 9, 10, 0, 13, 12, 11, 0, 14, 15, 0};
        int[] arrPatron = {7, 8, 9, 10}; // Patrón a eliminar

        System.out.println("\nArreglo original:");
        imprimir_arreglo(arr);

        eliminarSecPatron(arr, arrPatron);

        System.out.println("\nArreglo después de eliminar secuencias:");
        imprimir_arreglo(arr);
    }

    public static void eliminarSecPatron(int[] arr, int[] arrPatron) {
        int inicio = 0;
        int fin = -1;

        while (inicio < MAX) {
            inicio = buscarInicio(arr, fin + 1);
            if (inicio < MAX) {
                fin = buscarFin(arr, inicio, MAX);

                if (sonIguales(arr, arrPatron, inicio, fin)) {
                    eliminarSec(arr, inicio, fin);
                    fin = inicio - 1; // Reiniciar búsqueda después de eliminar
                }
            }
        }
    }

    public static boolean sonIguales(int[] arr, int[] arrPatron, int ini, int fin) {
        int iniPatron = buscarInicio(arrPatron, 0);
        int finPatron = buscarFin(arrPatron, iniPatron, arrPatron.length);

        int tamanioPatron = finPatron - iniPatron + 1;
        int tamanioArr = fin - ini + 1;

        if (tamanioArr != tamanioPatron) {
            return false; // Si no son del mismo tamaño, no pueden ser iguales
        }

        // Comparar elementos de ambas secuencias
        while (ini <= fin && iniPatron <= finPatron && arr[ini] == arrPatron[iniPatron]) {
            ini++;
            iniPatron++;
        }

        return ini > fin; // Si recorrimos toda la secuencia, son iguales
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