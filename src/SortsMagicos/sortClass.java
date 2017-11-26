/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortsMagicos;

/**
 *
 * @author Alf
 */
public class sortClass {

    private int[] vectorIncremento;

    public sortClass() {
        this.vectorIncremento = new int[]{27479, 22531, 18523, 9007, 2003, 1117, 787, 127, 79, 17, 5, 1};
    }

    //----------------------
    //1 - Insercion directa:
    //----------------------
    public int[] insercionDirecta(int[] vector) {
        int[] copia = vector.clone();
        for (int i = 1; i < copia.length; i++) {
            int aux = copia[i];
            int j = i - 1;
            while (j >= 0 && aux < copia[j]) {
                copia[j + 1] = copia[j];
                j--;
            }
            copia[j + 1] = aux;
        }
        return copia;
    }

    //--------------
    //2 - BubbleSort:
    //--------------
    public int[] bubbleSort(int[] vector) {
        int[] copia = vector.clone();
        boolean ordenado = false;
        int ultimo = vector.length - 1;
        while (!ordenado) {
            ordenado = true;
            for (int i = 0; i < ultimo; i++) {
                if (copia[i] > copia[i + 1]) {
                    int aux = copia[i];
                    copia[i] = copia[i + 1];
                    copia[i + 1] = aux;
                    ordenado = false;
                }
            }
            ultimo--;
        }
        return copia;
    }

    //--------------
    //3 - QuickSort:
    //--------------
    public int[] quickSort(int[] vector) {
        int[] copia = vector.clone();
        return this.quickSort(copia, 0, copia.length - 1);
    }

    private int[] quickSort(int[] vector, int i, int j) {
        if (vector.length > 1) {
            int izq = i;
            int der = j;
            int pivote = vector[izq + (der - izq) / 2];
            while (izq <= der) {
                while ((vector[izq] < pivote) && (izq < j)) {
                    izq++;
                }
                while ((pivote < vector[der]) && (der > i)) {
                    der--;
                }
                if (izq <= der) {
                    int aux = vector[izq];
                    vector[izq] = vector[der];
                    vector[der] = aux;
                    izq++;
                    der--;
                }
            }
            if (i < der) {
                quickSort(vector, i, der);
            }
            if (izq < j) {
                quickSort(vector, izq, j);
            }
        }
        return vector;
    }

    //----------------------
    //4 - Seleccion Directa:
    //----------------------
    public int[] seleccionDirecta(int[] vector) {
        int[] copia = vector.clone();
        for (int i = 0; i < copia.length; i++) {
            int min = i;
            for (int j = i; j < copia.length; j++) {
                if (copia[j] < copia[min]) {
                    min = j;
                }
            }
            int aux = copia[i];
            copia[i] = copia[min];
            copia[min] = aux;
        }
        return copia;
    }

    //-------------
    //5 - HeapSort:
    //-------------
    public int[] heapSort(int[] vector) {
        int[] copia = vector.clone();
        for (int i = copia.length / 2 - 1; i >= 0; i--) {
            hippieficar(copia, copia.length, i);
        }
        for (int i = copia.length - 1; i >= 0; i--) {
            int aux = copia[0];
            copia[0] = copia[i];
            copia[i] = aux;
            hippieficar(copia, i, 0);
        }
        return copia;
    }

    /**
     *
     * @param arr
     * @param n
     * @param i
     */
    private void hippieficar(int arr[], int n, int i) {
        int maximo = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[maximo]) {
            maximo = l;
        }
        if (r < n && arr[r] > arr[maximo]) {
            maximo = r;
        }
        if (maximo != i) {
            int swap = arr[i];
            arr[i] = arr[maximo];
            arr[maximo] = swap;
            hippieficar(arr, n, maximo);
        }
    }

    //-------------
    //6 - shellSort:
    //-------------
    public int[] shellSort(int[] vector) {
        int[] copia = vector.clone();
        int indice = this.calcularVectorIncremento(copia.length);
        while (indice < this.vectorIncremento.length) {
            int incremento = this.vectorIncremento[indice];
            for (int i = incremento; i < copia.length; i++) {
                int aux = copia[i];
                int j = i - incremento;
                while (j >= 0 && aux < copia[j]) {
                    copia[j + incremento] = copia[j];
                    j -= incremento;
                }
                copia[j + incremento] = aux;
            }
            indice++;
        }
        return copia;
    }

    private int calcularVectorIncremento(int valor) {
        for (int i = this.vectorIncremento.length - 1; i >= 0; i--) {
            if (this.vectorIncremento[i] < valor) {
                return i;
            }
        }
        return -1;
    }

    public int[] cuentaPorDistribucion(int[] vector, int menorValor, int mayorValor) {
        int[] copia = vector.clone();
        int[] vectorFinal = new int[copia.length];
        if (menorValor <= mayorValor) {
            int[] cuenta = new int[mayorValor - menorValor + 1];
            for (int j = 0; j < copia.length; j++) {
                cuenta[copia[j] - menorValor]++;
            }
            for (int i = 0; i < cuenta.length - 1; i++) {
                cuenta[i + 1] += cuenta[i];
            }
            for (int j = copia.length - 1; j >= 0 ; j--) {
                int aux = cuenta[copia[j] - menorValor];
                vectorFinal[aux - 1] = copia[j];
                cuenta[copia[j] - menorValor]--;
            }
        }
        return vectorFinal;
    }
    
    public int[] esUnBaldeSort(int[] vectorP, int cantidadBaldes) {
        Double m = (vectorP.length / cantidadBaldes) * 1.5;
        int m2 = m.intValue() + 1;
        
        int[][] matrizConBaldes = new int[cantidadBaldes][10];
        
        for(int i=0; i < vectorP.length; i++){
            insertarEnBalde(vectorP[i], matrizConBaldes);
        }
        
        int[] vectorFinal = new int[vectorP.length];
        for(int i = 0; i < matrizConBaldes.length; i++){
            int[] subVectorOrdenado = seleccionDirecta(matrizConBaldes[i]);
            System.out.println(strArray(subVectorOrdenado));
            vectorFinal = subConcatenar(vectorFinal, subVectorOrdenado);
        }
        
        return vectorFinal;
    }
    
    public void insertarEnBalde(int valor, int[][] matriz){
        int valor2 = valor;
        int cantidadBaldes = matriz[0].length;
        
        if(valor2 >= cantidadBaldes){
            while(valor2 >= cantidadBaldes){
                valor2 = valor2 / cantidadBaldes;
            }
        }
        
        for(int i = 0; i < matriz[valor2].length; i++){
            if(matriz[valor2][i] == 0){
                matriz[valor2][i] = valor;
                break;
            }
        }
    }
    
    public int[] subConcatenar(int[] vector1, int[] vector2){
        int[] vectorReturn = new int[vector1.length + vector2.length];
        
        for(int i = 0; i < vector1.length; i++){
            vectorReturn[i] = vector1[i];
        }
        
        for(int i = 0; i < vector2.length; i++){
            vectorReturn[i + vector1.length] = vector2[i];
        }
        
        return vectorReturn;
    }

    /**
     * Metodo que se encarga de recorrer el array y nos devuelve una cadena de
     * caracteres conteniendo todos los elementos del mismo, separados por un
     * guion. Si el array esta vacio, devuelve una cadena vacia.
     *
     * @param vector Vector de elementos.
     * @return Cadena de caracteres conteniendo los elementos del array.
     */
    public String strArray(int[] vector) {
        String strRetorno = "";
        if (vector.length > 0) {
            strRetorno = String.valueOf(vector[0]);
            for (int i = 1; i < vector.length; i++) {
                strRetorno += "-" + String.valueOf(vector[i]);
            }
        }
        return strRetorno;
    }

    /**
     * Metodo encargado de verificar si el conjunto de datos se encuentra
     * ordenado.
     *
     * @param vector Conjunto de datos.
     * @return booleano indicando si el vector se encuentra ordenado o no.
     */
    public boolean estaOrdenado(int[] vector) {
        boolean ordenado = true;
        for (int i = 0; i < vector.length - 1; i++) {
            if (vector[i] > vector[i + 1]) {
                ordenado = false;
                break;
            }
        }
        return ordenado;
    }
}
