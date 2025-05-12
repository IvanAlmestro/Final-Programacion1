package tp6;
/*15. Hacer un programa que dada la matriz de secuencias de
caracteres definida y precargada elimine todas las secuencias que
tienen orden descendente entre sus elementos.
 */
public class ej15 {
    public static final int MAXFILA = 4, MAXCOL=20;

    public static void main(String[]args){
        char[][] matchar =  
                        {
                            {' ', 'a', 'b', 'c', 'd', ' ', 'z', ' ', 'o', 'b', 'a', ' ', 'd', 'f', ' ', ' ', 'f','k', 'l', ' '},
                            {' ', 'z', 'h', ' ', 'w', 'z', 'z', ' ', 's', ' ', 'h', ' ', 'a', 'b', 'c', 'd', ' ','q', 'l', ' '},
                            {' ', 'h', 'h', ' ', 'd', ' ', 'z', ' ', 's', 'x', ' ', ' ', 'd', 'q', ' ', ' ', 'f','s', ' ', ' '},
                            {' ', 's', 'h', ' ', 'd', ' ', 'a', 'b', 'c', 'x', ' ', 'f', 'f', 'q', ' ', ' ', 'f','x', ' ', ' '}
                        };



        System.out.println(".");
        imprimir_matriz(matchar);


        recorrerFilas(matchar);
        System.out.println(" oCURRENCIA BORRADA ");
        imprimir_matriz(matchar);

    }
    public static void recorrerFilas(char[][]mat){
        for(int fila = 0; fila<MAXFILA; fila++){
            buscar_eliminar(mat[fila]);
        }
    }
    public static void buscar_eliminar(char []arr){
        int inicio = 0;
        int fin = -1;

        while(inicio<MAXCOL){
            inicio = buscar_inicio(arr, fin+1);
            if(inicio<MAXCOL){
                fin = buscar_fin(arr, inicio);

                if(esDescendente(arr, inicio,fin)){
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

    private static boolean esDescendente(char[] arr, int inicio, int fin) {
        int i = inicio;
        if((fin-inicio+1)==1){
            return false;
        }
        while(i<=fin && arr[i]>arr[i+1]){
            i++;
        }
        return i>fin;
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
