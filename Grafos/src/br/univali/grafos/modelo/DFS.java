
package br.univali.grafos.modelo;

import br.univali.grafos.principal.Arco;
import br.univali.grafos.principal.MeuGrafo;
import br.univali.grafos.principal.Vertice;
import java.util.Stack;


public class DFS {
    
    Stack<Vertice> pilha = new Stack<>();
    
    public void percorrer(MeuGrafo grafo) {
        
        pilha.push(grafo.vertices.get(0));
        
        
        
        for (Vertice vertice : grafo.vertices) {
            pilha.push(vertice);
            for (Arco arco : vertice.arcos) {
                
                
                arco.verticeB;
            }
        }
    }
}
