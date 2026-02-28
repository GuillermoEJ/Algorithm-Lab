import java.util.Random;
import java.util.Arrays;

/**
 * CLASE UTILIDADES - Generador.java
 * 
 * Proporciona herramientas auxiliares para:
 *   ✓ Generar arrays de prueba (aleatorios, ordenados, etc.)
 *   ✓ Verificar si un array está correctamente ordenado
 *   ✓ Imprimir resultados de forma legible
 *   ✓ Copiar arrays para pruebas independientes
 * 
 * Usamos esta clase para no tener que escribir el mismo código dos veces
 * 
 * @author Laboratorio de Algoritmos
 * @version 1.0
 */
public class Generador {
    private static final Random random = new Random();
    
    // ═════════════════════════════════════════════════════════════════════
    //  GENERACIÓN DE ARRAYS DE PRUEBA
    // ═════════════════════════════════════════════════════════════════════
    
    /**
     * Genera un array con valores aleatorios
     * Útil para probar con casos generales
     * 
     * @param tamaño Número de elementos
     * @param min Valor mínimo (inclusive)
     * @param max Valor máximo (inclusive)
     * @return Array con valores aleatorios en rango [min, max]
     */
    public static int[] generarArrayAleatorio(int tamaño, int min, int max) {
        int[] array = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }
    
    /**
     * Genera un array casi ordenado
     * Útil para probar algoritmos en mejor caso
     * 
     * @param tamaño Número de elementos
     * @return Array [0, 1, 2, ..., n] con ~10% desordenado
     */
    public static int[] generarArrayCasiOrdenado(int tamaño) {
        int[] array = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            array[i] = i;
        }
        // Desordenar ligeramente (~10%)
        for (int i = 0; i < tamaño / 10; i++) {
            int idx1 = random.nextInt(tamaño);
            int idx2 = random.nextInt(tamaño);
            int temp = array[idx1];
            array[idx1] = array[idx2];
            array[idx2] = temp;
        }
        return array;
    }
    
    /**
     * Genera un array ordenado en orden inverso
     * Útil para probar peor caso de algunos algoritmos
     * 
     * @param tamaño Número de elementos
     * @return Array [n-1, n-2, ..., 1, 0]
     */
    public static int[] generarArrayInverso(int tamaño) {
        int[] array = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            array[i] = tamaño - i;
        }
        return array;
    }
    
    /**
     * Genera array con muchos valores repetidos
     * Útil para probar algoritmos con datos duplicados
     * 
     * @param tamaño Número de elementos
     * @param valoresDiferentes Cuántos valores únicos usar
     * @return Array con elementos del 0 al valoresDiferentes-1 (aleatorio)
     */
    public static int[] generarArrayConDuplicados(int tamaño, int valoresDiferentes) {
        int[] array = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            array[i] = random.nextInt(valoresDiferentes);
        }
        return array;
    }
    
    // ═════════════════════════════════════════════════════════════════════
    //  OPERACIONES CON ARRAYS
    // ═════════════════════════════════════════════════════════════════════
    
    /**
     * Copia un array
     * Essential para ejecutar múltiples algoritmos sobre los mismos datos
     * 
     * @param original Array a copiar
     * @return Copia independiente del array
     */
    public static int[] copiarArray(int[] original) {
        return Arrays.copyOf(original, original.length);
    }
    
    // ═════════════════════════════════════════════════════════════════════
    //  VERIFICACIÓN DE RESULTADOS
    // ═════════════════════════════════════════════════════════════════════
    
    /**
     * Verifica si un array está correctamente ordenado
     * Imprime el resultado y el array final
     * 
     * @param array Array a verificar
     */
    public static void estaOrdenado(int[] array) {
        boolean res = true;
        
        // Comprobar que cada elemento es <= al siguiente
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                res = false;
                break;
            }
        }
        
        // Mostrar resultado
        if (res)
            System.out.println("  ✓ Array ordenado correctamente");
        else
            System.out.println("  ✗ Array NO está ordenado");
        
        imprimirArray(array);
    }
    
    // ═════════════════════════════════════════════════════════════════════
    //  IMPRESIÓN DE RESULTADOS
    // ═════════════════════════════════════════════════════════════════════
    
    /**
     * Imprime un array en formato [1, 2, 3, ...]
     * Útil para verificar resultados en la consola
     * 
     * @param array Array a imprimir
     */
    public static void imprimirArray(int[] array) {
        System.out.println("  " + Arrays.toString(array));
    }
    
    /**
     * Imprime una matriz 2D
     * Útil para tableros, grafos, matrices de distancias
     * 
     * @param array Matriz 2D a imprimir
     */
    public static void imprimirMatriz(int[][] array) {
        for (int[] fila : array) {
            System.out.println("  " + Arrays.toString(fila));
        }
    }

    /**
     * Imprime un tablero (ej: N-Reinas, ajedrez)
     * Maneja arrays de String con símbolos
     * 
     * @param tablero Tablero 2D con símbolos
     */
    public static void imprimirTablero(String[][] tablero) {
        for (String[] fila : tablero) {
            System.out.println("  " + Arrays.toString(fila));
        }
    }
}