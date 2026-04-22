package DyV;
public class DyV {
    // ========= ALGORITMOS DIVIDE Y VENCERÁS ==========



    // Búsqueda binaria (array ordenado) =================================================
    public static boolean contiene(int[] array, int num){
        return contieneAux(array, 0, array.length-1, num);
    }

    static boolean contieneAux(int[] array, int i0, int iN, int num){
        if (i0 == iN)
            return (array[i0] == num);
        else {
            int k = (i0 + iN) / 2;

            if (array[k] > num) 
                return contieneAux(array, i0, k, num);
            else if 
                (array[k]==num) return true;
            else 
                return contieneAux(array, k+1, iN, num);
        }
    }

    // Máximo Subarray ===================================================================
    public static int maxSubarray (int[] array){
        return maxSubarrayAux(array, 0, array.length-1);
    }

    static int maxSubarrayAux(int[] array, int i0, int iN){
        if (i0 == iN) 
            return array[i0];
        else {
            int k = (i0 +iN) / 2;
            int m1 = maxSubarrayAux(array, i0, k);
            int m2 = maxSubarrayAux(array, k+1, iN);
            int m3 = maxSubarrayCruzado(array, i0, k, iN);
            return Math.max(m1, Math.max(m2, m3));
        }
    }

    static int maxSubarrayCruzado(int[] array, int i0, int k, int iN){
        int max = Integer.MIN_VALUE;
        int suma = 0;

        for (int i=k; i>=i0; i--){
            suma += array[i];
            if (suma > max){
                max = suma;
            }
        }
        suma = max;
        for (int j=k+1; j<=iN; j++){
            suma += array[j];
            if (suma > max){
                max = suma;
            }
        }
        return max;
    }


    // Quick Sort ========================================================================
    public static void quickSort (int array[]){ // ordena array desordenado
        quickSortAux(array, 0, array.length-1);
    }
    
    static void quickSortAux(int[] array, int i0, int iN){
        if (i0 >= iN){
            return;
        }
        else {
            int m = ordenarPivote(array, i0, iN);
            quickSortAux(array, i0, m-1);
            quickSortAux(array, m+1, iN);
        }
    }

    // Quick Select ======================================================================
    public static int quickSelect (int[] array, int k){ // busca el k-esimo valor más pequeño
        return kValor(array, 0, array.length-1, k);
    }

    static int kValor (int[] array, int i0, int iN, int k){
        if (i0==iN)
            return array[i0];
        else {
            int m = ordenarPivote(array, i0, iN); // elemento que divide el array

            if (k <= iN-m)
                return kValor(array, m+1, iN, k); // si el num está a la derecha
            else if (k == iN-m+1)
                return array[m]; // si justo coincide que el num es m
            else 
                return kValor(array, i0, m-1, k-(iN-m+1)); // si está a la izquierda
        
        }
    }

    // todos los elementos menores del pivote queden a la izquierda de éste,
    // y los elementos mayoresdel pivote queden a la derecha
    static int ordenarPivote(int[] array, int i0, int iN){
        int pivote = array[iN];
        int i = i0;
        int j = iN-1;

        while(i<j){
            while(array[i]<=pivote && i<j){
                i++;
            }
            while(array[j]>pivote && i<j){
                j--;
            }

            int aux = array[i];
            array[i] = array[j];
            array[j] = aux;
        }

        if (array[i]>pivote){
            array[iN] = array[i];
            array[i] = pivote;
            return i;
        }
        else return iN;
    }

    // ==============[ EJERCICIOS ]==============

    // Noviembre 2017
    public static int indiceIgual (int[] array){
        return indiceIgualAux(array, 0, array.length-1);
    }

    static int indiceIgualAux (int[] array, int i0, int iN){
        if (i0 == iN)
            if (array[i0] == i0) return i0;
            else return -1;
        else {
            int k = (i0 + iN) / 2;
            if (array[k] > k) return indiceIgualAux(array, i0, k);
            else if (array[k] == k) return k;
            else return indiceIgualAux(array, k+1, iN);
        }
    }

    // Octubre 2023
    public static int numMultiplos (int[] array, int num){
        return numMultiplosAux (array, 0, array.length-1, num);
    }

    static int numMultiplosAux (int[] array, int i0, int iN, int num){
        if (i0 == iN)
            if (array[i0] % num == 0)
                return 1;
            else return 0;
        else {
            int k = (i0 + iN) / 2;
            int p1, p0 = 0;
            if (array[k] >= k) p0 = numMultiplosAux(array, i0, k, num); // no siempre llama a la parte izquierda
            p1 = numMultiplosAux(array, k+1, iN, num);
            return p0 + p1;
        }
    }

    // Octubre 2022
    public static int primerPositivoPolarizado (int[] array){
        if (array[0] >= 0) return 0; // solo contiene positovos
        else if (array[array.length-1] < 0) return -1; // solo contiene negativos
        else return primerPositivoPolarizadoAux (array, 0, array.length);
    }

    static int primerPositivoPolarizadoAux(int[] array, int i0, int iN){
        if (i0 == iN) return i0;
        else {
            int k = (i0 + iN) / 2;
            if (array[k] < 0) return primerPositivoPolarizadoAux(array, k+1, iN);
            else return primerPositivoPolarizadoAux(array, i0, k);
        }
    }

    // Junio 2024
    public static int positivoMenor (int[] array){
        return positivoMenorAux(array, 0, array.length-1);
    }

    static int positivoMenorAux (int[] array, int i0, int iN){
        if (i0 == iN)
            if (array[i0] <= 0) return -1;
            else return array[i0];
        else {
            int k = (i0 +iN) / 2;
            if (array[k] < 0) return positivoMenorAux(array, k+1, iN);
            else return positivoMenorAux(array, i0, k);
        }
    }

    // Noviembre 2016
    public static int elementoSolitario (int[] array){
        return elementoSolitarioAux (array, 0, array.length-1);
    }

    static int elementoSolitarioAux (int[] array, int i0, int iN){
        if (i0 == iN)
           return array[i0];
        else {
            int k = (i0 + iN) / 2;
            if (array[k-1] == array[k]){
                if ( (k-2-i0+1)%2 == 0)
                    return elementoSolitarioAux(array, k+1, iN);
                else 
                    return elementoSolitarioAux(array, i0, k-2);
            }
            else if (array[k] == array[k+1]) {
                if ( (k-1-i0+1)%2 == 0)
                    return elementoSolitarioAux(array, k+2, iN);
                else 
                    return elementoSolitarioAux(array, i0, k-1);
            }
            else return array[k];
        }
    }

    // Octubre 2024
    public static int primerIndex (int[] array, int num){
        return primerIndexAux(array, 0, array.length-1, num);
    }

    static int primerIndexAux (int[] array, int i0, int iN, int num){
        if (i0 == iN)
            if (array[i0] == num)
                return i0;
            else return -1;
        else {
            int k = (i0 + iN) / 2;
            if (array[k] < num) return primerIndexAux(array, k+1, iN, num);
            else return primerIndexAux(array, i0, k, num);
            
        }
    }

    // Junio 2023
    public static int maxSubarrayUnos (int[] array) {
        return maxSubarrayUnosAux (array, 0, array.length-1);
    }

    static int maxSubarrayUnosAux (int[] array,  int i0, int iN){
        if (i0 == iN)
            return array[i0];
        else {
            int k = (i0 + iN) / 2;
            int m1 = maxSubarrayUnosAux(array, i0, k);
            int m2 = maxSubarrayUnosAux(array, k+1, iN);
            int m3 = maxSubarrayUnosAuxCruzado(array, i0, k, iN);
            return Math.max(m1, Math.max(m2, m3));
        }
    }

    static int maxSubarrayUnosAuxCruzado (int[] array, int i0, int k, int iN){
        int cant_i = 0;
        int cant_j = 0;
        int i = k;
        int j = k+1;

        while (i >= i0 && array[i] == 1) {
            cant_i++;
            i--;
        }

        while (j <= iN && array[j] == 1){
            cant_j++;
            j++;
        }

        int suma =  cant_i + cant_j;
        return suma;
    }

    // =============== EXÁMENES ==============  

    // Noviembre 2028
    public static int minArrayRotado (int[] array){
        return minArrayRotadoAux(array, 0, array.length-1);
    }

    static int minArrayRotadoAux (int[] array, int i0, int iN){
        if (i0 == iN)
            return array[i0];
        else {
            int k = (i0 + iN) / 2;
            if(array[i0] < array[iN])
                return array[i0];
            else if (array[i0] < array[k])
                return minArrayRotadoAux(array, k+1, iN);
            else return minArrayRotadoAux(array, i0, k);
        }
    }

    // Noviembre 2019 -> ordenados circularmente, comprobar extremos es necesario
    public static int elementoEspecial(int[] array){ 
        if (array.length == 1) return array[0];
        else {
            int i0, iN;
            if (array[0] == array[array.length-1]){
                i0 = 1;
                iN = array.length-2;
            }
            else {
                i0 = 0;
                iN = array.length-1;
            }
            return elementoEspecialAux(array, i0, iN);
        }
        
    }

    static int elementoEspecialAux(int[] array, int i0, int iN){
        if (i0 == iN)
            return array[i0];
        else {
            int k = (i0 +iN) / 2;
            if(array[k-1] == array[k]){
                if((k-2+i0+1)%2 == 0)
                    return elementoEspecialAux(array, k+1, iN);
                else 
                    return  elementoEspecialAux(array, i0, k-2);
            }
            else if (array[k] == array[k+1]){
                if ((k-1+i0+1)%2 == 0)
                    return elementoEspecialAux(array, k+2, iN);
                else 
                    return elementoEspecialAux(array, i0, k-1);
            }
            else return array[k];
        }
    }

    // Diciembre 2020
    public static int maxArrayColina(int[] array){
        return maxArrayColinaAux(array, 0, array.length-1);
    }

    static int maxArrayColinaAux(int[] array, int i0, int iN){
        if (i0 == iN)
            return array[i0];
        else {
            int k = (i0 + iN) / 2;
            if (array[k] < array[k+1])
                return maxArrayColinaAux(array, k+1, iN);
            else if (array[k-1] < array[k])
                return array[k];
            else
                return maxArrayColinaAux(array, i0, k);
        }
    }

    // Junio 2021
    public static int posDiferente (int[] v1, int[] v2){
        return posDiferenteAux(v1, v2, 0, v1.length-1);
    }

    static int posDiferenteAux (int[] v1, int[] v2, int i0, int iN){
        if (i0 == iN)
            if (v1[i0] == v2[i0])
                return -1;
            else return i0;
        else {
            int k = (i0 + iN) / 2;
            if (v1[k] == v2[k]) 
                return posDiferenteAux(v1, v2, k+1, iN);
            else return posDiferenteAux(v1, v2, i0, k);
        }
    }

    // Noviembre 2021 -> longitud max subarray 
    public static int longMaxSubarray (int[] array){
        return longMaxSubarrayAux(array, 0, array.length-1);
    }

    static int longMaxSubarrayAux(int[] array, int i0, int iN){
        if (i0 == iN) 
            return 1;
        else {
            int k = (i0 + iN) / 2;
            int m1 = longMaxSubarrayAux(array, i0, k);
            int m2 = longMaxSubarrayAux(array, k+1, iN);
            int m3 = longMaxSubarrayAuxCruzado(array, i0, k, iN);
            return Math.max(m1, Math.max(m2, m3));
        }
    }

    static int longMaxSubarrayAuxCruzado(int[] array, int i0, int k, int iN){
        int i = k;
        int j = k;

        while (i>i0 && array[i-1]<=array[i]){
            i--;
        }

        while (j<iN && array[j]<=array[j+1]) {
            j++;
        }

        return j-i+1; // +1 porque no se cuenta la posición en los extremos

    }

    // Noviembre 2022
    public static int parImpar (int[] array){
        return parImparAux(array, 0, array.length-1);
    }

    static int parImparAux(int[] array, int i0, int iN){
        if (i0 == iN)
            return i0;
        else {
            int k = (i0 + iN) / 2;
            if (esPar(array[k]) && esPar(k) || !esPar(array[k]) && !esPar(k)){
                return parImparAux(array, k+1, iN);
            }
            else 
                return parImparAux(array, i0, k);
        }

    }

    static boolean esPar (int x){
        if (x%2 == 0) return true;
        else return false;
    }

    // Enero 2023
    public static int maxSubarrayPositivos (int[] array){
        return maxSubarrayPositivosAux(array, 0, array.length-1);
    }

    static int maxSubarrayPositivosAux (int[] array, int i0, int iN){
        if (i0 == iN) 
            if (array[i0] > 0) return array[i0];
            else return 0;
        else {
            int k = (i0 + iN) / 2;
            int m1 = maxSubarrayPositivosAux(array, i0, k);
            int m2 = maxSubarrayPositivosAux(array, k+1, iN);
            int m3 = maxSubarrayPositivosCruzado(array, i0, k, iN);
            return Math.max(m1, Math.max(m2, m3));
        }
    }

    static int maxSubarrayPositivosCruzado(int[] array, int i0, int k, int iN){
        int suma = 0;
        if (array[k] < 0) return 0;
        else {
            int i = k;
            int j = k+1;

            while (i>=i0 && array[i]>0) {
                suma += array[i];
                i--;
            }

            while (j<=iN && array[j]>0){
                suma += array[j];
                j++;
            }
                
            return suma;
        }
    }

    // Enero 2024 -> ordenar pares derecha, impares izquierda
    public static void pares (int[] array){
        paresAux(array, 0, array.length-1);
    }

    static void paresAux (int[] array, int i0, int iN){
        if (i0 == iN) return;
        else {
            int k = (i0 + iN) / 2;
            paresAux(array, i0, k);
            paresAux(array, k+1, iN);
            paresMerge(array, i0, k, iN);
        }
    }

    static void paresMerge (int[] array, int i0, int k, int iN){
        int l = i0;
        int r = iN;

        while (l<=k && array[l]%2 == 0){ // saltamos pares
            l++; // l en el primer elemento impar de la mitad izq
        }

        while (r>=k && array[r]%2 != 0) { // saltamos impares
            r--; // r en el ultimo elemento par de la mitad der
        }

        while(l<=k && r>k){
            int aux = array[l];
            array[l] = array[r];
            array[r] = aux;
            l++;
            r--;
        }
        /*
        mientras haya elementos en la mitad izquierda (que nos hemos asegurado de que 
        sean impares) y en la mitad derecha (que nos hemos asegurado de que sean  
        pares), los vamos intercambiando, incrementamos l y decrementamos r.
        */
    }

    // Junio 2025
    public static int elementoMayoritario (int[] array){
        int k = (array.length+1) / 2;
        return kesimoAux(array, 0, array.length-1, k);
    }

    static int kesimoAux (int[] array, int i0, int iN, int k){
        if (i0 == iN) 
            return array[i0];
        else {
            int m = ordenarPorPivote(array, i0, iN);
            if (k <= iN-m) return kesimoAux(array, m+1, iN, k);
            else if (k == iN-m+1) return array[m];
            else return kesimoAux(array, i0, m-1, k-(iN-m+1));
        }
    }

    static int ordenarPorPivote (int[] array, int i0, int iN){
        int pivote = array[iN];
        int i = i0;
        int j = iN-1;

        while (i<j) {
            while (array[i]<=pivote && i<j) {
                i++;
            }
            while (array[j]>pivote && j>i){
                j--;
            }
            int aux = array[i];
            array[i] = array[j];
            array[j] = aux;
        }

        if(array[i]>pivote){
            array[iN] = array[i];
            array[i] = pivote;
            return i;
        }
        else return iN;
    }

    // Octubre 2025
    public static int lastIndex (int[] array, int num){
        return lastIndexAux(array, 0, array.length-1, num);
    }

    static int lastIndexAux (int[] array, int i0, int iN, int num){
        if (i0 == iN){
            if (array[i0] == num) return i0;
            else return -1;
        }
        else {
            int k = (i0 + iN) / 2;
            if (array[k] == num){
                if (array[k+1] != num)
                    return k;
                else 
                    return lastIndexAux(array, k+1, iN, num);
            }
            else if (array[k] < num)
                return lastIndexAux(array, k+1, iN, num);
            else 
                return lastIndexAux(array, i0, k, num);
        }
    }


}
