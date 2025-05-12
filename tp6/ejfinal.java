package tp6;

public class ejfinal {
    public static final int MAXF = 5;
    public static final int MAXC = 10;
    public static final int MAXP = 16;

    public static void main(String[] args) {
        // Matriz de búsqueda
        char[][] matchar = {
            {'P', 'P', 'G', 'C', 'I', 'Y', 'P', 'X', 'N', 'P'},
            {'M', 'C', 'A', 'S', 'A', 'C', 'C', 'A', 'S', 'A'},
            {'F', 'V', 'J', 'O', 'L', 'J', 'W', 'G', 'B', 'P'},
            {'T', 'P', 'O', 'B', 'I', 'N', 'X', 'X', 'A', 'B'},
            {'S', 'M', 'T', 'U', 'D', 'A', 'I', 'N', 'W', 'S'}
        };
        // Arreglo con palabras
        char[] arrP = {'C', 'A', 'S', 'A', ' ', 'P', 'E', 'R', 'R', 'O', ' ', 'T', 'U', 'D', 'A', 'I', ' '};

        recorrerFilas(matchar, arrP);
    }

    // Encuentra el primer índice no vacío en arr
    public static int buscar_inicio(char[] arr, int ini) {
        while (ini < MAXP && arr[ini] == ' ') {
            ini++;
        }
        return ini;
    }

    // Encuentra el último índice de la palabra en arr
    public static int buscar_fin(char[] arr, int ini) {
        while (ini < MAXP && arr[ini] != ' ') {
            ini++;
        }
        return ini-1;
    }


    public static void seEncontro(char[] arrM, char[] arrP, int ini, int fin, int fila) {
        int tamPatron = fin - ini + 1;

        // Iterar a través de arrM para buscar la palabra
        for (int i = 0; i < MAXC; i++) {
            int j = 0;

            // Asegurarse de no exceder los límites del arreglo
            while (j < tamPatron && i + j < MAXC && arrM[i + j] == arrP[ini + j]) {
                j++;
            }

            // Verificar si se encontró la palabra completa
            if (j == tamPatron) {
                System.out.println("Palabra encontrada en la fila: " + fila + " y en la col: " + i);
                // Incrementar i para evitar superposición en la siguiente iteración
                i += tamPatron - 1;
            }
        }
    }

    // Método para buscar palabras en una fila específica
    public static void recorrerSecuencias(char[] arrM, char[] arrP, int filaNum) {
        int inicio = 0, fin = -1;

        while (inicio < MAXP) {
            inicio = buscar_inicio(arrP, fin + 1);
            if (inicio < MAXP) {
                fin = buscar_fin(arrP, inicio);
                seEncontro(arrM, arrP, inicio, fin, filaNum);
            }
        }
    }

    // Método para recorrer todas las filas
    public static void recorrerFilas(char[][] mat, char[] arrP) {
        for (int fila = 0; fila < MAXF; fila++) {
            recorrerSecuencias(mat[fila], arrP, fila);
        }
    }
}