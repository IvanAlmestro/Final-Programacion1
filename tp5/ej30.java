package practica2025;

public class ej30 {
    /*30. Hacer un programa que reemplace de un arreglo A todas las
ocurrencias de una secuencia patrón dada en un arreglo P, por la
secuencia contenida en el arreglo R de igual tamaño.
 */
public static final int MAX = 20;

    public static void main(String[] args) {
        int[] arrA = {0, 0, 0, 0, 4, 5, 6, 0, 7, 8, 9, 10, 0, 13, 12, 11, 0, 15, 14, 0};
        int[] arrP = {7, 8, 9, 10}; // Patrón a eliminar
        int[] arrR = {0, 0, 9, 3, 0, 2, 0, 0, 2, 4, 1, 6, 0, 22, 21, 20, 2, 0, 0, 0};

        System.out.println("\nArreglo original:");
        imprimir_arreglo(arrA);

        reemplazarSecs(arrA, arrP,arrR);

        System.out.println("\nArreglo después de eliminar secuencias:");
        imprimir_arreglo(arrA);
    }

    public static void reemplazarSecs(int[] arr, int[] arrP, int[] arrR) {
        int inicio = 0;
        int fin = -1;

        while (inicio < MAX) {
            inicio = buscarInicio(arr, fin + 1);
            if (inicio < MAX) {
                fin = buscarFin(arr, inicio, MAX);

                if (esIgual(arr, arrP, inicio, fin)) {
                    int tamanio = fin - inicio + 1;

                    // Buscar una subsecuencia de igual tamaño en arrR
                    int iniR = 0, finR = -1;
                    int reemplazoHecho = 0; // Variable para controlar si ya hicimos el reemplazo

                    while (iniR < arrR.length && reemplazoHecho == 0) {
                        iniR = buscarInicio(arrR, finR + 1);
                        if (iniR < arrR.length) {
                            finR = buscarFin(arrR, iniR, arrR.length);
                            int tamanioR = finR - iniR + 1;

                            if (tamanioR == tamanio) {
                                reemplazarSubSec(arr, arrR, iniR, finR, inicio, fin);
                                reemplazoHecho = 1; // Marcamos que se hizo un reemplazo
                            }
                        }
                    }
                }
            }
        }
    }


    public static boolean esIgual(int[]arr, int[] arrP, int ini, int fin) {
        int inicioPatron = buscarInicio(arrP, 0);
        int finPatron= buscarFin(arrP, inicioPatron, arrP.length);
       while(ini<= fin && inicioPatron<=finPatron && arr[ini]==arrP[inicioPatron]){
            ini++;
            inicioPatron++;
       }
       return inicioPatron >finPatron;
    }

    public static void reemplazarSubSec(int[] arr, int[] arrR, int iniR, int finR, int ini, int fin) {
        while (ini <= fin && iniR <= finR) {
            arr[ini] = arrR[iniR];
            ini++;
            iniR++;
        }
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
