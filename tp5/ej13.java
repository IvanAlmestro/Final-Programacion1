package practica2025;

import java.util.Random;

/*13. Dado un arreglo de caracteres de tamaño MAX, hacer un
programa que implemente métodos tal que devuelva al main dos
arreglos: un arreglo con los caracteres que son letras vocales y
otro con los que son consonantes. */
public class ej13 {
    public static final int MAX = 10;

    public static void main(String[]args){
        char[]arr = new char[MAX];
        cargar_arreglo_char(arr);
        char[]arrVocales= arregloVocales(arr);
        char[]arrConsonantes= arregloConsonantes(arr);
        
        imprimir_arreglo(arrConsonantes);
        System.out.println(" ");
        imprimir_arreglo(arrVocales);
        
        System.out.println("original");
        imprimir_arreglo(arr);
    }

    public static char[] arregloVocales(char[]arr){
        int i = 0;
        char[] arrVocales = {};
        while(i<MAX){
            if(arr[i] == 'a'||arr[i] == 'e'||arr[i] == 'i'||arr[i] == 'o'||arr[i] == 'u'){
                arrVocales[i] = arr[i];
            }
        }
        return arrVocales;
    }
    public static char[] arregloConsonantes(char[]arr){
        int i = 0;
        char[] arregloConsonantes = {};
        while(i<MAX){
            if(arr[i] != 'a'||arr[i] != 'e'||arr[i] != 'i'||arr[i] != 'o'||arr[i] != 'u'){
                arregloConsonantes[i] = arr[i];
            }
        }
        return arregloConsonantes;
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
