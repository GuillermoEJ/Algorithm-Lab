package Sort;
public class OrdenacionBasicos {
    // ========== ALGORITMOS DE ORDENACIÓN ==========
    


    // Selection Sort ====================================================================
    public static void selectionSort(int[] array) {
        for (int i = 0; i<array.length; i++){
            int k=i;
            for (int j=i+1; j<array.length; j++){
                if (array[j]<array[k]){
                    k=j;
                }
            }
            int aux = array[i];
            array[i] = array[k];
            array[k] = aux;
        }
    }

    // Insertion Sort ====================================================================
    public static void insertionSort(int[] array){
        for (int i=1; i<array.length; i++){
            int aux = array[i];
            int k = i;
            while (k>0 && array[k-1]>aux){
                array[k] = array[k-1];
                k--;
            }
            array[k] = aux;
        }
    }

    // Bouble Sort =======================================================================
    public static void bubleSort (int[] array){
        for (int i=array.length-1; i>=0; i--){
            for (int j=0; j<i; j++){
                if(array[j]>array[j+1]){
                    int aux = array[j];
                    array[j] = array[j+1];
                    array[j+1] = aux;
                }
            }
        }
    }

    public static void bubleSortOptimizado (int[] array){
        boolean ordenado = false;
        int i = array.length-1;

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
