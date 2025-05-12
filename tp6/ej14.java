package tp6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*14. Hacer un programa que dada la matriz de secuencias de
caracteres definida y precargada, elimine de cada fila todas las
ocurrencias de una secuencia patrón dada por un arreglo de
caracteres de tamaño igual al tamaño de columnas de la matriz
(sólo tiene esa secuencia con separadores al inicio y al final). Al
eliminar en cada fila se pierden los valores haciendo los
corrimientos.
 */
public class ej14 {
            public static final int MAXFILA = 4, MAXCOL=20;

    public static void main(String[]args){
        char[][] matchar =  
                        {
                            {' ', 'a', 'b', 'c', 'd', ' ', 'z', ' ', 's', 'g', 'h', ' ', 'd', 'f', ' ', ' ', 'f','k', 'l', ' '},
                            {' ', 'z', 'h', ' ', 'w', 'z', 'z', ' ', 's', ' ', 'h', ' ', 'a', 'b', 'c', 'd', ' ','q', 'l', ' '},
                            {' ', 'h', 'h', ' ', 'd', ' ', 'z', ' ', 's', 'x', ' ', ' ', 'd', 'q', ' ', ' ', 'f','s', ' ', ' '},
                            {' ', 's', 'h', ' ', 'd', ' ', 'a', 'b', 'c', 'x', ' ', 'f', 'f', 'q', ' ', ' ', 'f','x', ' ', ' '}
                        };

        char[] arrPatron =  {' ', 'a', 'b', 'c', 'd', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' '};


        System.out.println(".");
        imprimir_matriz(matchar);


        recorrerFilas(matchar, arrPatron);
        System.out.println(" oCURRENCIA BORRADA ");
        imprimir_matriz(matchar);

    }
    public static void recorrerFilas(char[][]mat, char[]arrP){
        for(int fila = 0; fila<MAXFILA; fila++){
            buscar_eliminar_patron(mat[fila], arrP);
        }
    }
    public static void buscar_eliminar_patron(char []arr, char[]arrP){
        int inicio = 0;
        int fin = -1;
        int iniP =buscar_inicio(arrP, 0);
        int finP=buscar_fin(arrP, iniP);
        while(inicio<MAXCOL){
            inicio = buscar_inicio(arr, fin+1);
            if(inicio<MAXCOL){
                fin = buscar_fin(arr, inicio);

                if(esIgual(arr, arrP,inicio, fin, iniP,finP)){
                    eliminar(arr, inicio, fin);
                    fin=inicio-1;
                }
            }
        }
    }
                
                


    private static void eliminar(char[] arr, int inicio, int fin) {
        for(int i = inicio; i<=fin; i++){
            corrimiento_izq(arr, inicio);
        }

    }

    private static boolean esIgual(char[] arr, char[] arrP, int inicio, int fin, int iniP, int finP) {
        int tamanio=fin-inicio+1;
        int tamanioP=finP-iniP+1;
        if(tamanio!=tamanioP){
            return false;
        }

        while(inicio<=fin&& iniP<=finP && arr[inicio]==arrP[iniP]){
            inicio++;
            iniP++;
        }
        return inicio>fin && iniP>finP;
    }
    public static int buscar_inicio(char[]arr, int ini){
        while(ini<MAXCOL && arr[ini]==' '){
            ini++;
        }
        return ini;
    }
    public static int buscar_fin(char[]arr, int fin){
        while(fin<MAXCOL && arr[fin]!= ' '){
            fin++;
        }
        return fin-1;
    }

    

    public static void corrimiento_izq(char[]arr, int ini){
        for(int i =ini; i<MAXCOL-1; i++){
            arr[i]=arr[i+1];
        }
        arr[MAXCOL-1] = ' ';
    }



    public static void imprimir_matriz(char[][] matint) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            for (int col = 0; col < MAXCOL; col++) {

                System.out.print("|" + matint[fila][col]);
            }
            System.out.print("\n");
        }
    }
}


