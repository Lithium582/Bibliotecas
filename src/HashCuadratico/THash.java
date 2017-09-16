/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashCuadratico;

/**
 *
 * @author Ignacio
 */
public class THash {
    
    private final int[] lista;
    public int size;
    
    public THash(int tamaño, Double factor){
        Double t = tamaño / factor;
        while(!esPrimo(t.intValue())) t++;
        this.size = 0;
        this.lista = new int[t.intValue()];
    }
    
    public int getSizeLista(){
        return this.lista.length;
    }
    
    private boolean esPrimo(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public int buscar(int unaClave){
        int contador = 0;
        int i = 0;
        int a = 0;
        int pos = funcionHashing(unaClave);
        while(lista[pos] != 0 && a < lista.length){
            i++;
            a = i*i;
            pos = (pos + a) % lista.length;
            contador++;
        }
        if (a > lista.length){
            return (-contador);
        }
        else{
            return contador;
        }
    }
    
    public int insertar(int unaClave){
        int contador = 1;
        int i = 0;
        int a = 0;
        int pos = funcionHashing(unaClave);
        while(lista[pos] != 0 && a < lista.length){
            i++;
            a = i*i;
            pos = (pos + a) % lista.length;
            contador++;
        }
        if (a > lista.length){
            return (-contador);
        }
        else{
            this.lista[pos] = unaClave;
            size++;
            return contador;   
        }
    }
    
    public int funcionHashing(int unaClave){
        int total = 0;
        for (int i = 2; i < unaClave; i++){
            total = (total + unaClave % i) % i;
        }
        return total % lista.length;
    }
}