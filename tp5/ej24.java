package practica2025;
/*24. Hacer un programa que devuelva la posicin de inicio y fin de la
secuencia de nmeros distintos de ceros cuya suma del contenido
sea mayor.
 */
public class ej24 {
    public static final int MAX = 20;
    public static void main(String[]args){
        int[] arr = {0, 0, 0, 0, 4, 5, 6, 0, 7, 8, 9, 10, 0, 13, 12, 11, 0, 14, 15, 0};
        
        System.out.println("\nArreglo");
        imprimir_arreglo(arr);
        mayorSuma(arr);


    }
    public static void imprimir_arreglo(int [] arr){
        for (int pos=0;pos<MAX;pos++){
            System.out.print(arr[pos] + "|");
        }
    }
    public static double suma(int []arr, int inicio, int fin){
        double suma=0.0;
        for(int i = inicio; i<=fin; i++){
            suma +=arr[i];
        }
        return suma;
    }
    public static void mayorSuma(int[]arr){
        int ini=0;
        int fin=-1;
        int iniMayor=0;
        int finMayor=0;
        double mayorSuma=-1;
        double sumaActual=0;
        while(ini<MAX){
            ini = buscarInicio(arr, fin+1);
            if(ini<MAX){
                fin=buscarFin(arr, ini);
                sumaActual = suma(arr, ini, fin);
                if(sumaActual>mayorSuma){
                    iniMayor=ini;
                    finMayor=fin;
                    mayorSuma=sumaActual;
                }
                
            }
        }
        System.out.println("La secuencia con mayor suma tiene inicio en: " +iniMayor+ " y fin en: "+ finMayor);
    }
    public static int buscarInicio(int[]arr, int ini){
        while(ini<MAX && arr[ini] == 0){
            ini++;
        }
        return ini;
    }
    public static int buscarFin(int[]arr, int fin){
        while (fin<MAX&& arr[fin]!= 0){
            fin++;
        }
        return fin-1;
    }
}
