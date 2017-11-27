/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortsMagicos;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Alf
 */
public class MainClass {

    public static void main(String[] args) {
        sortClass newClass = new sortClass();
        PruebaDate pd = new PruebaDate();
        
        //Prueba Date Radix
        /*
        try {
            FileManager fm = new FileManager();
            ArrayList<String> arrayFechas = fm.readFile("src/fechasRADIX.csv", false);
            ArrayList<Calendar> arrayCalendars = new ArrayList();

            for (String s : arrayFechas) {
                String[] fechaDividida = s.split("-");
                if (fechaDividida.length == 3) {
                    int dia = Integer.parseInt(fechaDividida[0]);
                    int mes = Integer.parseInt(fechaDividida[1]);
                    mes--;
                    int ano = Integer.parseInt(fechaDividida[2]);

                    Calendar objCal = Calendar.getInstance();
                    objCal.set(ano, mes, dia);

                    arrayCalendars.add(objCal);
                    System.out.println(objCal.getTime());
                }
            }

            Calendar[] unVectorConCalendarios = new Calendar[arrayCalendars.size()];
            arrayCalendars.toArray(unVectorConCalendarios);
            
            Calendar[] unNuevoCalArray = pd.RADIXSort(unVectorConCalendarios);
            
            System.out.println("ORDENADO?");
            for(int i = 0; i < unNuevoCalArray.length;i++){
                System.out.println(unNuevoCalArray[i].getTime());
            }

        } catch (Exception ex) {
            System.out.println("YEEEEEEEEEEEEEEEEEEEE");
        }
        */
        
        //Por cuentas
        /*
        int[] vector = new int[] {6,11,9,51,21,29,13,40,10};
        System.out.println("Inicial:");
        System.out.println(newClass.strArray(vector));
        
        int[] ordenado = newClass.cuentaPorDistribucion(vector,6,51);
        System.out.println("Metodo:");
        System.out.println(newClass.strArray(ordenado));
        
        */
        //Por RADIX
        
        int[] baldeVector = new int[] {-1,0,2345,1984,2017,16,32,42,9644,134,137,139,141,582,494,396,21};
        System.out.println("Inicial:");
        System.out.println(newClass.strArray(baldeVector));
        
        int[] ordenado = newClass.esUnBaldeSort(baldeVector, 10);
        System.out.println("Metodo:");
        System.out.println(newClass.strArray(ordenado));
    }
}

//Codigo viejo
/*
        
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
*/
