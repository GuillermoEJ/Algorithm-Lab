import java.util.Stack;

import BackTracking.Backtracking;
import BackTracking.Booleano;
import BackTracking.Entero;
import DyV.DyV;
import Sort.OrdenacionBasicos;

public class Main {

    public static void main(String[] args) {
        System.out.println("===[ LABORATORIO DE ALGORITMOS ]===");
        
        ejerciciosBacktracking();
        
    }

    public static void ejerciciosOrdenacion (){

        int[] array = {9,1,8,2,7,3,6,4,5};

        OrdenacionBasicos.selectionSort(array);
        OrdenacionBasicos.insertionSort(array);
        OrdenacionBasicos.bubleSortOptimizado(array);

    }

    public static void ejerciciosDivideYVenceras(){
        
        // Generar arrays de prueba
        int[] ordenado = {1,2,3,4,5,6,7,8,9};
        int[] array = {9,1,8,2,7,3,6,4,5};
        /* 
        int[] negativo = {-11,-10,-9,-8,-7,-6};
        int[] polarizado = {-3, -2, -1, 1, 2, 3};
        int[] solitario = {1,1,4,5,5,7,7,8,8,9,9};
        int[] index = {2,4,4,4,6,6,7,7,8};
        int[] unos = {0,1,0,1,1,1,1,1,0,1};
        int[] rotado = {2,3,4,5,6,1};
        int[] solitario2 = {1,2,2,3,3,4,0,0,1};
        int[] colina = {5,6,7,8,9,3,2,1,0};
        int[] v1 = {1,1,1,1,2,3,4,5};
        int[] v2 = {1,1,1,1,5,4,3,2};
        int[] mayorLongOrdenado = {2,1,1,3,2,4,7,15,1};
        int[] parIpar = {2,5,8,9,22,34,45,98,101};
        int[] positivos = {-2,5,1,-3,-2,4,7,-1,9};
        int[] mayoritario = {1,1,0,0,1,1,0};
        int[] lastIndex = {2,4,4,4,6,6,7,7,8};
        */

        boolean x = DyV.contiene(ordenado, 9);
        if (x == true) System.out.println("Si");
        else System.out.println("No");

        DyV.quickSort(array);
        Generador.estaOrdenado(array);
       
        //int k = DyV.quickSelect(array,  1);
        //int k = DyV.maxSubarray(negativo);
        //int k = DyV.indiceIgual(array);
        //int k = DyV.numMultiplos(ordenado, 2);
        //int k = DyV.primerPositivoPolarizado(polarizado);
        //int k = DyV.positivoMenor(polarizado);
        //int k = DyV.elementoSolitario(solitario);
        //int k = DyV.primerIndex(index, 1);
        //int k = DyV.maxSubarrayUnos(unos);
        //int k = DyV.minArrayRotado(rotado);
        //int k = DyV.elementoEspecial(solitario);
        //int k = DyV.maxArrayColina(colina);
        //int k = DyV.posDiferente(v1, v2);
        //int k = DyV.longMaxSubarray(mayorLongOrdenado);
        //int k = DyV.parImpar(parIpar);
        //int k = DyV.maxSubarrayPositivos(positivos);
        //int k = DyV.elementoMayoritario(mayoritario);
        //int k = DyV.lastIndex(lastIndex, 8);

        //System.out.println(k);
    
    }

    public static void sumaEnterosBack (){
        
        int[] vector = {13, 11, 7};   
        int[] solucion = new int[vector.length];

        int num = 20;
        int suma = 0;
        
        Booleano exito = new Booleano(false);
        
        //Backtracking.subconjuntoSuma(vector, num, solucion, suma, exito);
        //Backtracking.subconjuntoSuma2(vector, num, solucion, 0,suma, exito);
        Backtracking.subconjuntoSuma3(vector, num, solucion, num, suma, exito);

        Generador.imprimirArray(solucion);
    }

    public static void viajeCaballero(){
        
        int[][] tablero = new int[6][6];
        for (int i=0; i<tablero.length; i++){
            for (int j=0; j< tablero.length; j++){
                tablero[i][j]=0;
            }
        }
            
        tablero[0][0]=1;
        
        Booleano exito = new Booleano(false);
        Backtracking.viajeCaballero(tablero, 2, 0, 0, exito);
        
        Generador.imprimirMatriz(tablero);
        
    }

    public static void nReinas(){

        String[][] tablero = new String[4][4];
        for (int i=0; i<tablero.length; i++){
            for (int j=0; j<tablero.length; j++){
                tablero[i][j]=" ";
            }
        }

        int[] damas = new int[4];
        Booleano exito = new Booleano(false);
        Backtracking.reinas(damas, 0, exito);

        // dibujar solución 
        int k = 0;
        for (int i=0; i<tablero.length; i++){
            tablero[i][damas[k]] = "D";
            k++;
        }

        Generador.imprimirTablero(tablero);
    }

    public static void mochilaOptima(){
        int[] pesos = {3, 7, 2};
        int[] valores = {37, 21, 35};
        int maxPeso = 10;

        int sol[] = new int[pesos.length];
        int valorActual = 0;
        int pesoActual = 0;

        Entero valorMejor = new Entero(0);
        int[] mejorSol = new int[pesos.length];

        Backtracking.mochilaOptima(pesos, valores, maxPeso, 0, sol, valorActual, 
        pesoActual, mejorSol, valorMejor);

        Generador.imprimirArray(mejorSol);
        System.out.println("Mejor valor: "+valorMejor.getValor());
    }

    public static void monedasOptimo(){
        int[] valores = {5, 10, 1};
        int cantidad = 12;

        int numMonedasActual = 0;
        int resto = cantidad;
        int[] sol = new int[valores.length];
        for (int i=0; i<sol.length; i++){
            sol[i] = 0;
        }

        int[] mejorSol = new int[valores.length];
        Entero numMonedasMejor = new Entero(Integer.MAX_VALUE);

        Backtracking.monedasOptimo(valores, 0, sol, numMonedasActual, resto, 
        mejorSol, numMonedasMejor);

        Generador.imprimirArray(mejorSol);
    }

    public static void caminoCosteExacto(){
        int[][] grafo = {
            {0, 1, 0, 0, 0},
            {1, 0, 1, 7, 0},
            {0, 1, 0, 2, 0},
            {0, 7, 2, 0, 5},
            {0, 0, 0, 5, 0}
        };

        for (int i = 0; i < grafo.length; i++){
            for (int j = 0; j < grafo.length; j++){
                if (i != j && grafo[i][j] == 0)
                    grafo[i][j] = Integer.MAX_VALUE;
            }          
        }


        Stack<Integer> camino = new Stack<Integer>();
        int costeObjetivo = 13;

        boolean resul = Backtracking.caminoCosteExacto(grafo, 0, 4, costeObjetivo, camino);

        
        if (resul) {
            System.out.print("Camino de coste exacto "+costeObjetivo+": ");
            Generador.imprimirArray(camino.stream().mapToInt(i->i).toArray());

        } else {
            System.out.println("No existe camino con coste exacto " + costeObjetivo);
        }
            
    }

    public static void ARCM_GD (){ // NO FUNCIONA, NO DEVUELVE UN ARBOL
       
        int O = Integer.MAX_VALUE;
        int[][] grafo = {
            {O, 1, O, O, O},
            {1, O, 2, O, O},
            {O, O, O, 3, 4},
            {O, 1, 2, O, O},
            {O, O, O, 5, O}
        };

        int[][] ARCM = Backtracking.ARCM_CosteMin_GD_valorado (grafo);

        for (int i=0; i< grafo.length; i++){
            for (int j=0; j<grafo.length; j++){
                if (ARCM[i][j] == Integer.MAX_VALUE)
                    ARCM[i][j] = 0;
            }
        }

        Generador.imprimirMatriz(ARCM);
        
    }

    public static void colorearGrafo (){
        int O = Integer.MAX_VALUE;

        int[][] grafo = {
            {O, 1, O, 1}, 
            {1, O, 1, O}, 
            {O, 1, O, 1}, 
            {1, O, 1, O} 
        };

        int[] colores = Backtracking.colorearGrafo(grafo);

        System.out.println("Colores asignados:");
        for (int i = 0; i < colores.length; i++) {
            System.out.println("Vértice " + i + " -> Color " + colores[i]);
        }
    }

    public static void ejerciciosBacktracking(){
        int[] bienes = {5,4,1,3,6,2};
        int[] subConjuntos = {4,2,5,5,1,8};
        int[] longitud = {1,7,3,4};
        int[] cantidad = {1,4,2,1};
        int[] comienzo = {5,2,4,2,6,0,6,2};
        int[] fin = {9,4,5,5,7,3,8,5};

        
        boolean resul = false;
        
        //resul = Backtracking.hayRepartoEquitativo(bienes);
        //resul = Backtracking.dosSubconjuntos(subConjuntos, 10);
        //resul = Backtracking.hayEnsamblaje(longitud, cantidad, 21);
        
        /*
        boolean[] trabajosCompatibles = Backtracking.maxUsoRecurso(comienzo, fin);
        for (int i=0; i<trabajosCompatibles.length; i++) {
           if(trabajosCompatibles[i] == true)
                System.out.println(i);
        }
        */

        if (resul) System.out.println("Exito");
        else System.out.println("No exito");
    }

    
       

}