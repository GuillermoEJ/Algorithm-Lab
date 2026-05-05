package com.algoritmos.service;

import org.springframework.stereotype.Service;

@Service
public class OrdenacionService {
    
    /**
     * Selection Sort - Encuentra el mínimo y lo coloca al inicio
     * Complejidad: O(n²)
     */
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int k = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[k]) {
                    k = j;
                }
            }
            int aux = array[i];
            array[i] = array[k];
            array[k] = aux;
        }
    }

    /**
     * Insertion Sort - Construye el array ordenado de forma incremental
     * Complejidad: O(n²)
     */
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int aux = array[i];
            int k = i;
            while (k > 0 && array[k - 1] > aux) {
                array[k] = array[k - 1];
                k--;
            }
            array[k] = aux;
        }
    }

    /**
     * Bubble Sort - Los elementos "flotan" hacia su posición correcta
     * Complejidad: O(n²)
     */
    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
    }

    /**
     * Bubble Sort Optimizado - Detiene si ya está ordenado
     * Complejidad: O(n²), pero mejor en casos parciales
     */
    public static void bubbleSortOptimizado(int[] array) {
        boolean ordenado = false;
        int i = array.length - 1;
        
        while (!ordenado && i > 0) {
            ordenado = true;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                    ordenado = false;
                }
            }
            i--;
        }
    }

    /**
     * Quick Sort - Divide y Vencerás
     * Elige un pivote y particiona el array recursivamente
     * Complejidad Promedio: O(n log n)
     * Peor caso: O(n²)
     */
    public static void quickSort(int[] array) {
        quickSortAux(array, 0, array.length - 1);
    }

    private static void quickSortAux(int[] array, int i0, int iN) {
        if (i0 >= iN) {
            return;
        } else {
            int m = ordenarPivote(array, i0, iN);
            quickSortAux(array, i0, m - 1);
            quickSortAux(array, m + 1, iN);
        }
    }

    private static int ordenarPivote(int[] array, int i0, int iN) {
        int pivote = array[iN];
        int i = i0;
        int j = iN - 1;

        while (i < j) {
            while (array[i] <= pivote && i < j) {
                i++;
            }
            while (array[j] > pivote && i < j) {
                j--;
            }

            int aux = array[i];
            array[i] = array[j];
            array[j] = aux;
        }

        if (array[i] > pivote) {
            array[iN] = array[i];
            array[i] = pivote;
            return i;
        } else {
            return iN;
        }
    }
}
