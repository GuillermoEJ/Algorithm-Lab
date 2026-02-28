import java.util.Random;
import java.util.Arrays;

/**
 * UTILITY CLASS - Generator.java
 * 
 * Provides auxiliary tools for:
 *   - Generate test arrays (random, sorted, etc.)
 *   - Verify if an array is correctly sorted
 *   - Print results in readable format
 *   - Copy arrays for independent tests
 */
public class Generador {
    private static final Random random = new Random();
    
    // =====================================================================
    //  GENERATING TEST ARRAYS
    // =====================================================================
    
    /**
     * Generates an array with random values
     * Useful to test with general cases
     * 
     * @param size Number of elements
     * @param min Minimum value (inclusive)
     * @param max Maximum value (inclusive)
     * @return Array with random values in range [min, max]
     */
    public static int[] generateRandomArray(int size, int min, int max) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }
    
    /**
     * Generates a nearly sorted array
     * Useful to test algorithms in best case
     * 
     * @param size Number of elements
     * @return Array [0, 1, 2, ..., n] with ~10% unsorted
     */
    public static int[] generateNearlySorted(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        // Shuffle slightly (~10%)
        for (int i = 0; i < size / 10; i++) {
            int idx1 = random.nextInt(size);
            int idx2 = random.nextInt(size);
            int temp = array[idx1];
            array[idx1] = array[idx2];
            array[idx2] = temp;
        }
        return array;
    }
    
    /**
     * Generates an array sorted in reverse order
     * Useful to test worst case of some algorithms
     * 
     * @param size Number of elements
     * @return Array [n-1, n-2, ..., 1, 0]
     */
    public static int[] generateReverse(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }
        return array;
    }
    
    /**
     * Generates array with many repeated values
     * Useful to test algorithms with duplicate data
     * 
     * @param size Number of elements
     * @param differentValues How many unique values to use
     * @return Array with elements from 0 to differentValues-1 (random)
     */
    public static int[] generateWithDuplicates(int size, int differentValues) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(differentValues);
        }
        return array;
    }
    
    // =====================================================================
    //  ARRAY OPERATIONS
    // =====================================================================
    
    /**
     * Copies an array
     * Essential for running multiple algorithms on the same data
     * 
     * @param original Array to copy
     * @return Independent copy of the array
     */
    public static int[] copyArray(int[] original) {
        return Arrays.copyOf(original, original.length);
    }
    
    // =====================================================================
    //  RESULT VERIFICATION
    // =====================================================================
    
    /**
     * Verifies if an array is correctly sorted
     * Prints the result and the final array
     * 
     * @param array Array to verify
     */
    public static void isSorted(int[] array) {
        boolean res = true;
        
        // Check that each element is <= next element
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                res = false;
                break;
            }
        }
        
        // Show result
        if (res)
            System.out.println("  Array sorted correctly");
        else
            System.out.println("  Array is NOT sorted");
        
        printArray(array);
    }
    
    // =====================================================================
    //  PRINTING RESULTS
    // =====================================================================
    
    /**
     * Prints an array in format [1, 2, 3, ...]
     * Useful to verify results in console
     * 
     * @param array Array to print
     */
    public static void printArray(int[] array) {
        System.out.println("  " + Arrays.toString(array));
    }
    
    /**
     * Prints a 2D matrix
     * Useful for boards, graphs, distance matrices
     * 
     * @param array 2D matrix to print
     */
    public static void printMatrix(int[][] array) {
        for (int[] fila : array) {
            System.out.println("  " + Arrays.toString(fila));
        }
    }

    /**
     * Prints a board (e.g., N-Queens, chess)
     * Handles String arrays with symbols
     * 
     * @param board 2D board with symbols
     */
    public static void printBoard(String[][] board) {
        for (String[] row : board) {
            System.out.println("  " + Arrays.toString(row));
        }
    }
    
    // Keep old method names for backward compatibility with existing code
    public static int[] generarArrayAleatorio(int size, int min, int max) {
        return generateRandomArray(size, min, max);
    }
    
    public static int[] generarArrayCasiOrdenado(int size) {
        return generateNearlySorted(size);
    }
    
    public static int[] generarArrayInverso(int size) {
        return generateReverse(size);
    }
    
    public static int[] generarArrayConDuplicados(int size, int differentValues) {
        return generateWithDuplicates(size, differentValues);
    }
    
    public static int[] copiarArray(int[] original) {
        return copyArray(original);
    }
    
    public static void estaOrdenado(int[] array) {
        isSorted(array);
    }
    
    public static void imprimirArray(int[] array) {
        printArray(array);
    }
    
    public static void imprimirMatriz(int[][] array) {
        printMatrix(array);
    }
    
    public static void imprimirTablero(String[][] board) {
        printBoard(board);
    }
}
