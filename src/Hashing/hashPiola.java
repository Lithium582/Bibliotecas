
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashing;

/**
 *
 * @author Bettina
 */
public class hashPiola {
    String[] T;
    int m;
    
    public String buscarHash(int clave){
        String[] v = ManejadorArchivosGenerico.leerArchivo("src/claves_buscar.txt");
        int i = 0;
        boolean encontrado = false;
        int comparaciones = 0;
        int n = 10;
        while (i < n && encontrado == false){
            if (v[i].equals(clave)){
                encontrado = true;
                return v[i];
            }
            else{
                i += 1;
            }
           comparaciones += 1;
        }
        return "";
    }
    
    public int insertarHash(int clave){
        int i = 0;
        int contador = 0;
        int j = this.funcionHash(clave);
        while (T[j].isEmpty()|| i==m){
            if (T[j].isEmpty()){
                return contador;
            }
            else{
                i++;
            }
            contador++;
        }
        return 0;
    }
    
    public int funcionHash(int clave){
        return 1;
    }
}