package Mod1_Sort;

public class OrdenacionBasicos {
    
    // =====================================================================
    //  SELECTION SORT
    // =====================================================================
    
    /**
     * SELECTION SORT - Selection Sorting
     * 
     * Strategy:
     *   1. Find the smallest element in the unsorted part
     *   2. Swap it with the first unsorted element
     *   3. Repeat until everything is sorted
     * 
     * Complexity:
     *   - Best case: O(n²)
     *   - Average case: O(n²)
     *   - Worst case: O(n²)
     *   - Space: O(1)
     * 
     * Advantages:
     *   + Simple to understand
     *   + Very few movements (n-1)
     * 
     * Disadvantages:
     *   - Always O(n²), even if nearly sorted
     * 
     * @param array Array to sort (modified in-place)
     */
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int k = i;  // Index of minimum
            
            // Find minimum in unsorted part
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[k]) {
                    k = j;
                }
            }
            
            // Swap minimum with position i
            int aux = array[i];
            array[i] = array[k];
            array[k] = aux;
        }
    }

    // =====================================================================
    //  INSERTION SORT
    // =====================================================================
    
    /**
     * INSERTION SORT - Insertion Sorting
     * 
     * Strategy:
     *   1. Start with the 2nd element
     *   2. Insert each element in its correct position
     *   3. Shift larger elements to the right
     * 
     * Complexity:
     *   - Best case: O(n)        <- If already sorted!
     *   - Average case: O(n²)
     *   - Worst case: O(n²)
     *   - Space: O(1)
     * 
     * Advantages:
     *   + O(n) if nearly sorted
     *   + Stable (maintains relative order)
     *   + Good for small arrays
     * 
     * Disadvantages:
     *   - O(n²) in worst case
     * 
     * @param array Array to sort (modified in-place)
     */
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int aux = array[i];  // Element to insert
            int k = i;           // Insertion position
            
            // Shift larger elements to the right
            while (k > 0 && array[k - 1] > aux) {
                array[k] = array[k - 1];
                k--;
            }
            
            // Insert in correct position
            array[k] = aux;
        }
    }

    // =====================================================================
    //  BUBBLE SORT
    // =====================================================================
    
    /**
     * BUBBLE SORT - Bubble Sorting
     * 
     * Strategy:
     *   1. Compare adjacent pairs left to right
     *   2. If out of order, swap them
     *   3. Repeat until no more swaps
     * 
     * Complexity:
     *   - Best case: O(n²)
     *   - Average case: O(n²)
     *   - Worst case: O(n²)
     *   - Space: O(1)
     * 
     * Advantages:
     *   + Simple to understand
     *   + Stable
     * 
     * Disadvantages:
     *   - Very inefficient, many swaps
     * 
     * @param array Array to sort (modified in-place)
     */
    public static void bubleSort(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap
                    int aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
    }

    // =====================================================================
    //  OPTIMIZED BUBBLE SORT
    // =====================================================================
    
    /**
     * OPTIMIZED BUBBLE SORT - With Improvement Flag
     * 
     * Strategy:
     *   - Like Bubble Sort, but
     *   - Stops if no changes in a pass (it's sorted!)
     * 
     * Complexity:
     *   - Best case: O(n)        <- If already sorted!
     *   - Average case: O(n²)
     *   - Worst case: O(n²)
     *   - Space: O(1)
     * 
     * Advantages:
     *   + O(n) if already sorted
     *   + Improvement over standard Bubble Sort
     * 
     * Disadvantages:
     *   - Still O(n²) in worst case
     * 
     * @param array Array to sort (modified in-place)
     */
    public static void bubleSortOptimizado(int[] array) {
        boolean sorted = false;
        int i = array.length - 1;

        while (!sorted) {
            sorted = true;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                    sorted = false;
                }
            }
            i--;
        }
    }
}
