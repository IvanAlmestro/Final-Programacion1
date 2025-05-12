package practica2025;

import java.util.Random;

/*9. Dado un arreglo de caracteres, determinar si en el arreglo existe al
menos una letra repetida */
public class ej9a {
    public static final int MAX = 10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR =1;
    public static void main(String[]args){
        char [] arr= new char[MAX];
     
        cargar_arreglo_char(arr);
        System.out.println(" ");
        imprimir_arreglo(arr);
        if(tieneLetraRepetida(arr)){
            System.out.println("El arreglo tiene letra repetida");
        }else{
            System.out.println("no tiene repetidos");
        }
     

    }
    public static boolean tieneLetraRepetida(char[]arr){
        int i =0, j=0;
        char letra;
        int contador =0;
        
        while (j<MAX) {
            letra =  arr[j];
            while(i<MAX){
                            
                if(letra == arr[i]){
                    contador++;
                        
                }
                i++;
            }
            j++;
        }
        return contador >1;
    }
    public static void imprimir_arreglo(char[] arr) {
        for (int i = 0; i < MAX; i++) {
            System.out.print("|" + arr[i] + "|");
          
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
