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
public class MainClass {

    public static void main(String[] args) {
        sortClass newClass = new sortClass();
        int[] vector = new int[] {6,11,9,51,21,29,13,40,10};
        System.out.println("Inicial:");
        System.out.println(newClass.strArray(vector));
        System.out.println("Metodo:");
        //int[] ordenado = newClass.cuentaPorDistribucion(vector,6,51);
        int[] baldeVector = new int[] {1,15,100,200,900,999,666,555,444,888,777,767,757,123,321,213,231};
        int[] ordenado = newClass.esUnBaldeSort(baldeVector, 10);
        
        System.out.println(newClass.strArray(ordenado));
    }
}
