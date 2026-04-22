import java.util.Random;
import java.util.Arrays;

public class Generador {
    private static final Random random = new Random();
    
    // Generar array aleatorio
    public static int[] generarArrayAleatorio(int tamaño, int min, int max) {
        int[] array = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }
    
    // Generar array casi ordenado
    public static int[] generarArrayCasiOrdenado(int tamaño) {
        int[] array = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            array[i] = i;
        }
        // Intercambiar algunos elementos para desordenar ligeramente
        for (int i = 0; i < tamaño / 10; i++) {
            int idx1 = random.nextInt(tamaño);
            int idx2 = random.nextInt(tamaño);
            int temp = array[idx1];
            array[idx1] = array[idx2];
            array[idx2] = temp;
        }
        return array;
    }
    
    // Generar array ordenado inversamente
    public static int[] generarArrayInverso(int tamaño) {
        int[] array = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            array[i] = tamaño - i;
        }
        return array;
    }
    
    // Generar array con muchos duplicados
    public static int[] generarArrayConDuplicados(int tamaño, int valoresDiferentes) {
        int[] array = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            array[i] = random.nextInt(valoresDiferentes);
        }
        return array;
    }
    
    // Copiar array (para pruebas)
    public static int[] copiarArray(int[] original) {
        return Arrays.copyOf(original, original.length);
    }
    
    // Verificar si array está ordenado
    public static void estaOrdenado(int[] array) {
        boolean res = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                res = false;
            }
        }
        
        if (res==true)
            System.out.println("Está ordenado.");
        else System.out.println("No se ordenó correctamente.");

        imprimirArray(array);
    }
    
    // imprimirArray array (útil para debugging)
    public static void imprimirArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void imprimirMatriz(int[][] array){
        for (int[] fila: array){
            System.out.println(Arrays.toString(fila));
        }
    }

    public static void imprimirTablero (String[][] tablero){
        for (String[] fila: tablero){
            System.out.println(Arrays.toString(fila));
        }
    }


}