package BackTracking;

import java.util.Stack;

public class Backtracking {
    // ========= Algoritmos de Backtracking ============

    // Suma de enteros es num, arbol binario V1
    public static void subconjuntoSuma (int[] vector, int num, int[] sol, int nivel, Booleano exito){
        if (nivel == vector.length){
            if (suma(sol, vector, nivel) == num)
                exito.setValor(true);
        }
        else {
            int c = 0; // Candidatos: c=0 no añadir, c=1 añadir
            while (!exito.getValor() && c < 2){
                if (c == 0 || suma(sol, vector, nivel) + vector[nivel] <= num){ //poda
                    sol[nivel] = c;
                    nivel = nivel + 1;
                    subconjuntoSuma(vector, num, sol, nivel, exito);
                    if(!exito.getValor()){
                        nivel = nivel - 1;
                        sol[nivel] = 0;
                    }
                }
                c++;
            }
        }
    }

   static int suma (int[] sol, int[] vector, int nivel){
        int suma = 0;
        for (int i = 0; i < nivel; i++){
            if (sol[i] == 1)
                suma += vector[i];
        }
        return suma;
    }

    // Suma de enteros es num, arbol binario V2
    public static void subconjuntoSuma2(int[] vector, int num, int[] sol, int nivel, int suma, Booleano exito){
        if (nivel == vector.length){
            if ( suma == num) 
                exito.setValor(true);
        }
        else {
            int c = 0;
            while (!exito.getValor() && c < 2){
                if (c == 0 || (suma + vector[nivel]) <= num){
                    sol[nivel] = c;
                    suma += vector[nivel]*c;
                    nivel ++;
                    subconjuntoSuma2(vector, num, sol, nivel, suma, exito);
                    
                    if (!exito.getValor()){
                        nivel--;
                        sol[nivel] = 0;
                        suma -= vector[nivel]*c;
                    }
                }
                c++;
            }
        }
    }

    // suma de enteros es num, árbol combinatorio
    public static void subconjuntoSuma3 (int[] vector, int num, int[] sol, int id, int suma, Booleano exito){
        if (suma == num)
            exito.setValor(true);
        else {
            int c = id; // candidatos: c = id.vector.length
            while (!exito.getValor() && c < vector.length) {
                if ( (suma + vector[c]) <= num){
                    sol[c] = 1;
                    suma += vector[c];
                    c ++;

                    subconjuntoSuma3(vector, num, sol, c, suma, exito);
                    if (!exito.getValor()){
                        c --;
                        sol[c] = 0;
                        suma -= vector[c];
                    }

                }
                c++;
            }

        }
    }


    // Viaje del Caballero 
    public static void viajeCaballero (int[][] tablero, int numMov, int x, int y, Booleano exito){
        if (numMov > tablero.length*tablero.length)
            exito.setValor(true);
        else {
            int k, u, v;
            k = 0; // candidatos -> k
            while (!exito.getValor() && k<8){ // quedan candidatos
                u = x + dx[k];
                v = y + dy[k];

                if (u>=0 && u<tablero.length && v>=0 && v<tablero.length && tablero[u][v]==0){
                    tablero[u][v] = numMov;
                    numMov++;
                    viajeCaballero(tablero, numMov, u, v, exito);

                    if(!exito.getValor()){
                        tablero[u][v] = 0;
                        numMov--;
                    }
                }
                k++;
            }
        }
    }

    static int[] dx = {-1,-2,-2,-1, 1, 2, 2, 1};
    static int[] dy = {-2,-1, 1, 2, 2, 1,-1,-2};


    // Problema de las N Reinas
    public static void reinas (int[] damas, int fila, Booleano exito){
        if (fila == damas.length)
            exito.setValor(true);
        else {
            int c = 0;
            while (!exito.getValor() && c<damas.length){
                if (aceptable(damas, fila, c)){
                    damas[fila] = c;
                    fila = fila + 1;
                    reinas(damas, fila, exito);

                    if(!exito.getValor()){
                        fila--;
                    }
                }
                c++;
            }
        }
    }

    static boolean aceptable (int[] damas, int fila, int c){
        boolean correcto = true;
        int i = 0;

        while (correcto && i<fila) {
            correcto = (damas[i] != c) && (Math.abs(damas[i]-c) != Math.abs(i-fila));
            i++; 
        }
        return correcto;
    }

    // ============================== [SELECCIÓN ÓPTIMA] =================================

    // Problema de la Mochila 
    public static void mochilaOptima(int[] pesos, int[] valores, int maxPeso, int nivel, 
    int[] sol, int valorActual, int pesoActual, int[] mejorSol, Entero valorMejor){
        if (nivel == pesos.length){
            if (valorActual > valorMejor.getValor()){
                valorMejor.setValor(valorActual);
                for (int i=0; i<sol.length; i++){
                    mejorSol[i] = sol[i];
                }
            }
        }
        else {
            for (int c=0; c<2; c++){
                if ((c == 0) || (pesoActual + pesos[nivel] <= maxPeso)){
                    sol[nivel] = c;
                    valorActual += valores[nivel]*c;
                    pesoActual += pesos[nivel]*c;
                    nivel++;

                    mochilaOptima(pesos, valores, maxPeso, nivel, sol, valorActual, 
                    pesoActual, mejorSol, valorMejor);

                    nivel--;
                    pesoActual -= pesos[nivel]*c;
                    valorActual -= valores[nivel]*c;
                    sol[nivel] = 0;
                }
            }
        }
    }

    // Cambio de Monedas
    public static  void monedasOptimo(int[] valores, int nivel, int[] sol, int numMonedas, 
    int resto, int[] mejorSol, Entero numMonedasMejor){
        if (resto == 0){
            if (numMonedas < numMonedasMejor.getValor()){
                numMonedasMejor.setValor(numMonedas);

                for (int i=0; i<mejorSol.length; i++){
                    mejorSol[i] = sol[i];
                }
            }
        }
        else if (nivel < valores.length){ //controlar que no es nodo hoja
            for (int n=0; n<=(resto/valores[nivel]); n++){
                sol[nivel] = n;
                numMonedas += n;
                resto -= valores[nivel]*n;
                nivel++;

                if (numMonedas < numMonedasMejor.getValor()){ // poda: avanzar solo si no hemos mejorado
                    monedasOptimo(valores, nivel, sol, numMonedas, resto, mejorSol, 
                    numMonedasMejor);
                }
                nivel--;
                resto += valores[nivel]*n;
                numMonedas -= n;
                sol[nivel] = 0;
            }
        }
    }


    // ================================ [GRAFOS] =========================================
    
    // Camino simple de coste exacto x
    public static boolean caminoCosteExacto (int[][] grafo, int origen, int destino,
    double coste, Stack<Integer> camino){
        Booleano exito = new Booleano(false);
        boolean[] visitados = new boolean[grafo.length];
        for (int i=0; i<grafo.length; i++) {visitados[i] = false;}
        visitados[origen] = origen != destino; // permite buscar caminos simples con origen=destino
        camino.push(origen);

        caminoExactoBack(grafo, origen, destino, coste, visitados, camino, exito);

        return exito.getValor();
    }

    public static void caminoExactoBack (int[][] grafo, int origen, int destino, double coste,
    boolean[] visitados, Stack<Integer> camino, Booleano exito){
        if ( coste==0 && origen==destino){
            exito.setValor(true);
        }
        else {
            int v = 0;
            while (!exito.getValor() && v != grafo.length){
                if (!visitados[v] && grafo[origen][v] != Integer.MAX_VALUE){
                    if (grafo[origen][v] <= coste){
                        visitados[v] = true;
                        coste -= grafo[origen][v];
                        camino.push(v);

                        caminoExactoBack(grafo, v, destino, coste, visitados, camino, exito);

                        if (!exito.getValor()){
                            visitados[v] = false;
                            coste += grafo[origen][v];
                            camino.pop();
                        }
                    }
                }
                v++;
            }
        }
    }


    // ARCM en Grafo Dirigido Valorado 
    public static int[][] ARCM_CosteMin_GD_valorado (int[][] grafo){
        int[][] ARCM = new int[grafo.length][grafo.length];
        int[][] subgrafo = new int[grafo.length][grafo.length];

        for(int i=0; i<subgrafo.length; i++){
            for (int j=0; j<subgrafo.length; j++){
                subgrafo[i][j] = Integer.MAX_VALUE;
            }
        }

        Entero mejorCoste = new Entero(Integer.MAX_VALUE);
        int coste = 0;

        ARCM_GD(grafo, subgrafo, 0, coste, ARCM, mejorCoste);

        if(mejorCoste.getValor() != Integer.MAX_VALUE){
            System.out.println("Coste: "+mejorCoste.getValor());
            return ARCM;
        }
        else return null;
    }

    static void ARCM_GD_optimizado(int[][] grafo, int[][] subgrafo, int Naristas, int coste, 
    int x, int y, int[][] ARCM, Entero mejorCoste){
        if (Naristas == grafo.length-1){
            if (esArbol(subgrafo)){
                if (mejorCoste.getValor() > coste){
                    copia(subgrafo, ARCM);
                    mejorCoste.setValor(coste);
                }
            }
        }
        else {
            for (int i=x; i<grafo.length; i++){
                for (int j=y; j<grafo.length; j++){
                    if (grafo[i][j] != Integer.MAX_VALUE){
                        subgrafo[i][j] = grafo[i][j];
                        coste += grafo[i][j];
                        Naristas++;

                        if (coste < mejorCoste.getValor()){
                            int nx = i;
                            int ny = j+1;

                            if (ny == grafo.length){
                                ny = 0;
                                nx++;
                            }
                            ARCM_GD_optimizado(grafo, subgrafo, Naristas, coste, nx, ny, ARCM, mejorCoste);
                        }

                        subgrafo[i][j] = Integer.MAX_VALUE;
                        coste -= grafo[i][j];
                        Naristas--;
                    }
                }
            }
        }
    }


    public static void ARCM_GD (int[][] grafo, int[][] subgrafo, int Naristas, int coste, 
    int[][] ARCM, Entero mejorCoste){
        if (Naristas == grafo.length-1){
            if (esArbol(subgrafo)){
                if (mejorCoste.getValor() > coste){
                    copia(subgrafo, ARCM);
                    mejorCoste.setValor(coste);
                }
            }
        }
        else {
            for (int i=0; i<grafo.length; i++){ // candidatos = todas las aristas del grafo
                for (int j=0; j<grafo.length; j++){
                    if (grafo[i][j] != Integer.MAX_VALUE && subgrafo[i][j] == Integer.MAX_VALUE){ // aceptable = existe en grafo y no está ya en subgrafo
                        subgrafo[i][j] = grafo[i][j];
                        coste += grafo[i][j];
                        Naristas++;

                        if (coste < mejorCoste.getValor()){ //avance en espacio de busqueda (poda)
                            ARCM_GD(grafo, subgrafo, Naristas, coste, ARCM, mejorCoste);
                        }

                        subgrafo[i][j] = Integer.MAX_VALUE;
                        coste -= grafo[i][j];
                        Naristas--;
                    }
                }
            }
        }
    }

    static void copia (int[][] origen, int[][] destino){
        for (int i=0; i<origen.length; i++){
            for (int j=0; j<origen.length; j++){
                destino[i][j] = origen[i][j];
            }
        }
    }


    static boolean esArbol (int[][] grafo){
        int gradoEnt0 = 0;
        int gradoEnt;
        int v = 0;
        boolean ok = esGrafoConexo(grafo);

        while (v < grafo.length && ok){
            gradoEnt = gradoEntrada(grafo, v);
            ok = gradoEnt <= 1;
            if (gradoEnt == 0)
                gradoEnt0++;
            v++;
        }

        return (gradoEnt0 == 1) && ok;
    }


    static int gradoEntrada (int[][] grafo, int vertice){
        int grado = 0;

        for (int ady=0; ady<grafo.length; ady++){
            if (grafo[ady][vertice] != Integer.MAX_VALUE)
                grado++;
        }

        return grado;
    }

    static boolean esGrafoConexo (int[][] grafo){
        boolean[] visitados = new boolean[grafo.length];
        
        for (int i=0; i<grafo.length; i++){
            visitados[i] = false;
        }

        recorrerCadena(grafo, 0, visitados);

        return todosVisitados(visitados);
    }

    static void recorrerCadena(int[][] grafo, int origen, boolean[] visitados){
        visitados[origen] = true;

        for (int ady=0; ady<grafo.length; ady++){
            if (!visitados[ady]){
                if (grafo[origen][ady] != Integer.MAX_VALUE ||
                    grafo[ady][origen] != Integer.MAX_VALUE){
                        recorrerCadena(grafo, ady, visitados);
                    }

            }
        }
    }

    static boolean todosVisitados (boolean[] visitados){
        boolean ok = true;
        int i = 0;

        while (i < visitados.length && ok) {
            ok = visitados[i];
            i++;            
        }

        return ok;
    }

    // Colorear un grafo (GN)
    public static int[] colorearGrafo (int[][] grafo){
        int[] colores = new int[grafo.length];
        int[] mejorColores = new int[grafo.length];

        for (int i=0; i<grafo.length; i++){
            colores[i] = -1; // inicializa sin color
            mejorColores[i] = i; // inicializa al peor valor (v colores disintos)
        }

        numeroCromatico(grafo, 0, colores, mejorColores);

        return mejorColores;
    }

    static void numeroCromatico (int[][] grafo, int v, int[] colores, int[] mejorColores){
        if (v == grafo.length){
            if (coloresDistintos(colores) < coloresDistintos(mejorColores)){
                for (int i=0; i<colores.length; i++){
                    mejorColores[i] = colores[i];
                }
            }
        }
        else {
            for (int c=0; c<grafo.length; c++){
                if (aceptable(grafo, v, c, colores)){
                    colores[v] = c;
                    v++;

                    numeroCromatico(grafo, v, colores, mejorColores);

                    v--;
                    colores[v] = -1;
                }

            }
        }
    }

    static boolean aceptable (int[][] grafo, int v, int c, int[] colores){
        boolean ok = true;
        int j = 0;

        while (j<v && ok){
            if (grafo[v][j] != Integer.MAX_VALUE){
                ok = (colores[j] != c);
            }
            j++;
        }

        return ok;
    }

    static int coloresDistintos (int[] colores){
        int c = 0;
        boolean[] hayColor = new boolean[colores.length];

        for (int i=0; i<colores.length; i++) 
            hayColor[i] = false;
        for (int i=0; i<colores.length; i++) 
            hayColor[colores[i]] = true;
        for (int i=0; i<colores.length; i++){ 
            if (hayColor[i])
                c++;
        }
        return c;
    }

    // ============================== EJERCICIOS =========================================

    // Junio 2018
    public static boolean hayRepartoEquitativo(int[] bienes){
        int suma = 0;
        for (int i=0; i<bienes.length; i++){
            suma += bienes[i];
        }

        if (suma%3 == 0){ // dividir entre 3 personas
            Booleano exito = new Booleano(false);
            int parte = suma/3;
            int[] falta = {parte, parte, parte};

            hayRepartoEquitativoAux(bienes, 0, falta, exito);

            return exito.getValor();
        }
        else return false;
    }    

    static void hayRepartoEquitativoAux(int[] bienes, int objetivo, int[] falta, Booleano exito){
        if (objetivo == bienes.length){
            if (falta[0] == falta[1] && falta[1] == falta[2])
                exito.setValor(true);
        }
        else{
            int c = 0;
            while (c<3 && !exito.getValor()) {
                if (bienes[objetivo] <= falta[c]){
                    falta[c] -= bienes[objetivo];
                    objetivo++;

                    hayRepartoEquitativoAux(bienes, objetivo, falta, exito);

                    objetivo--;
                    falta[c] += bienes[objetivo];
                }
                c++;
            }
        }
    }

    // Diciembre 2020
    public static boolean dosSubconjuntos (int[] array, int valor){
        Booleano exito = new Booleano(false);
        int total = 0;
        for (int i=0; i<array.length; i++){
            total += array[i];
        }

        if (total/2 >= valor)
            dosSubconjuntosAux(array, valor, 0, 0, 0, exito);

        return exito.getValor();
    }

    static void dosSubconjuntosAux(int[] array, int valor, int obj, int acumA, int acumB, Booleano exito){
        if (acumA == acumB && acumB == valor)
            exito.setValor(true);
        else if (obj < array.length) {
            int c = 0;
            while (c<3 && !exito.getValor()){
                if (c==0 || c==1 && acumA+array[obj] <= valor || c==2 && acumB+array[obj] <= valor){
                    if (c==1)
                        acumA += array[obj];
                    else if (c==2)
                        acumB += array[obj];

                    obj++;

                    dosSubconjuntosAux(array, valor, obj, acumA, acumB, exito);

                    if (!exito.getValor()){
                        obj--;
                        if (c==1)
                            acumA -= array[obj];
                        else if (c==2)
                            acumB -= array[obj];
                    }
                }
                c++;
            }
        }
    }

    // Octubre 2024
    public static boolean hayEnsamblaje (int[] longitud, int[] cantidad, int longTotal){
        Booleano exito = new Booleano(false);
        int falta = longTotal;

        hayEnsamblajeAux(longitud, cantidad, 0, falta, exito);

        return exito.getValor();
    }

    static void hayEnsamblajeAux (int[] longitud, int[] cantidad, int nivel, int falta, Booleano exito){
        if (nivel == longitud.length){
            if (falta == 0)
                exito.setValor(true);
        }
        else {
            int c = 0;
            int cMax = Math.min(cantidad[nivel], falta/longitud[nivel]);

            while (c <= cMax && !exito.getValor()){
                falta -= longitud[nivel]*c;
                nivel++;

                hayEnsamblajeAux(longitud, cantidad, nivel, falta, exito);

                if (!exito.getValor()){
                    nivel--;
                    falta += longitud[nivel]*c;
                }
                c++;
            }
        }
    }

    // Noviembre 2019
    public static boolean[] maxUsoRecurso (int[] comienzo, int[] fin){
        boolean[] seleccionados = new boolean[comienzo.length];
        boolean[] mejorSeleccionados = new boolean[comienzo.length];
        Entero mejorUsoRecurso = new Entero(0);
        int usoRecurso = 0;

        for (int i=0; i<seleccionados.length; i++){
            seleccionados[i] = false;
        }
        
        maxUsoRecursoAux(comienzo, fin, 0, seleccionados, usoRecurso, mejorSeleccionados, mejorUsoRecurso);

        return mejorSeleccionados;
    }

    static void maxUsoRecursoAux (int[] comienzo, int[] fin, int tarea, boolean[] seleccionados,
    int usoRecurso, boolean[] mejorSeleccionados, Entero mejorUsoRecurso) {
        if (tarea == comienzo.length){
            if (usoRecurso > mejorUsoRecurso.getValor()){
                for (int i=0; i<seleccionados.length;  i++){
                    mejorSeleccionados[i] = seleccionados[i];
                }
            }
        }
        else {
            for (int c=0; c<2; c++){ // 0 = No seleccionar , 1 = Selecceionar
                if (c==0 || compatible(comienzo, fin, seleccionados, tarea)){
                    seleccionados[tarea] = c==1;
                    usoRecurso += (fin[tarea] - comienzo[tarea]) * c;
                    tarea++;

                    maxUsoRecursoAux(comienzo, fin, tarea, seleccionados, usoRecurso, mejorSeleccionados, mejorUsoRecurso);

                    tarea--;
                    usoRecurso -= (fin[tarea] - comienzo[tarea]) * c;
                    seleccionados[tarea] = false;
                }
            }
        }
    }

    static boolean compatible (int[] comienzo, int[] fin, boolean[] seleccionados, int tarea){
        boolean ok = true;
        int i=0;
        while (ok && i<tarea){
            if (seleccionados[i]){
                ok = comienzo[i]>=fin[tarea] || comienzo[tarea]>=fin[i];
            }
            i++;
        }
        return ok;
    }




}
