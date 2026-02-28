import java.util.Stack;
import Mod1_Sort.OrdenacionBasicos;
import Mod2_DyV.DyV;
import Mod3_BackTracking.Backtracking;
import Mod3_BackTracking.Booleano;
import Mod3_BackTracking.Entero;

public class Main {

    public static void main(String[] args) {
        System.out.println("════════════════════════════════════════");
        System.out.println("   ALGORITHMS LABORATORY");
        System.out.println("════════════════════════════════════════");
        System.out.println();
        
        // TODO: Uncomment the method you want to test:
        
        // ============ MODULE 1: SORTING ============
        //sortingExercises();
        
        // ============ MODULE 2: DIVIDE AND CONQUER ============
        //divideAndConquerExercises();
        
        // ============ MODULE 3: BACKTRACKING ============
        // subsetSumBack();
        // knightsTour();
        // nQueens();
        // optimalKnapsack();
        // optimalCoins();
        // exactCostPath();
        //colorGraph();
        // backtrackingExercises();
    }

    // ====================================================================
    //  MODULE 1: BASIC SORTING ALGORITHMS
    // ====================================================================
    
    /**
     * Test all basic sorting algorithms
     */
    public static void sortingExercises() {
        System.out.println("\nMODULE 1: BASIC SORTING");
        System.out.println("════════════════════════════════════════════════");
        
        int[] array = {9, 1, 8, 2, 7, 3, 6, 4, 5};
        
        System.out.println("\nOriginal array:");
        Generador.imprimirArray(array);
        
        // --- Selection Sort ---
        System.out.println("\nSELECTION SORT - O(n²)");
        System.out.println("Strategy: Find minimum and swap it");
        int[] arr1 = Generador.copiarArray(array);
        OrdenacionBasicos.selectionSort(arr1);
        Generador.estaOrdenado(arr1);
        
        // --- Insertion Sort ---
        System.out.println("\nINSERTION SORT - O(n²)");
        System.out.println("Strategy: Insert each element in its position");
        int[] arr2 = Generador.copiarArray(array);
        OrdenacionBasicos.insertionSort(arr2);
        Generador.estaOrdenado(arr2);
        
        // --- Bubble Sort ---
        System.out.println("\nBUBBLE SORT - O(n²)");
        System.out.println("Strategy: Compare adjacent pairs");
        int[] arr3 = Generador.copiarArray(array);
        OrdenacionBasicos.bubleSort(arr3);
        Generador.estaOrdenado(arr3);
        
        // --- Optimized Bubble Sort ---
        System.out.println("\nOPTIMIZED BUBBLE SORT - O(n²)");
        System.out.println("Strategy: Bubble with improvement flag");
        int[] arr4 = Generador.copiarArray(array);
        OrdenacionBasicos.bubleSortOptimizado(arr4);
        Generador.estaOrdenado(arr4);
    }

    // ====================================================================
    //  MODULE 2: DIVIDE AND CONQUER
    // ====================================================================
    
    /**
     * Demonstrates the Divide and Conquer strategy
     */
    public static void divideAndConquerExercises() {
        System.out.println("\nMODULE 2: DIVIDE AND CONQUER");
        System.out.println("════════════════════════════════════════════════");
        
        // --- Binary Search ---
        System.out.println("\nBINARY SEARCH - O(log n)");
        System.out.println("Requires: Sorted array");
        int[] ordenado = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Array: " + java.util.Arrays.toString(ordenado));
        
        boolean existe = DyV.contiene(ordenado, 5);
        System.out.println("Contains 5? " + (existe ? "YES" : "NO"));
        
        existe = DyV.contiene(ordenado, 10);
        System.out.println("Contains 10? " + (existe ? "YES" : "NO"));
        
        // --- Quick Sort ---
        System.out.println("\nQUICK SORT - O(n log n) average");
        System.out.println("Strategy: Partition by pivot, sort recursively");
        int[] array = {9, 1, 8, 2, 7, 3, 6, 4, 5};
        System.out.println("Original: " + java.util.Arrays.toString(array));
        DyV.quickSort(array);
        Generador.estaOrdenado(array);
        
        // --- Maximum Subarray ---
        System.out.println("\nMAXIMUM SUBARRAY - O(n log n)");
        System.out.println("Problem: Find subarray with maximum sum");
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Array: " + java.util.Arrays.toString(arr));
        int maxSum = DyV.maxSubarray(arr);
        System.out.println("Maximum sum: " + maxSum);
    }

    // ====================================================================
    //  MODULE 3: BACKTRACKING
    // ====================================================================
    
    /**
     * Problem: Find a subset that sums exactly to 'num'
     */
    public static void subsetSumBack() {
        System.out.println("\nMODULE 3: BACKTRACKING");
        System.out.println("════════════════════════════════════════════════");
        System.out.println("\nSUBSET SUM");
        System.out.println("Problem: Does a subset exist that sums exactly N?");
        
        int[] vector = {13, 11, 7};
        int[] solucion = new int[vector.length];
        int num = 20;
        int suma = 0;
        
        System.out.println("Vector: " + java.util.Arrays.toString(vector));
        System.out.println("Looking for sum: " + num);
        
        Booleano exito = new Booleano(false);
        Backtracking.subconjuntoSuma3(vector, num, solucion, num, suma, exito);
        
        if (exito.getValor()) {
            System.out.println("SOLUTION FOUND: ");
            System.out.print("Subset: ");
            for (int i = 0; i < vector.length; i++) {
                if (solucion[i] == 1) {
                    System.out.print(vector[i] + " ");
                }
            }
            System.out.println();
        } else {
            System.out.println("NO SOLUTION EXISTS");
        }
    }

    /**
     * Knight's Tour Problem
     */
    public static void knightsTour() {
        System.out.println("\nKNIGHT'S TOUR");
        System.out.println("Problem: Complete knight tour on board?");
        System.out.println("(Warning: This may take a few seconds...)");
        
        int[][] tablero = new int[6][6];
        tablero[0][0] = 1;
        
        Booleano exito = new Booleano(false);
        Backtracking.viajeCaballero(tablero, 2, 0, 0, exito);
        
        if (exito.getValor()) {
            System.out.println("SOLUTION FOUND!");
            Generador.imprimirMatriz(tablero);
        } else {
            System.out.println("NO SOLUTION exists from (0,0)");
        }
    }

    /**
     * N-Queens Problem
     */
    public static void nQueens() {
        System.out.println("\nN-QUEENS PROBLEM");
        System.out.println("Problem: Place 4 queens without threatening each other");
        
        int N = 4;
        String[][] tablero = new String[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tablero[i][j] = " . ";
            }
        }
        
        int[] damas = new int[N];
        Booleano exito = new Booleano(false);
        Backtracking.reinas(damas, 0, exito);
        
        if (exito.getValor()) {
            System.out.println("SOLUTION FOUND:");
            for (int i = 0; i < N; i++) {
                tablero[i][damas[i]] = " Q ";
            }
            Generador.imprimirTablero(tablero);
        } else {
            System.out.println("NO SOLUTION EXISTS");
        }
    }

    /**
     * 0/1 Knapsack Problem
     */
    public static void optimalKnapsack() {
        System.out.println("\n0/1 KNAPSACK PROBLEM");
        System.out.println("Problem: Carry maximum value with weight limit");
        
        int[] pesos = {3, 7, 2};
        int[] valores = {37, 21, 35};
        int maxPeso = 10;
        
        System.out.println("Weights:  " + java.util.Arrays.toString(pesos));
        System.out.println("Values: " + java.util.Arrays.toString(valores));
        System.out.println("Max weight: " + maxPeso);
        
        int[] sol = new int[pesos.length];
        int valorActual = 0;
        int pesoActual = 0;
        
        Entero valorMejor = new Entero(0);
        int[] mejorSol = new int[pesos.length];
        
        Backtracking.mochilaOptima(pesos, valores, maxPeso, 0, sol, valorActual, 
            pesoActual, mejorSol, valorMejor);
        
        System.out.println("OPTIMAL SOLUTION:");
        System.out.println("Include: " + java.util.Arrays.toString(mejorSol));
        System.out.println("Total value: " + valorMejor.getValor());
    }

    /**
     * Optimal Change Problem
     */
    public static void optimalCoins() {
        System.out.println("\nOPTIMAL CHANGE PROBLEM");
        System.out.println("Problem: Minimum number of coins for value X");
        
        int[] valores = {5, 10, 1};
        int cantidad = 12;
        
        System.out.println("Available coins: " + java.util.Arrays.toString(valores));
        System.out.println("Amount to make: " + cantidad);
        
        int numMonedasActual = 0;
        int resto = cantidad;
        int[] sol = new int[valores.length];
        int[] mejorSol = new int[valores.length];
        Entero numMonedasMejor = new Entero(Integer.MAX_VALUE);
        
        Backtracking.monedasOptimo(valores, 0, sol, numMonedasActual, resto, 
            mejorSol, numMonedasMejor);
        
        System.out.println("OPTIMAL SOLUTION:");
        System.out.println("Number of coins: " + numMonedasMejor.getValor());
        System.out.println("Combination: " + java.util.Arrays.toString(mejorSol));
    }

    /**
     * Problem: Exact Cost Path
     */
    public static void exactCostPath() {
        System.out.println("\nEXACT COST PATH");
        System.out.println("Problem: Does a path exist from node 0 to 4 with cost 13?");
        
        int[][] grafo = {
            {0, 1, 0, 0, 0},
            {1, 0, 1, 7, 0},
            {0, 1, 0, 2, 0},
            {0, 7, 2, 0, 5},
            {0, 0, 0, 5, 0}
        };
        
        // Complete matrix (INF where no edge)
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo.length; j++) {
                if (i != j && grafo[i][j] == 0)
                    grafo[i][j] = Integer.MAX_VALUE;
            }
        }
        
        Stack<Integer> camino = new Stack<Integer>();
        int costeObjetivo = 13;
        
        boolean resul = Backtracking.caminoCosteExacto(grafo, 0, 4, costeObjetivo, camino);
        
        if (resul) {
            System.out.println("PATH FOUND with cost " + costeObjetivo + ": ");
            System.out.print("Nodes: ");
            Generador.imprimirArray(camino.stream().mapToInt(i -> i).toArray());
        } else {
            System.out.println("NO PATH exists with exact cost " + costeObjetivo);
        }
    }

    /**
     * Graph Coloring Problem
     */
    public static void colorGraph() {
        System.out.println("\nGRAPH COLORING");
        System.out.println("Problem: Color vertices with minimum colors");
        
        int O = Integer.MAX_VALUE;
        int[][] grafo = {
            {O, 1, O, 1},
            {1, O, 1, O},
            {O, 1, O, 1},
            {1, O, 1, O}
        };
        
        int[] colores = Backtracking.colorearGrafo(grafo);
        
        System.out.println("SOLUTION:");
        for (int i = 0; i < colores.length; i++) {
            System.out.println("  Vertex " + i + " -> Color " + colores[i]);
        }
    }

    /**
     * Other Backtracking problems
     */
    public static void backtrackingExercises() {
        System.out.println("\nOTHER CLASSIC PROBLEMS");
        System.out.println("(Uncomment within this method to test)");
        
        int[] bienes = {5, 4, 1, 3, 6, 2};
        int[] subConjuntos = {4, 2, 5, 5, 1, 8};
        
        boolean resul = false;
        // resul = Backtracking.hayRepartoEquitativo(bienes);
        // resul = Backtracking.dosSubconjuntos(subConjuntos, 10);
        
        if (resul) System.out.println("SUCCESS");
        else System.out.println("NO SOLUTION EXISTS");
    }
}
