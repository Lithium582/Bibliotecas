package TGrafoNoDirigido;

import java.util.Collection;
import java.util.LinkedList;

public class TGrafoNoDirigido extends TGrafoDirigido {

    private TAristas aristas = new TAristas();

    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
       this.aristas.setAristas(aristas);
    }
    
    public void cargarArista(Comparable etiquetaOrigen,
            Comparable etiquetaDestino, Double costo) {
        aristas.insertarAlFinal(new TArista(etiquetaOrigen, etiquetaDestino,
                costo));
        aristas.insertarAlFinal(new TArista(etiquetaDestino, etiquetaOrigen,
                costo)); // para que no falle la busqueda del min y destino
        insertarAdyacencia(etiquetaOrigen, etiquetaDestino, costo);
    }

    // este procedimiento de PRIM usa la lista de aristas expl�cita para
    // resolver. Por claridad y seguridad, se arman listas de v�rtices para
    // trabajar,
    // "VerticesU" y "VerticesV", de forma de hacerlo lo m�s parecido posible al
    // seudoc�digo abstracto.
    // al final devuelve un nuevo grafo no dirigido que es el �rbol abarcador de
    // costo m�nimo obtenido.
    
   public TGrafoNoDirigido Prim() {
        // devuelve un nuevo grafo, que es el Arbol Abarcador de Costo M�nimo
        int costoPrim = 0;
        LinkedList<TVertice> VerticesU = new  LinkedList<TVertice>();
        LinkedList<TVertice> VerticesV = new  LinkedList<TVertice>();
        LinkedList<TArista> AristasAAM = new  LinkedList<TArista>();
        TArista tempArista;
        
        if (this.getVertices().isEmpty()) {
            return null;
        }
       // TVertice tempV;
       /* int i = 0;
        tempV =  auxV.get(i);
        // armar la lista VerticesV de trabajo
        while (!(tempV == null)) {
            VerticesV.add(tempV);
            i++;
            tempV = auxV.get(i);
	}*/
        Collection<TVertice> auxV = this.getVertices().values();
        for(TVertice v : auxV)
        {
            VerticesV.add(v);
            
        }
        // pasar el primero de V a U
        VerticesU.addLast(VerticesV.remove());
        boolean vaciaV = VerticesV.isEmpty();
        while (!vaciaV) {
            tempArista = aristas.buscarMin(VerticesU, VerticesV);
            costoPrim += tempArista.getCosto();
            // elegir una arista de costo minimo que vaya de U a V, agregarla a
            // la lista de aristas del AAM, quitar el v�rtice v de V y agregarlo
            // a U
            AristasAAM.add(tempArista);
            int i = 0;
            for(TVertice v : VerticesV)
            {
                if(v.getEtiqueta().equals(tempArista.getEtiquetaDestino()))
                {
                    break;
                }
                i++;
            }
            VerticesU.addLast(VerticesV.remove(i));
            vaciaV = VerticesV.isEmpty();
        }
        System.out.println("costo AAM: " + costoPrim);
        TGrafoNoDirigido nuevoGrafo = new TGrafoNoDirigido(VerticesU,AristasAAM);
        return nuevoGrafo;
    }
   
    @SuppressWarnings("rawtypes")
    public boolean insertarAdyacencia(Comparable etiquetaOrigen,
            Comparable etiquetaDestino, Double costo) {
        TArista aristaOrigen = new TArista(etiquetaOrigen, etiquetaDestino, costo);
        TArista aristaDestino = new TArista(etiquetaDestino, etiquetaOrigen, costo);
        return (this.insertarArista(aristaOrigen) && this.insertarArista(aristaDestino));
    } 
    
    @Override
    public boolean insertarArista(TArista arista) {
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(),vertDestino)&& vertDestino.insertarAdyacencia(arista.getCosto(), vertOrigen);
            }
        }
        return false;
    }
    
    public boolean esConexo()
    {
      Collection<TVertice> ver =  this.getVertices().values();
       boolean esConexo = true;
    
        for(TVertice v : ver )
        {
            for(TVertice u : ver )
            {
                if(v.getEtiqueta()!= u.getEtiqueta()){
                    if(aristas.buscar(v.getEtiqueta(), u.getEtiqueta())!= null)
                    {
                        esConexo = esConexo && true;

                    }
                    else
                    {
                        esConexo = false;
                    } 
                }
            }
        } 
     return esConexo;       
    }
    
    public String bea() {

        if (this.getVertices().isEmpty()) {
            return "El grafo está vacio";
        } else {
            for (TVertice vertV : this.getVertices().values()) {
                if (!vertV.getVisitado()) {
                   return  vertV.bea();
                }
            }
        }
      return "El grafo está vacio";
    }
    
    public TGrafoNoDirigido Kruskal(){
        
        TAristas arist = aristas;
        LinkedList<TArista> Aristas = new  LinkedList<TArista>();
        Collection<TVertice> V = this.getVertices().values();
        TGrafoNoDirigido nuevoGrafo = new TGrafoNoDirigido(V,Aristas);
        
        while(Aristas.size()<V.size()-1){
            TArista a = arist.Buscarmenor();
            arist.getAristas().remove(a);
            ///dados 2 vertizes necesito saber si ya tengo un camino entre esos 2
            ///si no estan conectados agrego la arista
            ///si estan conectados la quito no la agrego
              
                       nuevoGrafo.insertarArista(a);
            
            
            arist.getAristas().remove(a);
            
        }
        return nuevoGrafo;
        
    }
}
