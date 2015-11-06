/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.grafos.controle;

import br.univali.grafos.modelo.Arco;
import br.univali.grafos.modelo.Grafo;
import br.univali.grafos.modelo.Vertice;

/**
 *
 * @author Ailton Cardoso Jr
 */
public class Caixeiro {
    private double menor = Double.MAX_VALUE;
    private Grafo grafo;

    public Caixeiro(Grafo grafo) {
        this.grafo = grafo;
        encontraMenor();
    }
    
    public void encontraMenor(){
        for (Vertice vertice : grafo.vertices) {
            for (Arco arco : vertice.arcos) {
                double x = arco.peso;
                for (Arco arcoDestino : arco.destino.arcos) {
                    if(arcoDestino.destino.rotulo.equalsIgnoreCase(vertice.rotulo)){
                        x += arcoDestino.peso;
                        break;
                    }
                }
                if(x < menor){
                    menor = x;
                }
            }
        }
        System.out.println("Menor: " + menor);
    }
}
