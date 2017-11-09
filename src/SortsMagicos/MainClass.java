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
        int[] vector = new int[] {10,6,1,9,5,21,2,13,4,29};
        System.out.println("Inicial:");
        System.out.println(newClass.strArray(vector));
        System.out.println("Metodo:");
        newClass.quickSort2(vector);
        System.out.println("Culo:");
        System.out.println(newClass.strArray(vector));
    }
}
