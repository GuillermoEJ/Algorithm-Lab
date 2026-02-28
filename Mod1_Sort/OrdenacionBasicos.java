package Mod1_Sort;

/**
 * MÓDULO 1: ALGORITMOS DE ORDENACIÓN BÁSICA
 * 
 * Contiene 4 algoritmos clásicos de ordenación para aprender:
 * - Cómo funcionan los algoritmos sencillos
 * - Análisis de complejidad temporal
 * - Comparación de eficiencia
 * 
 * TODOS modifican el array IN-PLACE (no retornan nada)
 * TODOS tienen complejidad O(n²) en el peor caso
 * 
 * @author Laboratorio de Algoritmos
 * @version 1.0
 */
public class OrdenacionBasicos {
    
    // ═════════════════════════════════════════════════════════════════════
    //  SELECTION SORT
    // ═════════════════════════════════════════════════════════════════════
    
    /**
     * SELECTION SORT - Ordenación por Selección
     * 
     * Estrategia:
     *   1. Busca el elemento más pequeño en la parte sin ordenar
     *   2. Lo intercambia con el primero sin ordenar
     *   3. Repite hasta que todo esté ordenado
     * 
     * Complejidad:
     *   - Mejor caso: O(n²)
     *   - Caso promedio: O(n²)
     *   - Peor caso: O(n²)
     *   - Espacio: O(1)
     * 
     * Ventajas:
     *   ✓ Simple de entender
     *   ✓ Muy pocos movimientos (n-1)
     * 
     * Desventajas:
     *   ✗ Siempre O(n²), incluso si está casi ordenado
     * 
     * @param array Array a ordenar (se modifica in-place)
     */
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int k = i;  // Índice del mínimo
            
            // Buscar el mínimo en la parte sin ordenar
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[k]) {
                    k = j;
                }
            }
            
            // Intercambiar mínimo con posición i
            int aux = array[i];
            array[i] = array[k];
            array[k] = aux;
        }
    }

    // ═════════════════════════════════════════════════════════════════════
    //  INSERTION SORT
    // ═════════════════════════════════════════════════════════════════════
    
    /**
     * INSERTION SORT - Ordenación por Inserción
     * 
     * Estrategia:
     *   1. Comienza con el 2º elemento
     *   2. Inserta cada elemento en su posición correcta
     *   3. Desplaza elementos mayores hacia la derecha
     * 
     * Complejidad:
     *   - Mejor caso: O(n)        ← Si ya está ordenado!
     *   - Caso promedio: O(n²)
     *   - Peor caso: O(n²)
     *   - Espacio: O(1)
     * 
     * Ventajas:
     *   ✓ O(n) si está casi ordenado
     *   ✓ Estable (mantiene orden relativo)
     *   ✓ Bueno para arrays pequeños
     * 
     * Desventajas:
     *   ✗ O(n²) en peor caso
     * 
     * @param array Array a ordenar (se modifica in-place)
     */
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int aux = array[i];  // Elemento a insertar
            int k = i;           // Posición de inserción
            
            // Desplazar elementos mayores a la derecha
            while (k > 0 && array[k - 1] > aux) {
                array[k] = array[k - 1];
                k--;
            }
            
            // Insertar en posición correcta
            array[k] = aux;
        }
    }

    // ═════════════════════════════════════════════════════════════════════
    //  BUBBLE SORT
    // ═════════════════════════════════════════════════════════════════════
    
    /**
     * BUBBLE SORT - Ordenación por Burbuja
     * 
     * Estrategia:
     *   1. Compara pares adyacentes de izquierda a derecha
     *   2. Si están desordenados, los intercambia
     *   3. Repite hasta que no haya más intercambios
     * 
     * Complejidad:
     *   - Mejor caso: O(n²)
     *   - Caso promedio: O(n²)
     *   - Peor caso: O(n²)
     *   - Espacio: O(1)
     * 
     * Ventajas:
     *   ✓ Simple de entender
     *   ✓ Estable
     * 
     * Desventajas:
     *   ✗ Muy ineficiente, muchos intercambios
     * 
     * @param array Array a ordenar (se modifica in-place)
     */
    public static void bubleSort(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    // Intercambiar
                    int aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
    }

    // ═════════════════════════════════════════════════════════════════════
    //  BUBBLE SORT OPTIMIZADO
    // ═════════════════════════════════════════════════════════════════════
    
    /**
     * BUBBLE SORT OPTIMIZADO - Con Bandera de Mejora
     * 
     * Estrategia:
     *   - Como Bubble Sort, pero
     *   - Detiene si no hay cambios en una pasada (está ordenado!)
     * 
     * Complejidad:
     *   - Mejor caso: O(n)        ← Si ya está ordenado!
     *   - Caso promedio: O(n²)
     *   - Peor caso: O(n²)
     *   - Espacio: O(1)
     * 
     * Ventajas:
     *   ✓ O(n) si ya está ordenado
     *   ✓ Mejora sobre Bubble Sort estándar
     * 
     * Desventajas:
     *   ✗ Sigue siendo O(n²) en peor caso
     * 
     * @param array Array a ordenar (se modifica in-place)
     */
    public static void bubleSortOptimizado(int[] array) {
        boolean ordenado = false;
        int i = array.length - 1;

        while (!ordenado) {
            ordenado = true;
            for (int j=0; j<i; j++){
                if (array[j]>array[j+1]){
                    int aux = array[j];
                    array[j] = array[j+1];
                    array[j+1] = aux;
                    ordenado = false;
                }
            }
            i--;
        }
    }
}
