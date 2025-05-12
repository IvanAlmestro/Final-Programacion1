public class prueba2 {
    public static final int MAXF=2;
    public static final int MAXC=3;

    public static void main(String[] args) {
        int[][] mat = {{6, 5, 7}, {7, 10, 6}};
        int totalElementos= 6;
        System.out.println(". ");
        imprimir_matriz(mat);
        ordenarMatriz(mat, totalElementos);
        System.out.println("Ordenada: ");
        imprimir_matriz(mat);
    }
    public static void ordenarMatriz(int[][]mat, int totalElementos){
        for (int i = 0; i < totalElementos-1; i++) {
            for (int j = 0; j < totalElementos-1-i; j++) {
                int fila1 = j / MAXC;
                int col1 = j % MAXC;
                int fila2 = (j + 1) / MAXC;
                int col2 = (j + 1) % MAXC;
    
                if (mat[fila1][col1] > mat[fila2][col2]) {
                    int temp = mat[fila1][col1];
                    mat[fila1][col1] = mat[fila2][col2];
                    mat[fila2][col2] = temp;
                }
            }
        }
    }
    
    public static void imprimir_matriz(int[][] matint) {
        for (int fila = 0; fila < MAXF; fila++) {
            for (int col = 0; col < MAXC; col++) {

                System.out.print("|" + matint[fila][col]);
            }
            System.out.print("\n");
        }
    }
}
