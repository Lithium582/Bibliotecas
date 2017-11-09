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
        this.vectorIncremento = new int[]{127, 17, 5, 1};
    }

    public void insercionDirecta(int[] vector) {
        for (int i = 1; i < vector.length; i++) {
            int aux = vector[i];
            int j = i - 1;
            while (j >= 0 && aux < vector[j]) {
                vector[j + 1] = vector[j];
                j--;
            }
            vector[j + 1] = aux;
        }
    }

    public void shellSort(int[] vector) {
        int indice = this.calcularVectorIncremento(vector.length);
        while (indice < this.vectorIncremento.length) {
            int incremento = this.vectorIncremento[indice];
            for (int i = incremento; i < vector.length; i++) {
                int aux = vector[i];
                int j = i - incremento;
                while (j >= 0 && aux < vector[j]) {
                    vector[j + incremento] = vector[j];
                    j -= incremento;
                }
                vector[j + incremento] = aux;
            }
            indice++;
        }
    }

    private int calcularVectorIncremento(int valor) {
        for (int i = this.vectorIncremento.length - 1; i >= 0; i--) {
            if (this.vectorIncremento[i] < valor) {
                return i;
            }
        }
        return -1;
    }

    public void bubbleSort(int vector[]) {
        for (int i = 0; i < vector.length - 1; i++) {
            for (int j = 0; j < vector.length - i - 1; j++) {
                if (vector[j] > vector[j + 1]) {
                    int aux = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = aux;
                }
            }
        }
    }

    public void quickSort2(int[] vector) {
        this.quickSort2(vector, 0, vector.length - 1);
    }

    public void quickSort2(int[] vector, int l, int h) {
        int p;
        int left = l;
        int right = h;
        if (right > l) {
            p = encuentraBigote(vector, l, h);
            
            if (p != 0) {
                while (right > left) {
                    while (vector[left] < p) {
                        left++;
                    }

                    while (vector[right] > p) {
                        right--;
                    }

                    int aux = vector[left];
                    vector[left] = vector[right];
                    vector[right] = aux;
                }
                
                quickSort2(vector, l, right-1);
                quickSort2(vector, right, h);
            }
        }
    }

    private int encuentraBigote(int[] vector, int l, int h) {
        int res = vector[l];
        for (int i = l; i <= h; i++) {
            if (res != vector[i]) {
                res = -1;
                break;
            }
        }

        //Significa que encontró claves diferentes
        if (res == -1) {
            if (vector[l] >= vector[h]) {
                return vector[l];
            }

            return vector[h];
        }

        return 0;

    }

    public void quickSort(int[] vector) {
        this.quickSort(vector, 0, vector.length - 1);
    }

    public void quickSort(int[] vector, int l, int h) {
        int p;
        if (h > l) {
            p = particionar(vector, l, h);
            quickSort(vector, l, p - 1);
            quickSort(vector, p + 1, h);
        }
    }

    private int particionar(int[] vector, int l, int h) {
        int contador;
        int p;
        int firsthigh;
        p = h;
        firsthigh = l;
        for (contador = l; contador < h; contador++) {
            if (vector[contador] < vector[p]) {
                int aux = vector[contador];
                vector[contador] = vector[firsthigh];
                vector[firsthigh] = aux;
                firsthigh++;
            }
        }
        int aux = vector[p];
        vector[p] = vector[firsthigh];
        vector[firsthigh] = aux;
        return firsthigh;
    }

    public String strArray(int[] vector) {
        String strRetorno = "";
        if (vector.length > 0) {
            strRetorno = String.valueOf(vector[0]);
            for (int i = 1; i < vector.length; i++) {
                strRetorno += "," + String.valueOf(vector[i]);
            }
        }
        return strRetorno;
    }
}
