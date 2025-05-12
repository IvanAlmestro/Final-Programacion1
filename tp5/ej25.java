package practica2025;

/*25. Hacer un programa que devuelva la posicin de inicio y fin de la
anteltima secuencia de nmeros distintos de ceros.
 */
public class ej25 {
    public static final int MAX = 20;
    public static void main(String[]args){
        int[] arr = {0, 0, 0, 0, 4, 5, 6, 0, 7, 8, 9, 10, 0, 13, 12, 11, 0, 14, 15, 0};
        
        System.out.println("\nArreglo");
        imprimir_arreglo(arr);
        posAnteultimaSec(arr);


    }

    public static void posAnteultimaSec(int[]arr){
        int inicio = 0; 
        int fin =MAX;
        int contador =0;
     
        while(fin>0){
            inicio = buscarInicio(arr, fin-1);
            if(fin>0){
                fin = buscarFin(arr, inicio);

                contador++;
            }
            if(contador ==2){
                System.out.println("El inicio de la anteultimasec esta en: " + fin+ "y el final esta en: " +inicio);
            }
        }
    }
    public static int buscarInicio(int[]arr, int ini){
        while(ini>0&& arr[ini]==0){
            ini--;
        }
        return ini;
    }
    public static int buscarFin(int[]arr, int fin){
        while(fin>0 && arr[fin] != 0){
            fin--;
        }
        return fin+1;
    }
    public static void imprimir_arreglo(int [] arr){
        for (int pos=0;pos<MAX;pos++){
            System.out.print(arr[pos] + "|");
        }
    }

}
