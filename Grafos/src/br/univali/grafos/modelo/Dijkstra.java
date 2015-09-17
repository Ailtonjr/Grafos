/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.grafos.modelo;

import br.univali.grafos.principal.Arco;
import br.univali.grafos.principal.MeuGrafo;
import br.univali.grafos.principal.Vertice;

/**
 *
 * @author Ailton Jr
 */
public class Dijkstra {
    
    public void busca(MeuGrafo grafo, String rotulo) {
        grafo.vertices.get(0).estimativa = 0;
        grafo.vertices.get(0).precedente = grafo.vertices.get(0).rotulo;
        percorre(grafo.vertices.get(0));
        while (true) {            
            
        } 
    }
    
    private void percorre(Vertice verticeAtual){
        for (Arco arco : verticeAtual.arcos) {
            if(arco.destino.estimativa == -1){
                arco.destino.estimativa = arco.peso;
                arco.destino.precedente = arco.origem.rotulo;
            }else if(arco.destino.estimativa > arco.peso){
                arco.destino.estimativa = arco.peso;
                arco.destino.precedente = arco.origem.rotulo;
            }
        }
    }
}
