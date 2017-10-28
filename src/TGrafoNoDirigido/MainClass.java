/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TGrafoNoDirigido;

/**
 *
 * @author Facundo
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*TGrafoNoDirigido gd = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("./src/verticesBEA.txt", "./src/aristasBEA.txt",
            false, TGrafoNoDirigido.class);*/

        TGrafoNoDirigido gd = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("./src/verticesBEA2.txt", "./src/aristasBEA2.txt",
                false, TGrafoNoDirigido.class);

        
        Object[] etiquetasarray = gd.getEtiquetasOrdenado();
        String bean5 = gd.bea("j");
        System.out.println(bean5);
        
        gd.desvisitarVertices();

         
        TGrafoNoDirigido grafoYEE = gd.Primrose();
        String soyBEA = grafoYEE.bea("a");
        System.out.println(soyBEA);

        /*
        TGrafoNoDirigido grafoYEE = gd.Kruskal();
        String soyBEA = grafoYEE.bea("j");
        System.out.println(soyBEA);
         */
    }

}
