package practica2025;

import java.util.Random;

/*5. Hacer un programa que dado un arreglo de caracteres de tamaño
10 que se encuentra cargado, invierta el orden del contenido. Este
intercambio no se debe realizar de manera explícita, hay que
hacer un método que incluya una iteración de intercambio. */
public class ej5 {
    public static final int MAX = 10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR =1;
    public static void main(String[]args){
        char [] arr= new char[MAX];
     
        cargar_arreglo_char(arr);
        System.out.println(" ");
        imprimir_arreglo(arr);
        intercambiarOrdenArr(arr);
        System.out.println("Luego de intercambiar el orden del arreglo se ve asi: ");
        imprimir_arreglo(arr);
     

    }
    public static void imprimir_arreglo(char[] arr) {
        for (int i = 0; i < MAX; i++) {
            System.out.print("|" + arr[i] + "|");
          
        }
    }
    public static void intercambiarOrdenArr(char[]arr){
        char caja =' ';
        int i =0;
        int j=MAX-1;
        while (i<j) {
            caja = arr[i];
            arr[i] = arr[j];
            arr[j] = caja;
            i++;
            j--; 
        }
    }
    //carga de arreglo de char con valores de 'a' a la 'z'
    public static void cargar_arreglo_char(char [] arr){
        Random r = new Random();
        for (int pos = 0; pos < MAX; pos++){
        arr[pos]=(char)(r.nextInt(26) + 'a');
        }
    }
}
