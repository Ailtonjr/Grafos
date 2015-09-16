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
        while (true) {            
            
        } 
    }
    
    private void percorre(Vertice verticeAtual){
        for (Arco arco : verticeAtual.arcos) {
            
        }
            //para cada adjacente{
		//se estimativa esta vazia{
			//define estimativa
			//define precedente
		//}senao se estimativa atual for menor que a anterior{
		//	atualiza estimativa
		//	atualiza precedente
		//}
           // }
    }
}
