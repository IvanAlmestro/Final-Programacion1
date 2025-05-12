package practica2025;
/*26. Hacer un programa que devuelva la posición de inicio y de fin
de la secuencia de mayor tamaño. */
public class ej26 {
    public static final int MAX = 20;
    public static void main(String[]args){
        int[] arr = {0, 0, 0, 0, 4, 5, 6, 0, 7, 8, 9, 10, 0, 13, 12, 11, 0, 14, 15, 0};
        
        System.out.println("\nArreglo");
        imprimir_arreglo(arr);
        secMayorTamanio(arr);


    }
    public static void secMayorTamanio(int[]arr){
        int inicio=0;
        int fin = -1;
        int inicioMayor=0;
        int finMayor=0;
        int tamanioActual=0;
        int tamanioMayor=-1;
        while(inicio<MAX){
            inicio=buscarInicio(arr, fin+1);
            if(inicio < MAX){
                fin = buscarFin(arr, inicio);
                tamanioActual= fin-inicio+1;
                if(tamanioActual>tamanioMayor){
                    tamanioMayor=tamanioActual;
                    inicioMayor=inicio;
                    finMayor=fin;
                }
            }
        }
        System.out.println("El inicio de la secuencia de mayor tamanio es en: " + inicioMayor +" y el fin en: " +finMayor);
        
    }
    public static void imprimir_arreglo(int [] arr){
        for (int pos=0;pos<MAX;pos++){
            System.out.print(arr[pos] + "|");
        }
    }

    public static int buscarInicio(int[]arr, int ini){
        while(ini<MAX&& arr[ini] ==0){
            ini++;
        }
        return ini;

    }
    public static int buscarFin(int[]arr, int ini){
        while(ini<MAX&& arr[ini]!=0){
            ini++;
        }
        return ini-1;
    }
}
