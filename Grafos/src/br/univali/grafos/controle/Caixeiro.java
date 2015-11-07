
package br.univali.grafos.controle;

import br.univali.grafos.modelo.Arco;
import br.univali.grafos.modelo.Grafo;
import br.univali.grafos.modelo.Vertice;
import java.util.ArrayList;
import java.util.List;


public class Caixeiro {
    private double menor = Double.MAX_VALUE;
    private Grafo grafo;
    private List<Vertice> circuito = new ArrayList();

    public Caixeiro(Grafo grafo) {
        this.grafo = grafo;
        encontraMenor();
        testaSubciclo();
    }
    
    public void encontraMenor(){
        Vertice verticeInicial = null;
        Vertice verticeDestino = null;
        Vertice aux = null;
        
        for (Vertice vertice : grafo.vertices) {
            for (Arco arco : vertice.arcos) {
                double x = arco.peso;
                for (Arco arcoDestino : arco.destino.arcos) {
                    if(arcoDestino.destino.rotulo.equalsIgnoreCase(vertice.rotulo)){
                        x += arcoDestino.peso;
                        aux = arcoDestino.origem;
                        break;
                    }
                }
                if(x < menor){
                    menor = x;
                    verticeInicial = vertice;
                    verticeDestino = aux;
                }
            }
        }
        circuito.add(verticeInicial);
        circuito.add(verticeDestino);
        System.out.println("Menor: " + menor + "\t" + verticeInicial.rotulo + verticeDestino.rotulo);
    }
    
    public void testaSubciclo() {
        
    }
}
