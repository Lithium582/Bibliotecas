/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preparacionparcial;

import TSimpleTrie.ManejadorArchivosGenerico;
import TSimpleTrie.RandomMethods;
import TSimpleTrie.TArbolTrie;

/**
 *
 * @author R2-D2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //UT2.TA3
        //Leemos el archivo "Palabras1.txt" y creamos un trie con ellas.
        TArbolTrie trie = new TArbolTrie();
        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("src/palabras1.txt");
        for (String p : palabrasclave) {
                p = TArbolTrie.filtrarPalabra(p);
                trie.insertar(p);
        }
        //Imprimimos el Trie.
        //trie.imprimir();
        
        trie.buscar("hola");
        
        TArbolTrie banana = RandomMethods.armarArbolSufijos("panamabananas");
        banana.imprimir();
        
        
    }
    
}
