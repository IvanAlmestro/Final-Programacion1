package tp6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ejfinal2 {
    public static final int MAXF = 5;
    public static final int MAXC= 15;
    public static void main(String[]args){
        int[][] img1 = {
            {0, 0, 2, 0, 1, 2, 0, 1, 2, 1, 3, 0, 5, 3, 4, 0},
            {0, 9, 7, 8, 9, 2, 3, 0, 2, 3, 6, 7, 8, 9, 0, 0},
            {0, 0, 0, 4, 3, 1, 0, 0, 0, 0, 0, 1, 9, 7, 0, 0},
            {0, 8, 9, 7, 8, 9, 2, 3, 6, 7, 8, 9, 4, 3, 8, 0},
            {0, 1, 2, 1, 3, 1, 1, 1, 2, 3, 1, 1, 9, 0, 0, 0}
        };

        int[][] img2 = {
            {0, 0, 2, 0, 1, 2, 0, 1, 2, 1, 3, 0, 4, 2, 1, 0},
            {0, 9, 7, 8, 9, 2, 3, 0, 2, 3, 6, 7, 8, 9, 0, 0},
            {0, 0, 0, 4, 3, 1, 5, 0, 0, 0, 0, 1, 9, 7, 0, 0},
            {0, 8, 9, 7, 8, 9, 2, 3, 6, 7, 8, 9, 4, 3, 8, 0},
            {0, 1, 2, 1, 3, 1, 1, 1, 2, 3, 1, 1, 9, 0, 0, 0}
        };
        double similitud =0.0;
        similitud=obtenerSimilitud();
        esSimilar(img1,img2,similitud);
    }   
    public static double obtenerSimilitud(){
        double similitud =0.0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Ingrese un numero entre 0 y 1");
            similitud = Double.valueOf(entrada.readLine());
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return similitud;
    }
    public static void esSimilar(int[][]mat1, int[][]mat2, double minSimilitud){
        double cantIguales=0;
        double totalSecs=0;
        for(int fila =0; fila<MAXF ; fila++){
            cantIguales += cantIguales(mat1[fila], mat2[fila]);
             totalSecs += cantTotalSecs(mat1[fila]);
        }
       
        if ((cantIguales/totalSecs) > minSimilitud){
            System.out.println("Es similar");
        }
        else{
            System.out.println("no es similar");
        }
    }
    public static double cantTotalSecs(int[]arr1){
        int inicio=0;
        int fin =-1;
        int cantTotal=0;
        while (inicio<MAXC) {
            inicio= buscar_inicio(arr1, fin+1);
            if(inicio<MAXC){
                fin=buscar_fin(arr1, inicio);
                cantTotal++;
            }
        }
        return cantTotal;
    }
    public static double cantIguales(int[]arr1, int[]arr2){
        int inicio=0;
        int fin =-1;
        int cantIguales=0;
        while (inicio<MAXC) {
            inicio= buscar_inicio(arr1, fin+1);
            if(inicio<MAXC){
                fin=buscar_fin(arr1, inicio);
                if(sonIguales(arr1,arr2,inicio,fin)){
                    cantIguales++;
                }
            }
        }
        return cantIguales;
    }
    public static boolean sonIguales(int[]arr1, int []arr2,int ini,int fin){
        while(ini<=fin && arr1[ini] == arr2[ini]){
            ini++;
        }
        return ini>fin;
    }
    public static int buscar_inicio(int[]arr, int ini){
        while(ini<MAXC && arr[ini]==0){
            ini++;
        }
        return ini;
    }
    public static int buscar_fin(int[]arr, int fin){
        while(fin<MAXC && arr[fin]!=0){
            fin++;
        }
        return fin-1;
    }
}
