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
        //System.out.println("Metodo:");
        //int[] ordenado = newClass.cuentaPorDistribucion(vector,6,51);
//        int[] baldeVector = new int[] {2345,1984,2017,16,32,42,9644,134,137,139,141,582,494,396,21};
//        int[] ordenado = newClass.esUnBaldeSort(baldeVector, 10);
//        System.out.println(newClass.strArray(ordenado));
//        
        System.out.println("Inicial:");
        //int[] radixVector = new int[] {2017,1984,2345,0,32,42,9644,134,137,139,141,582,494,396,21};
        int[] radixVector = new int[] {2017,1984,2345,0,32,42,9644,134,137,139,141,582,494,396,21};
        
        System.out.println(newClass.strArray(radixVector));
        System.out.println("Metodo:");
        int[] ordenadoRadix = newClass.RADIXSort(radixVector);
        System.out.println("RADIX:");
        System.out.println(newClass.strArray(ordenadoRadix));
    }
}
