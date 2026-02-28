import java.util.Stack;
import Mod1_Sort.OrdenacionBasicos;
import Mod2_DyV.DyV;
import Mod3_BackTracking.Backtracking;
import Mod3_BackTracking.Booleano;
import Mod3_BackTracking.Entero;

/**
 * LABORATORIO DE ALGORITMOS - Punto de entrada
 * 
 * Este archivo contiene ejemplos practicos para estudiar los tres modulos:
 * 1. Modulo 1: Algoritmos de Ordenacion Basica
 * 2. Modulo 2: Divide y Venceras
 * 3. Modulo 3: Backtracking
 * 
 * Lee primero README.md y ESTRUCTURA.md
 * Descomenta el metodo que quieras ejecutar en main()
 * Ejecuta y observa los resultados
 * Modifica los ejemplos para aprender mas
 * 
 * @author Laboratorio de Algoritmos
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   LABORATORIO DE ALGORITMOS            ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println();
        
        // TODO: Descomenta el metodo que quieras probar:
        
        // ============ MODULO 1: ORDENACION ============
        //ejerciciosOrdenacion();
        
        // ============ MODULO 2: DIVIDE Y VENCERAS ============
        //ejerciciosDivideYVenceras();
        
        // ============ MODULO 3: BACKTRACKING ============
        // sumaEnterosBack();
        // viajeCaballero();
        // nReinas();
        // mochilaOptima();
        // monedasOptimo();
        // caminoCosteExacto();
        //colorearGrafo();
        // ejerciciosBacktracking();
    }

    // ====================================================================
    //  MODULO 1: ALGORITMOS DE ORDENACION BASICA
    // ====================================================================
    
    /**
     * Prueba todos los algoritmos de ordenacion basica
     */
    public static void ejerciciosOrdenacion() {
        System.out.println("\nMODULO 1: ORDENACION BASICA");
        System.out.println("════════════════════════════════════════════════");
        
        int[] array = {9, 1, 8, 2, 7, 3, 6, 4, 5};
        
        System.out.println("\nArray original:");
        Generador.imprimirArray(array);
        
        // --- Selection Sort ---
        System.out.println("\nSELECTION SORT - O(n²)");
        System.out.println("Estrategia: Busca el minimo y lo intercambia");
        int[] arr1 = Generador.copiarArray(array);
        OrdenacionBasicos.selectionSort(arr1);
        Generador.estaOrdenado(arr1);
        
        // --- Insertion Sort ---
        System.out.println("\nINSERTION SORT - O(n²)");
        System.out.println("Estrategia: Inserta cada elemento en su posicion");
        int[] arr2 = Generador.copiarArray(array);
        OrdenacionBasicos.insertionSort(arr2);
        Generador.estaOrdenado(arr2);
        
        // --- Bubble Sort ---
        System.out.println("\nBUBBLE SORT - O(n²)");
        System.out.println("Estrategia: Compara pares adyacentes");
        int[] arr3 = Generador.copiarArray(array);
        OrdenacionBasicos.bubleSort(arr3);
        Generador.estaOrdenado(arr3);
        
        // --- Bubble Sort Optimizado ---
        System.out.println("\nBUBBLE SORT OPTIMIZADO - O(n²)");
        System.out.println("Estrategia: Bubble con bandera de mejora");
        int[] arr4 = Generador.copiarArray(array);
        OrdenacionBasicos.bubleSortOptimizado(arr4);
        Generador.estaOrdenado(arr4);
    }

    // ====================================================================
    //  MODULO 2: DIVIDE Y VENCERAS
    // ====================================================================
    
    /**
     * Demuestra la estrategia de Divide y Venceras
     */
    public static void ejerciciosDivideYVenceras() {
        System.out.println("\nMODULO 2: DIVIDE Y VENCERAS");
        System.out.println("════════════════════════════════════════════════");
        
        // --- Busqueda Binaria ---
        System.out.println("\nBUSQUEDA BINARIA - O(log n)");
        System.out.println("Requiere: Array ORDENADO");
        int[] ordenado = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Array: " + java.util.Arrays.toString(ordenado));
        
        boolean existe = DyV.contiene(ordenado, 5);
        System.out.println("Contiene 5? " + (existe ? "SI" : "NO"));
        
        existe = DyV.contiene(ordenado, 10);
        System.out.println("Contiene 10? " + (existe ? "SI" : "NO"));
        
        // --- Quick Sort ---
        System.out.println("\nQUICK SORT - O(n log n) promedio");
        System.out.println("Estrategia: Particiona por pivote, ordena recursivamente");
        int[] array = {9, 1, 8, 2, 7, 3, 6, 4, 5};
        System.out.println("Original: " + java.util.Arrays.toString(array));
        DyV.quickSort(array);
        Generador.estaOrdenado(array);
        
        // --- Maximo Subarray ---
        System.out.println("\nMAXIMO SUBARRAY - O(n log n)");
        System.out.println("Problema: Encontrar subarray con suma maxima");
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Array: " + java.util.Arrays.toString(arr));
        int maxSum = DyV.maxSubarray(arr);
        System.out.println("Suma maxima: " + maxSum);
    }

    // ====================================================================
    //  MODULO 3: BACKTRACKING
    // ====================================================================
    
    /**
     * Problema: Encontrar un subconjunto que sume exactamente 'num'
     */
    public static void sumaEnterosBack() {
        System.out.println("\nMODULO 3: BACKTRACKING");
        System.out.println("════════════════════════════════════════════════");
        System.out.println("\nSUMA DE SUBCONJUNTOS");
        System.out.println("Problema: Existe un subconjunto que suma exactamente N?");
        
        int[] vector = {13, 11, 7};
        int[] solucion = new int[vector.length];
        int num = 20;
        int suma = 0;
        
        System.out.println("Vector: " + java.util.Arrays.toString(vector));
        System.out.println("Buscamos suma: " + num);
        
        Booleano exito = new Booleano(false);
        Backtracking.subconjuntoSuma3(vector, num, solucion, num, suma, exito);
        
        if (exito.getValor()) {
            System.out.println("SOLUCION ENCONTRADA: ");
            System.out.print("Subconjunto: ");
            for (int i = 0; i < vector.length; i++) {
                if (solucion[i] == 1) {
                    System.out.print(vector[i] + " ");
                }
            }
            System.out.println();
        } else {
            System.out.println("NO EXISTE SOLUCION");
        }
    }

    /**
     * Problema del Viaje del Caballero
     */
    public static void viajeCaballero() {
        System.out.println("\nVIAJE DEL CABALLERO");
        System.out.println("Problema: Recorrida completa del caballero en tablero?");
        System.out.println("(Puede tardar unos segundos...)");
        
        int[][] tablero = new int[6][6];
        tablero[0][0] = 1;
        
        Booleano exito = new Booleano(false);
        Backtracking.viajeCaballero(tablero, 2, 0, 0, exito);
        
        if (exito.getValor()) {
            System.out.println("SOLUCION ENCONTRADA!");
            Generador.imprimirMatriz(tablero);
        } else {
            System.out.println("NO EXISTE SOLUCION desde (0,0)");
        }
    }

    /**
     * Problema de las N-Reinas
     */
    public static void nReinas() {
        System.out.println("\nPROBLEMA DE LAS N-REINAS");
        System.out.println("Problema: Colocar 4 reinas sin que se amenacen");
        
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
            System.out.println("SOLUCION ENCONTRADA:");
            for (int i = 0; i < N; i++) {
                tablero[i][damas[i]] = " D ";
            }
            Generador.imprimirTablero(tablero);
        } else {
            System.out.println("NO EXISTE SOLUCION");
        }
    }

    /**
     * Problema de la Mochila 0/1
     */
    public static void mochilaOptima() {
        System.out.println("\nPROBLEMA DE LA MOCHILA 0/1");
        System.out.println("Problema: Llevar maximo valor con peso limitado");
        
        int[] pesos = {3, 7, 2};
        int[] valores = {37, 21, 35};
        int maxPeso = 10;
        
        System.out.println("Pesos:  " + java.util.Arrays.toString(pesos));
        System.out.println("Valores: " + java.util.Arrays.toString(valores));
        System.out.println("Peso maximo: " + maxPeso);
        
        int[] sol = new int[pesos.length];
        int valorActual = 0;
        int pesoActual = 0;
        
        Entero valorMejor = new Entero(0);
        int[] mejorSol = new int[pesos.length];
        
        Backtracking.mochilaOptima(pesos, valores, maxPeso, 0, sol, valorActual, 
            pesoActual, mejorSol, valorMejor);
        
        System.out.println("SOLUCION OPTIMA:");
        System.out.println("Incluir: " + java.util.Arrays.toString(mejorSol));
        System.out.println("Valor total: " + valorMejor.getValor());
    }

    /**
     * Problema del Cambio Optimo
     */
    public static void monedasOptimo() {
        System.out.println("\nPROBLEMA DEL CAMBIO OPTIMO");
        System.out.println("Problema: Cantidad minima de monedas para valor X");
        
        int[] valores = {5, 10, 1};
        int cantidad = 12;
        
        System.out.println("Monedas disponibles: " + java.util.Arrays.toString(valores));
        System.out.println("Cantidad a dar: " + cantidad);
        
        int numMonedasActual = 0;
        int resto = cantidad;
        int[] sol = new int[valores.length];
        int[] mejorSol = new int[valores.length];
        Entero numMonedasMejor = new Entero(Integer.MAX_VALUE);
        
        Backtracking.monedasOptimo(valores, 0, sol, numMonedasActual, resto, 
            mejorSol, numMonedasMejor);
        
        System.out.println("SOLUCION OPTIMA:");
        System.out.println("Cantidad monedas: " + numMonedasMejor.getValor());
        System.out.println("Combinacion: " + java.util.Arrays.toString(mejorSol));
    }

    /**
     * Problema: Camino con Coste Exacto
     */
    public static void caminoCosteExacto() {
        System.out.println("\nCAMINO CON COSTE EXACTO");
        System.out.println("Problema: Existe camino de nodo 0 a 4 con coste 13?");
        
        int[][] grafo = {
            {0, 1, 0, 0, 0},
            {1, 0, 1, 7, 0},
            {0, 1, 0, 2, 0},
            {0, 7, 2, 0, 5},
            {0, 0, 0, 5, 0}
        };
        
        // Completar matriz (INF donde no hay arista)
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
            System.out.println("CAMINO ENCONTRADO con coste " + costeObjetivo + ": ");
            System.out.print("Nodos: ");
            Generador.imprimirArray(camino.stream().mapToInt(i -> i).toArray());
        } else {
            System.out.println("NO EXISTE camino con coste exacto " + costeObjetivo);
        }
    }

    /**
     * Problema de Coloreo de Grafos
     */
    public static void colorearGrafo() {
        System.out.println("\nCOLOREO DE GRAFOS");
        System.out.println("Problema: Colorear vertices con minimo de colores");
        
        int O = Integer.MAX_VALUE;
        int[][] grafo = {
            {O, 1, O, 1},
            {1, O, 1, O},
            {O, 1, O, 1},
            {1, O, 1, O}
        };
        
        int[] colores = Backtracking.colorearGrafo(grafo);
        
        System.out.println("SOLUCION:");
        for (int i = 0; i < colores.length; i++) {
            System.out.println("  Vertice " + i + " -> Color " + colores[i]);
        }
    }

    /**
     * Otros problemas de Backtracking
     */
    public static void ejerciciosBacktracking() {
        System.out.println("\nOTROS PROBLEMAS CLASICOS");
        System.out.println("(Descomenta dentro de este metodo para probar)");
        
        int[] bienes = {5, 4, 1, 3, 6, 2};
        int[] subConjuntos = {4, 2, 5, 5, 1, 8};
        
        boolean resul = false;
        // resul = Backtracking.hayRepartoEquitativo(bienes);
        // resul = Backtracking.dosSubconjuntos(subConjuntos, 10);
        
        if (resul) System.out.println("EXITO");
        else System.out.println("NO EXISTE SOLUCION");
    }
}