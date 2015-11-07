
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
        
        // Trecho de codigo a seguir deve ser dinamico
        Vertice subciclo = testaSubciclo(circuito.get(0), 20, circuito.get(1));    // distancia deve ser dinamica;
        
        if (subciclo != null) { // Se e diferente de null, e porque achou um subciclo melhor
            circuito.add(circuito.indexOf(circuito.get(1)), subciclo);
        }
        
        exibeCircuito();
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
        circuito.get(0).visitado = true;
        circuito.get(1).visitado = true;
        System.out.println("Menor: " + menor + "\t" + verticeInicial.rotulo + verticeDestino.rotulo);
    }
    
    public Vertice testaSubciclo(Vertice a, double distancia, Vertice b) {
        Vertice subcicloMenor = null;
        
        for (Arco  arco: a.arcos) {
            for (Arco arcoDestino : arco.destino.arcos) {
                if (arcoDestino.destino.rotulo.equals(b.rotulo)) {
                    if (arco.peso + arcoDestino.peso - distancia <= distancia) {// Menor ou igual?
                        subcicloMenor = arco.destino;                           // Captura a referencia do vertice subciclico
                    }
                    break;
                }
            }
        }
        
        return subcicloMenor;
    }
    
    public void exibeCircuito() {
        for (Vertice vertice : circuito) {
            System.out.println(vertice.rotulo + "\t");
        }
    }
}
